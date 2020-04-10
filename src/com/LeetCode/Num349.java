package com.LeetCode;

import java.util.ArrayList;
import java.util.TreeSet;
/**
 * @program: DataStructure
 * @description: LeetCode349号题
 * @author: xuguangwei
 * @create: 2020-04-09 16:40
 */
public class Num349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(Integer num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer num : nums2) {
            if(set.contains(num)) {
                list.add(num);
                //因为相同的数字只是统计一次，所以出现过一次以后将其删除就好
                set.remove(num);
            }
        }

        int[] nums = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
