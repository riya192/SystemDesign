package org.riya.replacementPolicy;

import java.util.List;

public interface CacheReplacement<Key> {

    public boolean accessKey(Key key, boolean newKey) ;

    public Key evict();

    public List<Key> getCachePriorityOrder();

}
