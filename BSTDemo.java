class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        
        private Node() {}

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    private Node root;

    public BST() { root = null; }

    private Node insertRecursive(Node node, int data) {
        if(node == null) return new Node(data);
        if(data < node.data) {
            node.left = insertRecursive(node.left,data);
        } else if(data > node.data) {
            node.right = insertRecursive(node.right,data);
        }
        return node;
    }

    public void insert(int data) {
        root = insertRecursive(root,data);
    }

    public void delete(int key) {
        root = deleteRecursive(root,key);
    }

    private Node deleteRecursive(Node node, int key) {
        if(node == null) return node;
        // recur down the tree
        if(key < node.data) {
            node.left = deleteRecursive(node.left,key);
        } else if(key > node.data) {
            node.right = deleteRecursive(node.right,key);
        // if key is same as root's key, then This is the node to be deleted
        } else {
            // node with only one child or no child
            if(node.left == null) {
                return node.right;
            } else if(node.right == null) {
                return node.left;
            // node with two children: Get the inorder successor (smallest in the right subtree) 
            } else {
                node.data = minValue(node.right); 
  
                // Delete the inorder successor 
                node.right = deleteRecursive(node.right, node.data);
            }
        }
        return node;
    }

    private void inorderRecursive(Node node) {
        if(node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + "-->");
            inorderRecursive(node.right);
        }
    }

    public void inorder() {
        inorderRecursive(root);
    }

    public void printOdd(Node root) {
        if(root != null) {
            inorderRecursive(root.left);
            if(root.data % 2 == 1) {
            System.out.print(root.data + "-->");
            inorderRecursive(root.right);
        }
    }

    private int minValue(Node node) {
        int min = node.data;
        while(node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
}

public class BSTDemo {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(5); 
        tree.insert(3); 
        tree.insert(7); 
        tree.insert(2); 
        tree.insert(4); 
        tree.insert(6); 
        tree.insert(8); 
  
        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 2"); 
        tree.delete(2); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 3"); 
        tree.delete(3); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete 5"); 
        tree.delete(5); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
    }
}
