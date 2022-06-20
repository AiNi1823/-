package Tree;

public class PerfectBinaryTree {

    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            this.key = item;
        }

        //Calculate the depth
        static int depth(Node node) {
            int d = 0;
            while (node != null) {
                d++;
                node = node.left;
            }
            return d;
        }
    }

    //Check if the tree is perfect binary tree
    static boolean is_perfect(Node root, int d, int level) {
        //Check if the tree is empty
        if (root == null) {
            return true;
        }
        //If for children
        if (root.left == null && root.right == null) {
            return (d == level + 1);
        }

        if (root.left == null || root.right == null) {
            return false;
        }

        return is_perfect(root.left, d, level + 1) && is_perfect(root.left, d, level + 1);
    }

    //Wrapper function
    static boolean is_Perfect(Node root) {
        int d = Node.depth(root);
        return is_perfect(root, d, 0);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        if (is_Perfect(root)) {
            System.out.println("The tree is a perfect binary tree");
        } else {
            System.out.println("The tree is not a perfect binary");
        }
    }

}
