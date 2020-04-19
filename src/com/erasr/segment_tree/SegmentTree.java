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
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for(int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[])new Object[4 * arr.length];
        buildSegmentFree(0, 0, data.length - 1);
    }

    /** l, r的含义：对于treeIndex这个节点所表示的那个线段或区间的左右端点是什么
     *
     */
    private void buildSegmentFree(int treeIndex, int l, int r) {
        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;

        buildSegmentFree(leftChildIndex, l, mid);
        buildSegmentFree(rightChildIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);
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

    public E query(int queryL, int queryR) {
        if(queryL < 0 || queryL >= data.length
            || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is Illegal!");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if(l == queryL && r == queryR) {
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if(queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if(queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
    }

    public void set(int index, E e) {
        if(index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is Illegal");
        }
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    //将index位置的值更新为e
    private void set(int treeIndex, int l, int r, int index, E e) {

        if(l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        //一种「倒序遍历」的思想
        if(index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0; i < tree.length; i++) {
            if(tree[i] == null) {
                res.append("null");
            } else {
                res.append(tree[i]);
            }

            if(i != tree.length - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}




