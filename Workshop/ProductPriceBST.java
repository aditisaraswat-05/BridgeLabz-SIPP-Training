package Workshop;

class Node {
    int price;
    Node left, right;

    Node(int price) {
        this.price = price;
        left = right = null;
    }
}

public class ProductPriceBST {

    // Insert price into BST
    public Node insert(Node root, int price) {
        if (root == null) {
            return new Node(price);
        }
        if (price < root.price) {
            root.left = insert(root.left, price);
        } else if (price > root.price) {
            root.right = insert(root.right, price);
        }
        return root;
    }

    // Find minimum price (leftmost node)
    public int findMin(Node root) {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.price;
    }

    // Find maximum price (rightmost node)
    public int findMax(Node root) {
        if (root == null) {
            throw new RuntimeException("Tree is empty");
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.price;
    }

    public static void main(String[] args) {
        ProductPriceBST tree = new ProductPriceBST();
        Node root = null;

        int[] prices = { 250, 120, 400, 90, 150, 300, 500 };

        for (int price : prices) {
            root = tree.insert(root, price);
        }

        int minPrice = tree.findMin(root);
        int maxPrice = tree.findMax(root);

        System.out.println("Cheapest product price: " + minPrice);
        System.out.println("Most expensive product price: " + maxPrice);
    }
}

// Scenario: from the BST of product prices, find the cheapest and most
// expensive product.
// Problem:
// Find the minimum value in BST
// Find the maximum value in BST