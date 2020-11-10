package recusion.tree;

public class Tree {
    Node root;

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node addNode(int[] arr, Node node, int i) {
        if (i < arr.length) {
            node = new Tree.Node(arr[i]);
            node.left = addNode(arr, node.left, 2 * i + 1);
            node.right = addNode(arr, node.right, 2 * i + 2);
        }
        return node;
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
