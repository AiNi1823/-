package com.company;

/*
基于数组实现的队列
 */
public class QueueBasedOnArray {

    //数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    //head表示队首下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    //申请一个容量为capacity的数组
    public QueueBasedOnArray(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    //默认创建容量为10的数组
    public QueueBasedOnArray(){
        this(10);
    }

    //入队，可改进为可自动扩容、缩容的形式
    public boolean enqueue(String item) {
        //如果tail == n，表示队列已经满了
        if(tail == n) return false;
        items[tail++] = item;
        return true;
    }

    //出队
    public String dequeue(){
        if(head == 0) return null;
        String ret = items[head++];
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
