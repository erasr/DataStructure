package com.erasr.array_stack_queue;

public class LinkedListStack<E> implements Stack<E> {
    private LinkedList list;

    public LinkedListStack() {
        list = new LinkedList();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return (E)list.removeFirst();
    }

    @Override
    public E peek() {
        return (E)list.getFirst();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("LinkedListStack : top ");
        ret.append(list);
        return ret.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> linkedList = new LinkedListStack<>();
        for(int i = 0 ; i < 5 ; i ++) {
            linkedList.push(i);
            System.out.println(linkedList);
        }

        System.out.println(linkedList.pop());
        System.out.println(linkedList);

    }
}
