package com.company;

public class Array {

    //定义整型数组data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    //插入元素：头插、尾插
    public boolean insert(int index, int value) {
        if (count == n) {
            System.out.println("数组已满，无可插入位置");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("插入位置不合法");
            return false;
        }

        //插入位置已有数据时，将该位置及之后的位置上的元素向后移一位
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            System.out.println("不正确的位置！");
            return false;
        }
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        int[] arr = new int[count - 1];
        for (int i = 0; i < count - 1; i++) {
            arr[i] = data[i];
        }
        this.data = arr;
        --count;
        return true;
    }

    public int size() {
        return count;
    }

    public void printAll(){
        for(int i = 0;i<count;i++){
            System.out.println(data[i]);
        }
    }
}
