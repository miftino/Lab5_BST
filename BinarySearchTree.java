import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;
    
    public BinarySearchTree() {
        root = null;
    }



    // Method to insert a new node with given data
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }



    // Method to print the Binary Search Tree in level order
    public void printBST() {

        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }


    // Method to delete node
    // There are 3 cases
    public void delete(int data){
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data){
        if (root == null){
            return root;
        }

        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
    
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child (only right child)
            else if (root.left == null) {
                return root.right;
            }
            // Case 2: One child (only left child)
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            else {
                root.data = minValue(root.right);
                root.right = deleteRec(root.right, root.data);
            }
        }
        return root;
    }
    
    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }


    // Method to search for a node with given data
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        if (data < root.data) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
}