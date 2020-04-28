package com.erasr.set_and_map;

import java.util.ArrayList;

/**
 * @program: DataStructure
 * @description: 基于bst的set
 * @author: xuguangwei
 * @create: 2020-04-02 14:23
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;
    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("src/com/erasr/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }
    }
}
