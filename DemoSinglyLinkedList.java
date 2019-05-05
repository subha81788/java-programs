import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DemoSinglyLinkedList {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter number of test cases: "); int t = Integer.parseInt(br.readLine());

            while(t-- > 0) {
                System.out.print("Enter number of items to input: "); int n = Integer.parseInt(br.readLine());
                System.out.println("Enter items (0 => insert at begining, -1 => append):"); String s = br.readLine();
                System.out.print("Enter the index of the item to fetch (Index starts from 1): "); int idx = Integer.parseInt(br.readLine());
                String[] ss = s.trim().split("\\s+");
                SinglyLinkedList lst = new SinglyLinkedList();
                for(int i=0; i<n*2; i+=2) {
                    if(Integer.parseInt(ss[i]) == 0) {
                        lst.insertAtBeg(Integer.parseInt(ss[i+1]));
                    } else if(Integer.parseInt(ss[i]) == -1) {
                        lst.append(Integer.parseInt(ss[i+1]));
                    } else {
                        lst.insertAtPos(Integer.parseInt(ss[i]), Integer.parseInt(ss[i+1]));
                    }
                }
                lst.display();
                System.out.println("Item at index " + idx + " in linked list is " + lst.get(idx));
                System.out.println("Item at the middle of linked list is " + lst.getMiddle());
                System.out.print("Enter the index from the end of the item to fetch (Index starts from 1): "); idx = Integer.parseInt(br.readLine());
                System.out.println("The item is " + lst.getNthFromEnd(idx));
            }
        }
    }   
}
