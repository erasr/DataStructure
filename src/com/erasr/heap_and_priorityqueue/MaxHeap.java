package com.erasr.heap_and_priorityqueue;

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
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        if(arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--) {
                siftDown(i);
            }
        }
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

    //向堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    //「上浮」操作
    private void siftUp(int k) {

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //看堆中最大的元素
    public E findMax() {
        if(data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMax when heap is empty!");
        }
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    //「下沉」操作
    private void siftDown(int k) {
        //当 左孩子的下标比数组的长度小时，说明k还不是叶子节点
        //当k不是叶子节点时
        while(leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            //有右孩子 并且 右孩子的值比左孩子大
            if(j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j ++;//等同于 j = rightChild(k);
            }

            //此时，j代表的是k的孩子中，值最大的那个孩子
            //当，j的值比k的值小时，则k已经是调到了合适的位置
            if(data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            //否则，就要交换k和j的值
            data.swap(j, k);

            k = j;
        }
    }

    //取出堆中最大的元素， 并且替换成元素e
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }
}
