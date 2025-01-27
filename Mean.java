import java.util.Scanner;
public class Mean {
    public static double recursiveSum(int[] arr, int n) {
        if (n == 1) return arr[0];
        return recursiveSum(arr, n - 1) + arr[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = sc.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        double mean = recursiveSum(arr, n) / n;
        System.out.println(mean);
        sc.close();
    }
}

