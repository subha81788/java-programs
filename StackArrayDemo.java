class StackArray {
    private final int capacity;
    private int[] arr;
    private int top = -1;

    public StackArray(int c) {
        capacity = c;
        arr=new int[capacity];
    }

    public void push(int item) {
        if(top == capacity - 1) {
            System.out.println("Stack overflow");   
        }
        arr[++top]=item;
    }

    public int pop() {
        if(top == -1) {
            System.out.println("Stack underflow");   
            return -1;
        }
        return arr[top--];
    }

    public void show() {
        if(top==-1) {
            System.out.println("Empty stack");   
        }
        for(int i=0; i<=top; i++) {
            System.out.println(arr[i]);   
        }
    }
}

public class StackArrayDemo {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.pop();
        stack.pop();
        stack.show();
        stack.pop();
        stack.show();
        stack.pop();
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.show();
    }
}
