class QueueArray {
    private int[] arr;
    private int capacity;
    private int front;
    private int rear;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        front = rear = -1;
        arr = new int[capacity];
    }

    public void insert(int n) {
        if(rear == -1) {
            rear=0;
            front=0;
        } elseif(rear < capacity - 1) {
            rear++;
        } elseif(rear == capacity-1) {
            System.out.println("Queue Over flow");   
            return;
        }
        arr[rear] = n;
    }

    public int remove() {
        if(front == -1) {
            System.out.println("Queue Under flow");   
            return -1;
        }
        int n = arr[front];
        if(front == rear) {
            front = rear = -1;
        } else {
            front--;
        }
        return n;
    }

    public void display() {
        for(int i =0; i<
    }

}

public class QueueArrayDemo {
    
}
