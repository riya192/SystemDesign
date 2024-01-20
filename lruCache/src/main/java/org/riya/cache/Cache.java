package org.riya.cache;

import org.riya.dataStructures.HashMapCacheStorage;
import org.riya.replacementPolicy.CacheReplacement;

public interface Cache<Key, Value>{

    public Value getFromCache(Key key);

    public void putInCache(Key key, Value value);

    public void printCache();
}
