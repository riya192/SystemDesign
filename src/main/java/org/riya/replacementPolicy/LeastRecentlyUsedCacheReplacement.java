package org.riya.replacementPolicy;

import org.riya.dataStructures.DoublyLinkedList;
import org.riya.dataStructures.DoublyLinkedListNode;
import org.w3c.dom.Node;

import java.util.*;

public class LeastRecentlyUsedCacheReplacement<Key> implements CacheReplacement<Key>{

    DoublyLinkedList<Key> cacheDll;
    Map<Key, DoublyLinkedListNode<Key>> nodeMap;

    public LeastRecentlyUsedCacheReplacement()
    {
        cacheDll = new DoublyLinkedList<>();
        nodeMap = new HashMap<>();
    }

    /*
    access key method is called to manage the priority order of cache
     */
    @Override
    public boolean accessKey(Key key, boolean newKey){
        if(newKey)
        {
            DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<>(key);
            cacheDll.addElementToHead(node);
            nodeMap.put(key, node);
        }else {
            cacheDll.moveElementToHead(nodeMap.get(key));
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
