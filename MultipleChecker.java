import java.util.Scanner;
class MultipleChecker{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int result = ExactMultiple(a,b);
		System.out.println(result);
	}
	public static int ExactMultiple(int n, int m){
	    if (n != 0 && m != 0) {
	    if ( n % Math.abs(m )== 0 ) return 2;
	    else return 1;
	    } else {
	        return 3;
	    }
	}
}

