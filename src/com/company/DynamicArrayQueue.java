package com.company;

/*
动态数组队列
 */
public class DynamicArrayQueue {
    //数组：items，容量：n
    private String[] items;
    private int n = 0;

    //head表示队首下标，tail表示队尾下标，队首出队，队尾入队
    private int head = 0;
    private int tail = 0;

    //申请一个容量为capacity的数组
    public DynamicArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    //默认容量为10
    public DynamicArrayQueue(){
        this(10);
    }

    //入队操作，将元素放入队尾
    public boolean enqueue(String item){
        //tail == n表示队尾没有空间了
        if (tail == n) {
            //head == 0 && tail == n表示队列已经存满了
            if (head == 0) {
                return false;
            }
            //队列有空元素，将数据搬迁到数据起始位置
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            //搬迁结束后更新head和tail
            tail -= head;
            head = 0;
        }
        items[tail++] = item;
        return true;
    }

    //出队
    public String dequeue(){
        //head == tail表示队列为空
        if (head == tail) return null;
        String ret = items[head++];
        return ret;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]);
        }
        System.out.println();
    }
}
