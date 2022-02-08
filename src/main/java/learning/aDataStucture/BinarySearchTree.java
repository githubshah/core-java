package learning.aDataStucture;// Binary Search Tree operations in Java

class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertKey(root, key);
    }

    // Insert key in the tree
    Node insertKey(Node node, int key) {
        // Return a new node if the tree is empty
        if (node == null) {
            return new Node(key);
        }

        // Traverse to the right place and insert the node
        if (key < node.data)
            node.left = insertKey(node.left, key);
        else if (key > node.data)
            node.right = insertKey(node.right, key);

        return node;
    }

    void inorder() {
        inorderRec(root);
    }

    // Inorder Traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " -> ");
            inorderRec(root.right);
        }
    }

    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        // Return if the tree is empty
        if (root == null)
            return root;

        // Find the node to be deleted
        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // If the node is with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If the node has two children
            // Place the inorder successor in position of the node to be deleted
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Find the inorder successor
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    int maxValue(Node root) {
        int minv = root.data;
        while (root.right != null) {
            minv = root.right.data;
            root = root.right;
        }
        return minv;
    }

    // Driver Program to test above functions
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.println("\n\nAfter deleting 10");
        tree.deleteKey(10);
        System.out.print("Inorder traversal: ");
        tree.inorder();

        System.out.print("\nMin Value: " + tree.minValue(tree.root));
        System.out.print("\nMax Value: " + tree.maxValue(tree.root));


        tree.insertWrongKey(21);

        System.out.print("\nisBSTUtil: " + tree.isBSTUsingMinAndMax(tree.root, Integer.MIN_VALUE,
            Integer.MAX_VALUE));

        System.out.print("\nisBSTUtil: " + tree.isBSTUsingInorder(tree.root));
    }

    private void insertWrongKey(int key) {
        insertKey(root.left, key);
    }

    boolean isBSTUsingMinAndMax(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUsingMinAndMax(node.left, min, node.data - 1) &&
            isBSTUsingMinAndMax(node.right, node.data + 1, max));
    }

    int lastValue = 0;
    int index1 = 0;

    boolean isBSTUsingInorder(Node node) {
        if (node != null) {
            isBSTUsingInorder(node.left);
            if (lastValue < node.data) {
                lastValue  = node.data;
            } else {
                return false;
            }
            index1++;
            isBSTUsingInorder(node.right);
        }
        return true;
    }

    void test(Node root) {
        if (root != null) {
            test(root.left);
            System.out.println(root.data);
            test(root.right);
        }
    }
}