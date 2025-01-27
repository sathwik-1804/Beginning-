import java.util.Scanner;
class AddLastDigitsFunction {
 public static int addLastDigits(int n1,int n2) {
        int lastDigit1=Math.abs(n1%10);
        int lastDigit2=Math.abs(n2%10);
        int sum=lastDigit1+lastDigit2;
        return sum;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int result=addLastDigits(n1,n2);
        System.out.println(result);
        sc.close();
    }
}