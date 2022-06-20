package Tree.TreeTraversal;


public class Node {
    int item;
    Node left, right;

    public Node(int key) {
        this.item = key;
        left = right = null;
    }
}

class BinaryTree {
    //Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }

    /**
     * 左 -> 右 -> 根
     * @param node
     */
    void postorder(Node node) {
        if (node == null) {
            return;
        }

        //Traverse left
        postorder(node.left);
        //Traverse right
        postorder(node.right);
        //Traverse root
        System.out.print(node.item + "->");
    }

    /**
     * 左 -> 根 -> 右
     * @param node
     */
    void inorder(Node node) {
        if (node == null) {
            return;
        }

        //Traverse left
        inorder(node.left);
        //Traverse root
        System.out.print(node.item + "->");
        //Traverse right
        inorder(node.right);
    }

    /**
     * 根 -> 左 -> 右
     *
     * @param node
     */
    void preorder(Node node) {
        if (node == null) {
            return;
        }
        //Traverse root
        System.out.print(node.item + "->");
        //Traverse left
        preorder(node.left);
        //Traverse right
        preorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        System.out.println("Inorder traversal,中序遍历，左->根->右");
        tree.inorder(tree.root);
        System.out.println("\nPreorder traversal,先序遍历，根->左->右");
        tree.preorder(tree.root);
        System.out.println("\nPreorder traversal,后序遍历，左->右->根");
        tree.postorder(tree.root);
    }
}