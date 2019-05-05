class Node {
    protected int data;
    protected Node nxt;

    public Node(int data) {
        this.data = data;
        this.nxt = null;
    }
}

class LinkedList {

    protected Node head;

    public LinkedList() { head = null; }

    public void append(int val) {
    	Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
        } else {
            Node nptr = head;
            while(nptr.nxt != null) {
                nptr = nptr.nxt;
            }
            nptr.nxt = newNode;
        }
    }
    public void display() {
        System.out.print("head --> ");
        for(Node nptr = head; nptr != null; nptr = nptr.nxt) {
            System.out.print(nptr.data + " --> ");
        }
        System.out.println("tail");
    }
}

public class LinkedListMerge {
    public static Node mergeSortedLists(LinkedList l1, LinkedList l2) {
        Node nptr1 = l1.head;
        Node nptr2 = l2.head;
        Node headR = new Node(0); // dummy first node
        Node tailR = headR;
        while(true) {
            if(nptr1 == null) {
                tailR = nptr2;
                break;
            } else if(nptr2 == null) {
                tailR = nptr1;
                break;
            }
            if(nptr1.data <= nptr2.data) {
                tailR = nptr1;
                nptr1 = nptr1.nxt;
            } else {
                tailR = nptr2;
                nptr2 = nptr2.nxt;
            }
            tailR = tailR.nxt;
        }
        return headR;
    }

    public static void print(Node head) {
        System.out.print("head --> ");
        for(Node nptr = head; nptr != null; nptr = nptr.nxt) {
            System.out.print(nptr.data + " --> ");
        }
        System.out.println("tail");
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(5);
        l1.append(10);
        l1.append(15);
        System.out.println("1st sorted list");
        l1.display();
        LinkedList l2 = new LinkedList();
        l2.append(2);
        l2.append(3);
        l2.append(20);
        System.out.println("2nd sorted list");
        l2.display();

        Node l3Head = mergeSortedLists(l1,l2);
        System.out.println("Merged sorted list");
        print(l3Head);
    }
}
