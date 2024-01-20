package org.riya.cache;

public class CacheFactory<Key, Value> {
/*
Following factory design pattern, where this factory class is taking care of returning the Cache instance
instead of everyone creating their own instances.
Any updates to the LRUCache instance or if the impl changes can be handled internally
 */
    public Cache<Key, Value> getCacheInstance(CacheType cacheType, int capacity){
        Cache<Key, Value> cache ;
        if(cacheType.equals(CacheType.LRU))
        {
            cache = new LRUCache<>(capacity);
            return cache;
        }
        return null;
    }

}
