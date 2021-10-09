package com.company;

/*
循环队列
 */
public class CircularQueue {
    //数组：items，大小：n
    private String[] items;
    private int n = 0;

    //head表示队首下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    //默认创建容量为10的数组
    public CircularQueue() {
        this(10);
    }

    //入队
    public boolean enqueue(String item) {
        //%取余，/取相除后的结果
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue(){
        //head == tail表示队列为空
        if(head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll(){
        if(0 == n) return;
        for(int i = head;i % n != tail;i = (i + 1 ) % n){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
