package com.company;

public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            } else if (data > p.data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        //p指向要删除的节点，初始化指向根节点
        Node p = tree;
        //pp记录p的父节点
        Node pp = null;
        while (p != null && p.right != null) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
            if (p == null) {
                //没找到要删除的节点
                return;
            }

            //要删除的节点有两个子节点
            if (p.left != null && p.right != null) {
                //查找右子树中的最小节点
                Node minP = p.right;
                //minPP表示minP的父节点
                Node minPP = p;
                while (minP.left != null) {
                    minPP = minP;
                    minP = minP.left;
                }
                //将minP的数据替换到p中
                p.data = minP.data;
                //删除minP
                p = minP;
                pp = minPP;
            }

            //要删除的节点是叶子节点或者仅有一个子节点
            Node child;
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }
            if (pp == null) {
                child = tree;
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }
        }

    }

    public Node findMin(){
        if(tree == null) return null;
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax(){
        if (tree == null) return null;
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
