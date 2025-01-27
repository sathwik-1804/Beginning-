import java.util.Scanner;
class PadovanSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = n+1;
        int[] arr = new int[b];
        for (int i = 0; i < b; i++) {
            if (i < 3) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 2] + arr[i - 3];
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
