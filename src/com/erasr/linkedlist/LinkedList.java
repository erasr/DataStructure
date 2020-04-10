package com.erasr.linkedlist;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            new IllegalArgumentException("Add failed! index is illegal!");
        }

        Node priv = dummyHead;
        for(int i = 0 ; i < index ; i ++) {
            priv = priv.next;
        }
//            Node node = new Node(e);
//            node.next = priv.next;
//            priv.next = node;

        priv.next = new Node(e, priv.next);
        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if(index < 0 || index > size) {
            new IllegalArgumentException("Get failed! index is illegal!");
        }

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++) {
            cur = cur.next;
        }

        Node retNode = cur;
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if(index < 0 || index > size) {
            new IllegalArgumentException("Set failed! index is illegal!");
        }

        Node cur = dummyHead.next;
        for(int i = 0 ; i < index ; i ++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;

        while(cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }

        return false;
    }

    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;

        for(int i = 0 ; i < index ; i ++) {
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while(prev.next != null) {
            if(e.equals(prev.next.e)) {
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("LinkedList : ");
        for(Node cur = dummyHead.next ; cur != null ; cur = cur.next) {
            ret.append(cur.e);
            ret.append("->");
        }
        ret.append("NULL");
        return ret.toString();
    }
}
