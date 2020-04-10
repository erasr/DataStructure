package com.erasr.array_stack_queue;

public class Array<E> {

    private E[] data;
    // 盛放数据个数
    private int size;

    //构造函数
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return data.length;
    }

    // 获取数组中的元素个数
    public int getSize() {
        return size;
    }

    // 在index索引的位置插入一个新元素e
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add fail.下标不合法");
        }

        if(size == data.length) {
            resize(data.length * 2);
        }

        for(int i = size - 1 ; i >= index ; i --) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    //在数组末尾添加一个新的元素
    public void addLast(E e) {
        add(size, e);
    }

    //在数组首部添加一个新的元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 获取index索引位置的元素
    public E get(int index){
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Get failed. Index illegal!");
        }

        return data[index];
    }

    //获取第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改index索引位置的元素为e
    public void set(int index, E e){
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("get error. Index illegal");
        }

        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++) {
            if(e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    //数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 从数组中删除index位置的元素, 返回删除的元素
    public E remove (int index) {
        if(index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Remove is failed. Index is illegal.");
        }

        E ret = data[index];
        /**注意这个 i 的取值范围
         * for(int i = index; i < size ; i ++) {
         *             data[i] = data[i + 1];
         *         }
         * 这样写的话，这里的 i < size 和 data[i + 1] 会使数组下标越界
         */
        for(int i = index + 1; i < size ; i ++) {
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for(int i = 0 ; i < size ; i ++) {
            if(e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    // 将数组空间的容量变成newCapacity大小
    public void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for(int i = 0 ; i < size ; i ++) {
            res.append(data[i]);
            if(i != size - 1) {
                res.append(", ");

            }
        }
        res.append("]");
        return res.toString();
    }
}
