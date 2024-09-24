package QueueProblem;

public class CircularQueue {
    
    private int[] data;
    private int head;
    private int tail;
    private int size;

   
    public CircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) head = 0;
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    
    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % size;
        }
        return true;
    }

    
    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    
    public int Rear() {
        return isEmpty() ? -1 : data[tail];
    }

    
    public boolean isEmpty() {
        return head == -1;
    }

    
    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(3);
        System.out.println(cq.enQueue(10)); 
        System.out.println(cq.enQueue(20)); 
        System.out.println(cq.enQueue(30)); 
        System.out.println(cq.enQueue(40)); 
        System.out.println(cq.Rear());     
        System.out.println(cq.isFull());    
        System.out.println(cq.deQueue());   
        System.out.println(cq.enQueue(40)); 
        System.out.println(cq.Rear());      
    }
}
