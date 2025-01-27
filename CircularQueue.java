//6.4
class CircularQueue {
    private int size;
    private int front, rear;
    private int[] queue;
    public CircularQueue(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = this.rear = -1;
    }
    public void enqueue(int data) {
        if ((rear + 1) % size == front) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0; 
        }
        rear = (rear + 1) % size; 
        queue[rear] = data; 
        System.out.println("Inserted: " + data);
    }
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return -1; 
        }
        int data = queue[front]; 
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size; 
        }
        return data;
    }
    public void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % size; 
        }
        System.out.println();
    }
    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3); 
        circularQueue.display();
        System.out.println("Dequeued: " + circularQueue.dequeue());
        circularQueue.display(); 
        circularQueue.enqueue(4);
        circularQueue.enqueue(5); 
        circularQueue.enqueue(6); 
        circularQueue.display();
        System.out.println("Dequeued: " + circularQueue.dequeue());
        circularQueue.display(); 
    }
}