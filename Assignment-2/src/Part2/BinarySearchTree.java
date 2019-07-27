package Part2;

public class BinarySearchTree {
    private Node root;

    public static class Node {
        int key;
        Node left;
        Node right;

        Node (int val) {
            key = val;
        }
        Node (int val, Node left, Node right) {
            key = val;
            this.left = left;
            this.right = right;
        }

        void updateLeft(Node n) {
            left = n;
        }
        void updateRight (Node n) {
            right = n;
        }
    }

    /**
     * Inserts a key into this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method
     * should be log(n)
     * @param key The key to insert.
     * */
    public void insert(int key) {
//        //base case
//        if (root == null) {
//            root = new Node(key);
//            return;
//        }

        Node track = root;
        Node add = new Node(key);

        //traverse to find spot to insert key into BST
        while (track != null) {
            if (track.key == key) {
                Node prev = track.right;
                track.right = add;
                add.right = prev;
            } else if (track.key > key) {
                track = track.left;
            } else {
                track = track.right;
            }
        }

//        if (track == null) {
            track = add;
//            return;
//        }
    }

    /**
     * Checks whether or not a key exists in this binary search tree.
     * If there are n nodes in the tree, then the average runtime of this method
     * should be log(n)
     *
     * @param key The key to check for.
     * @return true if the key is present in BST, false otherwise
     * */
    public boolean find(int key) {
        Node track = root;

        //no need for base case to check if root is a valid tree (not null)
        //because the while loop condition already checks for that.
        while (track != null) {
            if (track.key == key) {
                return true;
            } else if (track.key > key) {
                track = track.left;
            } else {
                track = track.right;
            }
        }

        //exists while loop if tree is empty or we've traversed to the bottom
        //and failed to find the key
        return false;
    }
}
