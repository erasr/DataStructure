package com.erasr.segment_tree;

/**
 * @program: DataStructure
 * @description: 线段树
 * @author: xuguangwei
 * @create: 2020-04-16 16:57
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    public SegmentTree(E[] arr) {
        data = (E[])new Object[arr.length];
        for(int i = 0; i < data.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is Illegal!");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中，一个索引index所表示的元素的左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组表示中，一个索引index所表示的元素的右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
