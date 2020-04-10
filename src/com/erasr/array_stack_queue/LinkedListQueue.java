package com.erasr.array_stack_queue;

public class LinkedListQueue<E> implements Queue<E> {

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

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public void enqueue(E e) {
        //如果队列为空， 那么要将 head 也要给赋值一下为 tail
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            new IllegalArgumentException("cannot dequeue form an empty queue!");
        }
        Node ret = head;
        head = head.next;
        ret.next= null;
        if(head == null) {
            tail = null;
        }
        size --;
        return ret.e;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("Queue : front ");
        Node cur = head;
        while(cur != null) {
            ret.append(cur + "->");
            cur = cur.next;
        }
        ret.append("Null tail");
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<Integer>();
        for(int i = 0 ; i < 10 ; i ++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);

            if(i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }

}
