package com.erasr.trie;

/**
 * @program: DataStructure
 * @description: 测试类
 * @author: xuguangwei
 * @create: 2020-04-20 10:14
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"panda", "pan", "dog", "deer", "pan"};
        for(String word : words) {
            trie.add(word);
        }

        for(String word : words) {
            if(trie.contains(word)) {
                System.out.println("contains");
            } else {
                System.out.println("not");
            }
        }
    }
}
