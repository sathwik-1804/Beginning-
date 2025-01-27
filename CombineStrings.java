import java.util.Scanner;
class CombineStrings{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		if(str1.length() < str2.length()) {
		    System.out.println(str1+str2+str1);
		}
		else {
		    System.out.println(str2+str1+str2);
      sc.close();
	}
}
}


