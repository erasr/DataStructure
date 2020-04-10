package com.erasr.array_stack_queue;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    E getFront();
    void enqueue(E e);
    E dequeue();
}
