import java.util.Scanner;
public class EvenOrOdd {
    public static int countEvenOdd(int[] numbers, String type) {
        int count = 0;
        for (int num : numbers) {
            if (type.equalsIgnoreCase("even") && num % 2 == 0) {
                count++; 
            } else if (type.equalsIgnoreCase("odd") && num % 2 != 0) {
                count++;  
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5]; 
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
        }
        sc.nextLine();
        String type = sc.nextLine();
        int result = countEvenOdd(numbers, type);
        System.out.println(result);
        sc.close();
    }
}
