package org.riya;

import org.riya.cache.Cache;
import org.riya.cache.CacheFactory;
import org.riya.cache.CacheType;
import org.riya.cache.LRUCache;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Testing LRU Cache!");

        CacheFactory<Integer, String> cacheFactory = new CacheFactory<>();
        Cache<Integer, String> lruCache = cacheFactory.getCacheInstance(CacheType.LRU, 3);

        lruCache.putInCache(1, "riya");


        lruCache.getFromCache(2);

        lruCache.putInCache(2, "harsh");

        lruCache.putInCache(3, "awinash");

        //3 -> 2-> 1

        lruCache.getFromCache(1);

        lruCache.printCache();

        //1-> 3-> 2

        lruCache.putInCache(4, "manju");
        //4->1->3

        lruCache.printCache();


    }
}