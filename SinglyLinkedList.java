class Node {
    int data;
    Node nxt;
    Node() {
        data=0;
        nxt=null;
    }
    Node(int data, Node n) {
        this.data=data;
        this.nxt = n;
    }
}

public class SinglyLinkedList {

    private int size;

    public SinglyLinkedList(Node head) {
        size = 0;
        head=null;
    }

    public Node insertAtBeg(Node head, int val) {
        Node nptr = new Node(val,null);
        if(head == null) {
            head = nptr;
        } else {
            nptr.nxt = head;
            head = nptr;
        }
        size++;
        return head;
    }

    public Node append(Node head, int val) {
        Node nptr = new Node(val,null);
        Node ptr = head;
        if(head == null) {
            head=nptr;
        } else {
            while(ptr.nxt != null) ptr = ptr.nxt;
            ptr.nxt=nptr;
        }
        size++;
        return head;
    }

    public Node insertAtPos(Node head, int pos, int val) {
        Node nptr = new Node(val,null);
        Node ptr = head;
        if(pos > size) {
            System.out.println("Insertion is not possible. Insert position " + pos + " is more than size " + size + " of nxted list");
            return head;
        }
        for(int i=1; i <= size; i++) {
            if(i == pos - 1) {
                nptr.nxt = ptr.nxt;
                ptr.nxt= nptr;
                break;
            }
            ptr = ptr.nxt;
        }
        size++;
        return head;
    }

    public void display(Node head) {
        Node ptr = head;
        System.out.print("head -> ");   
        while(ptr.nxt != null) {
            StringBuilder sb = new StringBuilder(ptr.data + " ");
            System.out.print(sb.toString());   
            ptr = ptr.nxt;
        }
        System.out.print(ptr.data);   
        System.out.println(" <- tail");   
    }

    public int get(Node head, int pos) {
        int retVal = -1;
        if(size == 0) {
            System.out.println("List underflow!");
            return retVal;
        }
        if(pos < 1) {
            System.out.println("My list index heads with 1");
            return retVal;
        } else if(pos > size) {
            System.out.println("List doesn't contain so many items");
            return retVal;
        }
        Node ptr = head;
        for(int i=1; i <= size; i++, ptr = ptr.nxt) {
            if(i == pos) {
                retVal = ptr.data;
                break;
            }
        }
        return retVal;
    }

    public int getMiddle(Node head) {
        if(head == null) {
            System.out.println("List underflow!");
            return -1;
        }
        Node fastPtr = head, slowPtr = head;
        while(fastPtr != null && fastPtr.nxt != null) {
            fastPtr = fastPtr.nxt.nxt;
            slowPtr = slowPtr.nxt;
        }
        return slowPtr.data;
    }

    public int getNthFromEnd(Node head, int n) {
        if(head == null) {
            System.out.println("List underflow!");
            return -1;
        }
        Node fastPtr = head, slowPtr = head;
        int count = 0;
        while(count++ < n) fastPtr = fastPtr.nxt; //First move reference pointer to n nodes from head

        //Now move both pointers one by one until reference pointer reaches end. Now main pointer will point to nth node from the end.
        while(fastPtr != null) {
            fastPtr = fastPtr.nxt;
            slowPtr = slowPtr.nxt;
        }
        return slowPtr.data;
    }
}
