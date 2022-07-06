package Properties;

public class BTree {
    Node root;

    public BTree() {
        root = null;
    }

    Node newNode(int data) {


        return root;
    }

    Node insert(Node root, int data) {
        if (root != null) {
            if (root.left==null) {
                root.left = insert(root.left, data);


            } else {
                root.right = insert(root.right, data);

            }
        } else {
            root = newNode(data);

        }
        return root;

    }

    void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.left + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.right + " ");
            inOrder(root.right);
        }
    }

    void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.left + " ");
        }
    }

    public int numberLeaf(Node root) {

        int count = 0;
        if (root != null) {

            if (root.right == null & root.left == null) {
                count = 1;
            } else {
                count = count + numberLeaf(root.right) + numberLeaf(root.left);
            }

        }

        return count;

    }

    int height(Node root) {


        if (root == null) {
            return -1;

        } else {
            int sag = 0, sol = 0;
            height(root.left);
            height(root.right);

            if (sol > sag) {
                return sol + 1;
            } else {
                return sag + 1;
            }


        }
    }
}
