package Tree.BalancedBinaryTree;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Height {
    int height = 0;
}

public class BalancedBinaryTree {
    Node root;

    //Check height balance
    boolean checkHeightBalance(Node root, Height height) {
        //Check for emptiness
        if (root == null) {
            height.height = 0;
            return true;
        }
        Height leftHeighteight = new Height();
        Height rightHeighteight = new Height();
        boolean l = checkHeightBalance(root.left, leftHeighteight);
        boolean r = checkHeightBalance(root.right, rightHeighteight);
        int leftHeight = leftHeighteight.height;
        int rightHeight = rightHeighteight.height;

        height.height = (Math.max(leftHeight, rightHeight)) + 1;

        if ((leftHeight - rightHeight >= 2) || (rightHeight - leftHeight >= 2)) {
            return false;
        } else {
            return l && r;
        }
    }

    public static void main(String[] args) {
        Height height = new Height();
        BalancedBinaryTree tree = new BalancedBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (tree.checkHeightBalance(tree.root, height)) {
            System.out.println("The tree is balanced");
        } else {
            System.out.println("The tree is not balanced");
        }
    }
}
