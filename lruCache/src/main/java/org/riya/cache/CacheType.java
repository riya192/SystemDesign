package org.riya.cache;

public enum CacheType {

    LRU("LRU"),
    FIFO("FIF)");
    private final String cacheName;

    CacheType(String cacheName) {
        this.cacheName = cacheName;
    }


}
