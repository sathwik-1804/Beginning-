import java.util.Stack; 
import java.util.Scanner; 
public class InfixToPostfix {  
    static int prec(char c) { 
        if (c == '^') return 3; 
        else if (c == '/' || c == '*') return 2; 
        else if (c == '+' || c == '-') return 1; 
        else return -1; 
    } 
    static char associativity(char c) { 
        if (c == '^') return 'R';  
        return 'L'; 
    } 
    static String infixToPostfix(String s) { 
        StringBuilder result = new StringBuilder(); 
        Stack<Character> stack = new Stack<>(); 
        for (int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i); 
            if (Character.isLetterOrDigit(c)) { 
                result.append(c).append(" "); 
            }  
            else if (c == '(') { 
                stack.push(c); 
            }  
            else if (c == ')') { 
                while (!stack.isEmpty() && stack.peek() != '(') { 
                    result.append(stack.pop()).append(" "); 
                } 
                stack.pop();
            }  
            else if (prec(c) > 0) { 
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek()) || 
                                             (prec(c) == prec(stack.peek()) && associativity(c) == 'L'))) { 
                    result.append(stack.pop()).append(" "); 
                } 
                stack.push(c); 
            } 
        } 
        while (!stack.isEmpty()) { 
            result.append(stack.pop()).append(" "); 
        } 
        return result.toString().trim();
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        String exp = sc.nextLine(); 
        String postfix = infixToPostfix(exp); 
        System.out.println(postfix); 
        sc.close(); 
    } 
}