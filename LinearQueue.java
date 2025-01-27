import java.util.Scanner;
class LinearQueue {
    private static final int MAX = 5; // Maximum size of the queue
    private static int[] queue = new int[MAX];
    private static int front = 0;
    private static int rear = 0;

    public static boolean isEmpty() {
        return front == rear;
    }

    public static boolean isFull() {
        return rear == MAX;
    }

    public static void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + item);
        } else {
            queue[rear] = item;
            rear++;
            System.out.println("Enqueued: " + item);
        }
    }

    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
        } else {
            int item = queue[front];
            front++;
            System.out.println("Dequeued: " + item);
        }
    }

    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i < rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, item;

        do {
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter an integer to enqueue: ");
                    item = scanner.nextInt();
                    enqueue(item);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
