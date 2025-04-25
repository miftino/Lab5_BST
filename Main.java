public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);
    
        System.out.println("Tree created successfully!");

        System.out.println("Printing the Binary Search Tree:");
        tree.printBST();


        tree.delete(50);
        tree.printBST();

        System.out.println("Searching for 40: " + tree.search(40));
        System.out.println("Searching for 100: " + tree.search(100)); 
        
    }
}