package learning.aDataStucture.recusion.tree;

public class Tree {
    Node root;
    int depth;

    Node addNode(int[] arr, Node root, int i, int level) {
        if (i < arr.length) {
            this.depth = level;
            root = new Tree.Node(arr[i], level++);
            root.left = addNode(arr, root.left, 2 * i + 1, level);
            root.right = addNode(arr, root.right, 2 * i + 2, level);
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root + " ");
        }
    }

    public void printLevel(Node root, int level) {
        if (root != null) {
            printLevel(root.left, level);
            printLevel(root.right, level);
            if (root.level == level) {
                System.out.print(root.data + " ");
            }
        }
    }

    public int getDepth() {
        return depth + 1;
    }

    static class Node {
        int data;
        Node left;
        Node right;
        int level;

        public Node(int data, int level) {
            this.data = data;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", level=" + level +
                    '}';
        }
    }
}
