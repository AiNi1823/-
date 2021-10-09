package com.company;

/*
基于链表实现的栈
先进后出
 */
public class StackBasedOnLinkedList {

    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value,null);

        //判断是否栈空
        if(top==null){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        //空栈时返回-1
        if(top == null) return -1;
        int value = top.getData();
        top = top.next;
        return value;
    }

    public void printAll(){
        Node p = top;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }
    }
}
