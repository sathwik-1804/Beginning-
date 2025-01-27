import java.util.Stack;
import java.util.Scanner;
class Postfix {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            if (isOperator(token)) {
                int secondOperand = stack.pop();
                int firstOperand = stack.pop();
                int result = applyOperator(firstOperand, secondOperand, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    private static int applyOperator(int first, int second, String operator) {
        switch (operator) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                return first / second;
            default:
                throw new UnsupportedOperationException("Invalid operator: " + operator);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        int result = evaluatePostfix(expression);
        System.out.println(result);
        scanner.close();
    }
}