package recusion.tree;

public class Tree {
    Node root;

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

    Node addNode(int[] arr, Node node, int i, int level) {
        if (i < arr.length) {
            node = new Tree.Node(arr[i], level++);
            node.left = addNode(arr, node.left, 2 * i + 1, level);
            node.right = addNode(arr, node.right, 2 * i + 2, level);
        }
        return node;
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
}
