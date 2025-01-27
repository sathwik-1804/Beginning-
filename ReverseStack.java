import java.util.Scanner;
import java.util.Stack;
class ReverseStack {
    static void bottomInsertion(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        bottomInsertion(stack, element);
        stack.push(top);
    }
    static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverse(stack);
        bottomInsertion(stack, top);
    }
    static void show(Stack<Integer> stack) {
        for (Integer element : stack) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    static boolean empty(Stack<Integer> stack) {
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String str : inputArray) {
            stack.push(Integer.parseInt(str));
        }
        reverse(stack);
        show(stack);
        scanner.close();
    }
}