/*
 * Binary Search Tree is a node-based binary tree data structure which has the following properties:  
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 * Inorder traversal of BST always produces sorted output.
 *
 * Searching a key
 * Let’s say we want to search for the number, what we’ll do is we’ll start at the root, and then we will compare
 * the value to be searched with the value of the root if it’s equal we are done with the search if it’s lesser
 * we know that we need to go to the left subtree because in a binary search tree all the elements in the left
 * subtree are lesser and all the elements in the right subtree are greater. Searching an element in the binary
 * search tree is basically this traversal in which at each step we will go either towards left or right and hence
 * in at each step we discard one of the sub-trees. If the tree is balanced, we call a tree balanced if for all
 * nodes the difference between the heights of left and right subtrees is not greater than one, we will start with
 * a search space of ‘n’nodes and when we will discard one of the sub-trees we will discard ‘n/2’ nodes so our search
 * space will be reduced to ‘n/2’ and then in the next step we will reduce the search space to ‘n/4’ and we will
 * go on reducing like this till we find the element or till our search space is reduced to only one node. The search
 * here is also a binary search and that’s why the name binary search tree.
 * Average case time complexity to search a key from a BST of n nodes is O(log n) and that in worst case is O(n)
 */


import java.util.Random;

class BST {
    static class Node {
        private int data;
        private Node left;
        private Node right;
        
        private Node() {}

        public Node(int val) {
            data = val;
            left = right = null;
        }
    }

    private Node root;

    public BST() { root = null; }

    public void insert(int data) {
        System.out.println("Inserting: " + data);
        root = insertRecursive(root,data);
    }

    private Node insertRecursive(Node node, int data) {
        if(node == null) return new Node(data);
        if(data < node.data) {
            node.left = insertRecursive(node.left,data);
        } else if(data > node.data) {
            node.right = insertRecursive(node.right,data);
        }
        return node;
    }

    public void delete(int key) {
        System.out.println("Deleting: " + key);
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

    public Node search(int key) {
        return search(root, key);
    }

    private Node search(Node node, int key) {
        if (node==null || key == node.data) {
            return node;
        }

        if (key > node.data) {
            return search(node.right, key);
        }

        return search(node.left, key);
    }

    public void printOdd(Node root) {
        if(root != null) {
            inorderRecursive(root.left);
            if(root.data % 2 == 1) {
                System.out.print(root.data + "-->");
            }
            inorderRecursive(root.right);
        }
    }

    private int minValue(Node node) {
        var min = node.data;
        while(node.left != null) {
            min = node.left.data;
            node = node.left;
        }
        return min;
    }
}

public class BinarySearchTreeDemo {

    private static final int MAX = 100;
    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        var tree = new BST();
        var generator = new Random();
        int[] arr = new int[CAPACITY];
		
        for (var i = 0; i < CAPACITY; i++) {
            var n = generator.nextInt(MAX);
            tree.insert(n); 
            arr[i] = n;
        }

        System.out.println("Inorder traversal of the given tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete " + arr[2]); 
        tree.delete(arr[2]); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete " + arr[3]); 
        tree.delete(arr[3]); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
  
        System.out.println("\nDelete " + arr[5]); 
        tree.delete(arr[5]); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorder(); 
        System.out.println(); 

        assert tree.search(arr[1]) != null : "Binary search failed for key " + arr[1];
        assert tree.search(arr[3]) == null : "Binary search failed for key " + arr[3] + ". Key already deleted.";
    }
}
