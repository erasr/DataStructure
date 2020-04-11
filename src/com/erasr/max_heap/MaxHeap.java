package com.erasr.max_heap;

/**
 * @program: DataStructure
 * @description: 最大堆
 * @author: xuguangwei
 * @create: 2020-04-11 20:41
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;
    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }
    public MaxHeap() {
        data = new Array<>();
    }

    //返回堆中元素的个数
    public int size() {
        return data.getSize();
    }

    //返回堆是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn`t hava parent!");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }

}
