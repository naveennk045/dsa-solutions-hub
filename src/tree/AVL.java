package tree;


public class AVL {

    private Node root;

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (node.value > val) {
             node.left = insert(node.left, val);
        } else if (node.value < val) {
             node.right = insert(node.right, val);
        } else {
            throw new RuntimeException("Duplicate values cannot be inserted.");
        }

        updateHeight(node);

//        return node;

        return rotate(node);
    }


    private Node rotate(Node node) {
        if (balanceFactor(node) > 1) {
            // Left heavy
            if (balanceFactor(node.left) > 1) {
                //  Right -> Right
                return rightRotate(node);
            }
            if (balanceFactor(node.left) < -1) {
                // Left - > right
                leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if (balanceFactor(node) < -1) {
            // Right heavy
            if (balanceFactor(node.left) > 1) {
                //  left -> left
                return rightRotate(node);
            }
            if (balanceFactor(node.left) < -1) {
                // right - > left
                rightRotate(node.left);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        updateHeight(newRoot);
        updateHeight(node);

        return newRoot;
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.right = newRoot.right;
        newRoot.right = node;

        updateHeight(node);
        updateHeight(newRoot);

        return newRoot;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    public void display() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        System.out.println("Root Node: " + root.value);
        displayWithDetails(root, "");
    }

    private void displayWithDetails(Node node, String prefix) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            System.out.println(prefix + "├── Left: " + node.left.value + " (height: " + node.left.height + ")");
            displayWithDetails(node.left, prefix + "│   ");
        } else {
            System.out.println(prefix + "├── Left: null");
        }

        if (node.right != null) {
            System.out.println(prefix + "└── Right: " + node.right.value + " (height: " + node.right.height + ")");
            displayWithDetails(node.right, prefix + "    ");
        } else {
            System.out.println(prefix + "└── Right: null");
        }
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        int[] values = {5, 7, 10, 11, 12};
        for (int value : values) {
            avl.insert(value);
            avl.display();
            System.out.println("-----------");
        }
        avl.display();


    }
}