package com.erasr.array_stack_queue;

public interface Stack<E> {

    void push(E e);
    E pop();
    E peek();
    int getSize();
    boolean isEmpty();
}
