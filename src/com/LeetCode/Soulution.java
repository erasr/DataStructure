package com.LeetCode;

import java.util.TreeSet;
/**
 * @program: DataStructure
 * @description: LeetCode 唯一摩尔斯密码词
 * @author: xuguangwei
 * @create: 2020-03-17 10:26
 */
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet set = new TreeSet();

        for(String word : words) {
            StringBuilder ret = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                ret.append(codes[word.charAt(i) - 'a']);
            }
            set.add(ret.toString());
        }
        return set.size();
    }
}