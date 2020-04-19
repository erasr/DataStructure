package com.LeetCode;

import com.erasr.segment_tree.SegmentTree;

/**
 * @program: DataStructure
 * @description: LeetCode第303号问题
 * @author: xuguangwei
 * @create: 2020-04-17 17:22
 */
public class Num303 {

    private SegmentTree<Integer> segTree;
    public Num303(int[] nums) {
        if(nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for(int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segTree = new SegmentTree<>(data, (a, b) -> a + b);
         }

    }

    public int sumRange(int i, int j) {
        if(segTree == null) {
            throw new IllegalArgumentException("Segment tree is null");
        }
        return segTree.query(i, j);
    }
}
