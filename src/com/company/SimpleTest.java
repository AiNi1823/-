package com.company;


public class SimpleTest {

    public static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    public static Node inverseLink_head(SimpleTest.Node p){
        //原链表不存在头节点，创建哨兵节点
        SimpleTest.Node head = new SimpleTest.Node(-1, null);
        head.next = p;
        SimpleTest.Node Cur = p.next;
        p.next = null;
        SimpleTest.Node next = null;

        while(Cur != null){
            next = Cur.next;
            Cur.next = head.next;
            head.next = Cur;
            Cur = next;
        }

        return head;
    }

    public static Node inverseLink(Node p){
        SimpleTest.Node Cur = p.next;
        SimpleTest.Node temp = p;
        p.next = null;
        SimpleTest.Node next = null;
        while(Cur != null){
            next = Cur.next;
            Cur.next = temp;
            temp = Cur;
            Cur = next;
        }

        return temp;
    }
}
