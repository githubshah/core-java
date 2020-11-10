package recusion.tree;

public class TreeOrders {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5};

        Tree tree = new Tree();
        tree.root = tree.addNode(arr, tree.root, 0); // init root

        System.out.println("\n\nin-order");
        tree.inOrder(tree.root);
        System.out.println("\n\npre-order");
        tree.preOrder(tree.root);
        System.out.println("\n\npost-order");
        tree.postOrder(tree.root);
    }
}
