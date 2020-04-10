package com.erasr.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0 ; i < 5 ; i ++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 888);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.set(0, 0);
        System.out.println(linkedList);

        System.out.println(linkedList.get(linkedList.getSize() - 1));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

    }
}
