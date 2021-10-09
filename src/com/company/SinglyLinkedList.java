package com.company;

import com.sun.xml.internal.xsom.XSUnionSimpleType;

import javax.xml.soap.Node;

public class SinglyLinkedList {

    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    //无头结点
    //表头部插入
    //这种操作将于输入的顺序相反，逆序
    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        //空链表
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //顺序插入
    //链表尾部插入，尾插法，与将要输入的元素顺序相同
    public void insertToTail(int value) {
        Node newNode = new Node(value, null);
        //空链表，可以插入新结点作为head，也可以不操作
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //在指定节点后插入新节点
    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }

    //在指定节点前插入新节点
    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }
        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;
        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        Node p = head;
        Node q = null;

        if (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("The end.");
    }

    //判断是否是回文数
    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            System.out.println("开始寻找中间节点");
            Node p = head;
            Node q = head;
            if (p.next == null) {
                System.out.println("链表中只有一个元素");
                return true;
            }
            //两个节点共同移动，一个节点每次移动一个元素，另一个节点每次移动两个元素，寻找中间节点
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }

            System.out.println("开始执行回文判断");
            Node rightNode = null;
            Node leftNode = null;
            if (q.next == null) {
                System.out.println("链表中含有奇数个元素,中间节点是：" + p.data);
                rightNode = p.next;
                leftNode = inverseLinkList(p).next;
            } else {
                System.out.println("链表中含有偶数个元素,中间两个节点是：" + p.data + "," + q.data);
                rightNode = p.next;
                leftNode = inverseLinkList(p);
            }
            return TFResult(leftNode,rightNode);
        }
    }

    //判断两个链表是否相等，true or false
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;
        boolean flag = true;
        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }
        System.out.println("Result is:" + flag);
        return flag;
    }

    //带头节点的链表翻转
    //该版本的该方法，是将链表中部至链表尾部的元素翻转 ——Su
    public Node inverseLinkList_head(Node p) {
        //创建一个新的节点作为头节点
        Node Head = new Node(9999, null);
        //将新创建的头节点，指向传入的链表P
        Head.next = p;
        /*
        带头节点的链表翻转，等价于
        从第二个元素开始重新进行头插法建立链表
         */
        Node Cur = p.next;
        p.next = null;
        Node next = null;
        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first" + Head.data);
            Cur = next;
        }
        /*
        返回左半部分的中点之前的那个节点
        从此处开始同步向两边比较
         */
        return Head;
    }

    //不带头节点的链表翻转
    //该版本的该方法，是将链表头至链表中部的元素翻转 ——Su
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node r = head;
        System.out.println("z----" + r.data);
        Node next = null;
        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }
        r.next = pre;
        /*
        返回左半部分的中间之前的那个节点
        从此处开始同步向两边比较
         */
        return r;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }
}
