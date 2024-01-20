package org.riya.cache;

import org.riya.dataStructures.HashMapCacheStorage;
import org.riya.dataStructures.exception.StorageFullException;
import org.riya.replacementPolicy.LeastRecentlyUsedCacheReplacement;
import org.riya.replacementPolicy.exception.PageFault;

import java.util.List;

public class LRUCache<Key, Value> implements Cache<Key, Value>{

    private final LeastRecentlyUsedCacheReplacement<Key> cacheReplacement;
    private final HashMapCacheStorage<Key, Value> cacheStorage;

    public LRUCache(int capacity)
    {
        cacheStorage = new HashMapCacheStorage<>(capacity);
        cacheReplacement = new LeastRecentlyUsedCacheReplacement<>();
    }

    @Override
    public Value getFromCache(Key key) {
        try{
            Value val = this.cacheStorage.get(key);
            if(val!= null)
            {
                this.cacheReplacement.accessKey(key, false);
            }
            return val;
        }catch (PageFault pageFaultException)
        {
            System.out.println("Page Fault - Value not in cache, please update cache");
            return null;
        }
    }

    @Override
    public void putInCache(Key key, Value value) {
        try{
            this.cacheStorage.put(key,value);
            this.cacheReplacement.accessKey(key, true);

        }catch (StorageFullException storageFullException)
        {
            System.out.println("Storage Full Detected, Evicting the least recently used value");
            Key toBeEvicted = this.cacheReplacement.evict();
            System.out.println("Evicting key - " + toBeEvicted.toString() + "Value - " + this.cacheStorage.get(toBeEvicted));
            this.cacheStorage.remove(toBeEvicted);
            putInCache(key, value);
        }
    }

    @Override
    public void printCache() {
        List<Key> cachePriorityOrder = this.cacheReplacement.getCachePriorityOrder();
        for(Key key: cachePriorityOrder)
        {
            System.out.println("Cache key - " + key.toString() + " with Value - " + this.cacheStorage.get(key).toString());
        }
    }
}
