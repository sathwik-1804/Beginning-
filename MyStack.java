//6.2
import java.util.LinkedList;
import java.util.Queue;
class MyStack {
    private Queue<Integer> queue1;
    public MyStack() {
        queue1 = new LinkedList<>();
    }
    public void push(int x) {
        queue1.add(x);
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue1.add(queue1.remove());
        }
    }
    public int pop() {
        return queue1.remove();
    }
    public int top() {
        return queue1.peek();
    }
    public boolean empty() {
        return queue1.isEmpty();
    }
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1); // Push 1
        myStack.push(2); // Push 2
        System.out.println(myStack.top());   // Output: 2
        System.out.println(myStack.pop());    // Output: 2
        System.out.println(myStack.empty());  // Output: false
    }
}






/*import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    /** Initialize your data structure here. 
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /** Push element x onto stack. 
    public void push(int x) {
        queue1.add(x);
        
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }
 
    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Enter commands (push <value>, pop, top, empty, exit):");

        while (true) {
            command = scanner.nextLine();
            if (command.equals("exit")) {
                break;
            }
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "push":
                    if (parts.length > 1) {
                        int value = Integer.parseInt(parts[1]);
                        myStack.push(value);
                        System.out.println("Pushed: " + value);
                    } else {
                        System.out.println("Error: No value provided for push.");
                    }
                    break;
                case "pop":
                    if (!myStack.empty()) {
                        System.out.println("Popped: " + myStack.pop());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case "top":
                    if (!myStack.empty()) {
                        System.out.println("Top: " + myStack.top());
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;
                case "empty":
                    System.out.println("Is empty: " + myStack.empty());
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
        scanner.close();
    }
}*/

