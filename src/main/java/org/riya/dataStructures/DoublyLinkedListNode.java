package org.riya.dataStructures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoublyLinkedListNode<Key> {

    private Key nodeVal;
    private DoublyLinkedListNode<Key> prev;

    private DoublyLinkedListNode<Key> next;
    public DoublyLinkedListNode(Key node)
    {
        this.nodeVal = node;
        this.prev = null;
        this.next = null;
    }

    public DoublyLinkedListNode(Key node, DoublyLinkedListNode<Key> previous, DoublyLinkedListNode<Key> next)
    {
        this.nodeVal = node;
        this.prev = previous;
        this.next = next;
    }

}
