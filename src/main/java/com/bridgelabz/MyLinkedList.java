package com.bridgelabz;

public class MyLinkedList<K> {
    public INode<K> head;
    public INode<K> tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode<K> newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode<K> tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }

    public void printMyNode() {
        StringBuffer myNodes = new StringBuffer("My Nodes: ");
        INode tempNode = head;
        while (tempNode.getNext() != null) {
            myNodes.append(tempNode.getKey());
            if (!tempNode.equals(tail))
                myNodes.append("->");
            tempNode = tempNode.getNext();
        }
        myNodes.append(tempNode.getKey());
        System.out.println(myNodes);
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + "}";
    }

    public void append(INode<K> myNode) {
        if (this.tail == null) {
            this.tail = myNode;
        }
        if (this.head == null) {
            this.head = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    public void insert(INode<K> myNode, INode<K> newNode) {
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);
        newNode.setNext(tempNode);
    }

    public INode<K> pop() {
        INode tempNode = this.head;
        this.head = head.getNext();
        return tempNode;

    }

    public INode<K> popLast() {
        INode tempNode = this.head;
        while (!tempNode.getNext().equals(tail)) {
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
        return tempNode;
    }

    public INode<K> search(K key) {
        INode tempNode = head;
        while (tempNode != null && tempNode.getNext() != null) {
            if (tempNode.getKey().equals(key)) {
                return tempNode;
            } else {
                tempNode = tempNode.getNext();
            }
        }
        return null;
    }

    public void removeParticularNode(INode<K> deleteNode) {
        INode tempNode = this.head;
        INode prev = null;
        while (tempNode != null && tempNode.getKey() != deleteNode.getKey()) {
            prev = tempNode;
            tempNode = tempNode.getNext();
        }
        prev.setNext(tempNode.getNext());
        tempNode.setNext(null);
    }

    public int size() {
        int size = 0;
        INode n = head;
        while (n != null) {
            size++;
            n = n.getNext();
        }
        return size;
    }

    public static <K extends Comparable<K>> boolean maximum(K x, K y) {
        K max = x;
        if (y.compareTo(max) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public <K extends Comparable<K>> void sortList() {
        INode<K> current = (INode<K>) this.head;
        INode<K> index = null;
        K temp;
        if (this.head == null)
            return;
        else {
            while (current != null) {
                index = current.getNext();
                while (index != null) {
                    if (maximum(index.getKey(), current.getKey())) {
                        temp = current.getKey();
                        current.setKey(index.getKey());
                        index.setKey(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }
}