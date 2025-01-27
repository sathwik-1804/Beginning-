class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; 
    }
    public boolean empty() {
        return top == -1;
    }
    public int size() {
        return top + 1;
    }
    public int top() {
        if (!empty()) {
            return stackArray[top];
        }
        throw new IllegalStateException("Stack is empty");
    }
    public void push(int value) {
        if (size() < maxSize) {
            stackArray[++top] = value;
        }
    }
    public int pop() {
        if (!empty()) {
            return stackArray[top--];
        }
        throw new IllegalStateException("Stack is empty");
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
        System.out.println("Is stack empty? " + stack.empty()); 
    }
}
