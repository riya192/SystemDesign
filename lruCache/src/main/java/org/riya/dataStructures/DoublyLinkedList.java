package org.riya.dataStructures;

import lombok.Getter;

@Getter
public class DoublyLinkedList<Key> {

    private DoublyLinkedListNode<Key> head;
    private DoublyLinkedListNode<Key> tail;

    public DoublyLinkedList()
    {
        tail= null;
        head=null;
    }
    // 4->1->2->3->5
    // 4<-1<-2<-3<-5

    public void addFirstElement(DoublyLinkedListNode<Key> node)
    {
        head = node;
        tail = node;
    }
    public void addElementToHead(DoublyLinkedListNode<Key> node)
    {
        if(head == null) {
            addFirstElement(node);
            return;
        };
        node.setNext(head);
        node.setPrev(null);
        head.setPrev(node);
        head = node;
    }

    public void addElementToTail(DoublyLinkedListNode<Key> node)
    {
        if(tail == null){
            addFirstElement(node);
            return;
        };
        node.setPrev(tail);
        tail.setNext(node);
        node.setNext(null);
        tail=node;
    }

    public void removeElementFromTail(){
        DoublyLinkedListNode<Key> tailPrev = tail.getPrev();
        tailPrev.setNext(null);
        tail=tailPrev;
    }

    // 4->1->2->3->5
    // 4<-1<-2<-3<-5
    public void moveElementToHead(DoublyLinkedListNode<Key> node)
    {
        if(head.getNodeVal() == node.getNodeVal()) return;
        DoublyLinkedListNode<Key> currPrev = node.getPrev();
        DoublyLinkedListNode<Key> currNext=node.getNext();
        currPrev.setNext(currNext);
        if (currNext != null) {
            currNext.setPrev(currPrev);
        } else {
            this.tail = currPrev;
        }
        this.addElementToHead(node);
    }

}
