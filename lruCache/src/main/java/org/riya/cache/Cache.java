package org.riya.cache;

import org.riya.dataStructures.HashMapCacheStorage;
import org.riya.replacementPolicy.CacheReplacement;

public interface Cache<Key, Value>{


    //TODO: how here can you use a composition? is there a need? should I make this an abstract class with storage and replacement policy to be changed in setters
    Value getFromCache(Key key);

    void putInCache(Key key, Value value);

    void printCache();
}
