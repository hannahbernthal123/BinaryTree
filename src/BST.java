//Hannah Bernthal
import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */

    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    // Use this for a different dataset

//    public void setupTestData() {
//        this.root = new BSTNode(8);
//        this.root.setLeft(new BSTNode(3));
//        this.root.setRight(new BSTNode((10)));
//        this.root.getLeft().setLeft(new BSTNode(1));
//        this.root.getLeft().setRight(new BSTNode(6));
//        this.root.getLeft().getRight().setLeft(new BSTNode(4));
//        this.root.getLeft().getRight().setRight(new BSTNode(7));
//        this.root.getRight().setRight(new BSTNode(14));
//        this.root.getRight().getRight().setLeft((new BSTNode(13)));
//    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        return searchTree(root, val);
    }

    public boolean searchTree(BSTNode root, int val) {
        if (root == null) {
            return false;
        }
        if (val == root.getVal()) {
            return true;
        }
        if (val < root.getVal()) {
            return searchTree(root.getLeft() ,val);
        }
        else {
            return searchTree(root.getRight(), val);
        }
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */

    // Calls the helper method for inorder
    public ArrayList<BSTNode> getInorder() {
        ArrayList<BSTNode> result = new ArrayList<BSTNode>();
        return getInorderHelper(result, root);
    }

    // Goes through recursively to add the nodes in the order of left, root, right
    public ArrayList<BSTNode> getInorderHelper(ArrayList<BSTNode> result, BSTNode currentNode) {
        if (currentNode == null) {
           return result;
        }
        getInorderHelper(result, currentNode.getLeft());
        result.add(currentNode);
        getInorderHelper(result, currentNode.getRight());
        return result;
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */

    // Calls the helper method for preorder
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> result = new ArrayList<BSTNode>();
        return getPreorderHelper(result, root);
    }

    // Goes through recursively to add the nodes in the order of root, left, right
    public ArrayList<BSTNode> getPreorderHelper(ArrayList<BSTNode> result, BSTNode currentNode) {
        if (currentNode == null) {
            return result;
        }
        result.add(currentNode);
        getPreorderHelper(result, currentNode.getLeft());
        getPreorderHelper(result, currentNode.getRight());
        return result;
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */

    // Calls the helper method for postorder
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> result = new ArrayList<BSTNode>();
        return getPostorderHelper(result, root);
    }

    // Goes through recursively to add the nodes in the order of left, right, root
    public ArrayList<BSTNode> getPostorderHelper(ArrayList<BSTNode> result, BSTNode currentNode) {
        if (currentNode == null) {
            return result;
        }
        getPostorderHelper(result, currentNode.getLeft());
        getPostorderHelper(result, currentNode.getRight());
        result.add(currentNode);
        return result;
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        root = insertHelper(val, root);
    }

    // Uses recursion to insert a value by
    // 1) narrowing it down between left and right
    // 2) if it's supposed to be right but its null, add it there
    // 3) same thing for the left
    public BSTNode insertHelper(int val, BSTNode currentNode) {
        if (currentNode == null) {
            return new BSTNode(val);
        }
        if (currentNode.getVal() < val) {
            currentNode.setRight(insertHelper(val, currentNode.getRight()));
        }
        else if (currentNode.getVal() > val) {
            currentNode.setLeft(insertHelper(val, currentNode.getLeft()));
        }
        return currentNode;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
