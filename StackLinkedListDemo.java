class StackLinkedList {
    private class Node {
        int data;
        Node link;
        Node() {
            data = 0;
            link = null;
        }
        Node(int data, Node n) {
            this.data = data;
            this.link = n;
        }
    }

    private Node tos;
    private int size;
    private static final int MAX_SIZE = 100;

    public StackLinkedList() {
        tos = null;
        size = 0;
    }

    public void push(int val) {
        Node nptr = new Node(val,null);
        if(nptr == null) {
            System.err.println("Heap space exceeded max limit!");
            throw new OutOfMemoryError("Heap space exceeded max limit!");
        }
        if(size == MAX_SIZE) {
            System.err.println("Stack overflow!");
            throw new RuntimeException("Stack overflow!");
        }
        if(tos == null) {
            tos = nptr;
        } else {
            nptr.link = tos;
            tos = nptr;
        }
        size++;
        System.out.println(val + " is pushed to the stack");
    }

    public int pop() {
        if(tos == null || size == 0) {
            System.err.println("Stack underflow!");
            throw new RuntimeException("Stack underflow!");
        }
        int val = tos.data;
        tos = tos.link;
        size--;
        System.out.println(val + " is poped from the stack");
        return val;
    }

    public void display() {
        Node currNode = tos;
        StringBuilder sb = new StringBuilder("start -> ");
        while(currNode.link != null) {
            sb.append(currNode.data + " ");
            currNode = currNode.link;
        }
        sb.append(currNode.data);   
        sb.append(" <- end\n");
        System.out.println(sb.toString());   
    }
}

public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackLinkedList lst = new StackLinkedList();
        lst.push(5);
        lst.push(11);
        lst.push(17);
        lst.push(2);
        lst.push(8);
        lst.push(23);
        lst.display();
        lst.pop();
        lst.pop();
        lst.display();
    }
}
