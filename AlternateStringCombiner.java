/*import java.util.Scanner;
import java.lang.Math;
class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       String str= sc.nextLine();
        String str2="";
      String[] newStr=  str.split(",");
       String a=newStr[0],b=newStr[1];
       int min = Math.min(a.length(),b.length());
        for(int i = 0; i< min;i++){
             char c = a.charAt(i);
             char d = b.charAt(i); 
             str2 += String.valueOf(c)+String.valueOf(d);
        }    
         if(a.length()< b.length()) str2+= b.substring(min);
         else if (b.length() < a.length()) str2+= a.substring(min);
        System.out.println(str2);
    }
}
*/



import java.util.Scanner;
import java.lang.Math;
class AlternateStringCombiner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] newStr = str.split(",");
        if (newStr.length != 2) {
            System.out.println("Invalid input. Please provide two strings separated by a comma.");
            return;
        }

        String a = newStr[0], b = newStr[1];
        int min = Math.min(a.length(), b.length());
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char c = a.charAt(i);
            char d = b.charAt(i);
            str2.append(c).append(d);
        }
        if (a.length() < b.length()) {
            str2.append(b.substring(min));
        } else if (b.length() < a.length()) {
            str2.append(a.substring(min));
        }
        System.out.println(str2.toString());
    }
}

