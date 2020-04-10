package com.erasr.set_and_map;

import java.util.ArrayList;

/**
 * @program: DataStructure
 * @description: 对比基于链表和二分搜索树的集合
 * @author: xuguangwei
 * @create: 2020-04-02 16:27
 */
public class TestSet {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(filename, words1)) {
            for (String word : words1)
                set.add(word);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "src/com/erasr/set_and_map/pride-and-prejudice.txt";
        BSTSet<String> bstSet = new BSTSet<>();
        System.out.println(testSet(bstSet, filename));

        LinkedListSet<String> linkedListSet = new LinkedListSet<>();
        System.out.println(testSet(linkedListSet, filename));
    }
}
