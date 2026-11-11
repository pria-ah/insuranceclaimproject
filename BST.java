
class BST {

    static class Node {
        int id;
        Node left, right;

        Node(int id) {
            this.id = id;
        }
    }

    static Node insert(Node root, int id) {
        if (root == null)
            return new Node(id);

        if (id < root.id)
            root.left = insert(root.left, id);
        else if (id > root.id)
            root.right = insert(root.right, id);

        return root;
    }

    static boolean search(Node root, int id) {
        if (root == null)
            return false;

        if (root.id == id)
            return true;

        if (id < root.id)
            return search(root.left, id);

        return search(root.right, id);
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.id + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.id + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.id + " ");
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] ids = {50, 30, 70, 20, 40, 60, 80};

        for (int id : ids)
            root = insert(root, id);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.println("\nSearch 60: " + search(root, 60));
    }
}
