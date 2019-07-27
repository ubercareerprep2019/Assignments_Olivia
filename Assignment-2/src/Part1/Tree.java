package Part1;

/** Tree class that provides basic TreeNode structure
 *  and depth first search traversal printing methods.
 *
 * @author olivialee
 * */
class Tree {

    TreeNode root;

    Tree(TreeNode root) {
        this.root = root;
    }

    Tree() {

    }

    class TreeNode {
        int _data;
        TreeNode _left;
        TreeNode _right;

        TreeNode(int data, TreeNode left, TreeNode right) {
            _data = data;
            _left = left;
            _right = right;
        }

        TreeNode(int data) {
            _data = data;
            _left = null;
            _right = null;
        }

        TreeNode left() {
            return _left;
        }

        TreeNode right() {
            return _right;
        }

        int value() {
            return _data;
        }
    }

    /** Print module of TreeNode
     * Implements a method called print() to print the values of the data
     * in all the TreeNodes with different traversal methods
     *
     * */
    void Print() {
        preOrderPrint(root);
        inOrderPrint(root);
        postOrderPrint(root);
    }

    //preorder print
    void preOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value() + " ");
        preOrderPrint(node.left());
        preOrderPrint(node.right());
    }

    //inorder print
    void inOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderPrint(node.left());
        System.out.print(node.value() + " ");
        inOrderPrint(node.right());
    }

    //postorder print
    void postOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderPrint(node.left());
        postOrderPrint(node.right());
        System.out.print(node.value() + " ");
    }

}