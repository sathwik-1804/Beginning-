import java.util.Scanner;
public class  SecondLast {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    if (number < 10) {
      System.out.println("-1");
    } else {
      int secondLastDigit = (number / 10) % 10;
      System.out.println(secondLastDigit);
    }
    scanner.close();
  }
}

