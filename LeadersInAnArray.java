// import java.util.Scanner;
// import java.util.ArrayList;
// class LeadersInAnArray {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         sc.nextLine(); 
//         String values = sc.nextLine();
//         String[] nums = values.split("\\s*,\\s*");  
//         int[] arr = new int[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             arr[i] = Integer.parseInt(nums[i].trim());
//         }
//         ArrayList<Integer> leaders = new ArrayList<>();
//         int maxFromRight = Integer.MIN_VALUE;
//         for (int i = arr.length - 1; i >= 0; i--) {
//             if (arr[i] >= maxFromRight) {
//                 leaders.add(arr[i]); 
//                 maxFromRight = arr[i]; 
//             }
//         }
//         for (int i = leaders.size() - 1; i >= 0; i--) {
//             System.out.print(leaders.get(i) + " ");
//         }

//         sc.close();
//     }
// }
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String values = sc.nextLine();
        String[] nums = values.split(", "); 
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = Integer.parseInt(nums[i].trim());
        }
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            flag = true; 

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    flag = false; 
                    break;
                }
            }
            if (flag) {
                System.out.print(arr[i] + " "); 
            }
        }
        sc.close();
    }
}