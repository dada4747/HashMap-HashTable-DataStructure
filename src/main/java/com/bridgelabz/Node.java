package com.bridgelabz;

public class Node<K> implements INode<K>{
    private Node next;
    private K key;

    public Node(K key){
        this.key = key;
        this.next = null;
    }
    public K getKey() {
        return key;
    }

    @Override
    public void setKey(K key) {

    }

    public void setkey(K key) {
        this.key = key;
    }

    public INode<K> getNext() {
        return next;
    }

    public void setNext(INode next) {
        this.next = (Node<K>)next;
    }
}
