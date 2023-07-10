package algorithm;

public class Tree {

    TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }
        insert(root, value);
    }

    public void insert(TreeNode node, int value) {
        if (value < node.data) {
            if (node.left == null) {
                node.left = new TreeNode(value);
            } else {
                insert(node.left, value);
            }
        } else if (value > node.data) {
            if (node.right == null) {
                node.right = new TreeNode(value);
            } else {
                insert(node.right, value);
            }

        }

    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(TreeNode node) {
        if (node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node + ", ");
        if (node.right != null) {
            inOrder(node.right);
        }
    }
}
