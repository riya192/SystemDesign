package org.riya.dataStructures;

import org.riya.dataStructures.exception.StorageFullException;
import org.riya.replacementPolicy.exception.PageFault;

import java.util.HashMap;

public class HashMapCacheStorage<Key, Value> extends HashMap<Key, Value> {

    private final int capacity;
    public HashMapCacheStorage(int capacity)
    {
        super(capacity);
        this.capacity = capacity;
    }

    public boolean isStorageFull()
    {
        return this.size() >= capacity;
    }

    @Override
    public Value get(Object key) {
        if(super.containsKey(key)) return super.get(key);
        throw new PageFault();
    }

    @Override
    public Value put(Key key, Value value) {
        if(isStorageFull()) throw new StorageFullException();
        return super.put(key, value);
    }
}
