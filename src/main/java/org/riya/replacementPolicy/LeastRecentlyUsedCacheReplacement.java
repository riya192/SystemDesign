package org.riya.replacementPolicy;

import org.riya.dataStructures.DoublyLinkedList;
import org.riya.dataStructures.DoublyLinkedListNode;

import java.util.ArrayList;
import java.util.List;

public class LeastRecentlyUsedCacheReplacement<Key> implements CacheReplacement<Key>{

    DoublyLinkedList<Key> cacheDll;

    public LeastRecentlyUsedCacheReplacement()
    {
        cacheDll = new DoublyLinkedList<>();
    }

    /*
    access key method is called to manage the priority order of cache
     */
    @Override
    public boolean accessKey(Key key, boolean newKey){
        if(newKey)
        {
            cacheDll.addElementToHead(new DoublyLinkedListNode<>(key));
        }else {
            cacheDll.moveElementToHead(key);
        }
        return true;
    }

    @Override
    public Key evict() {
        Key tailKey = cacheDll.getTail().getNodeVal();
        cacheDll.removeElementFromTail();
        return tailKey;
    }

    @Override
    public List<Key> getCachePriorityOrder() {
        DoublyLinkedListNode<Key> node = cacheDll.getHead();
        List<Key> result = new ArrayList<>();
        while(node!=null)
        {
            result.add(node.getNodeVal());
            node = node.getNext();
        }
        return result;
    }
}
