import java.util.Scanner;
public class UniformBinary {
    public static int[] midpointsLookup(int size) {
        int[] midpoints = new int[size];
        for (int i = 0; i < size; i++) {
            midpoints[i] = i / 2;
        }
        return midpoints;
    }
    public static int uniformBinarySearch(int[] arr, int x, int[] midpoints) {
        int index = arr.length / 2;
        while (index >= 0 && index < arr.length) {
            if (arr[index] == x) {
                return index;
            } else if (arr[index] < x) {
                index += midpoints[index];
            } else {
                index -= midpoints[index];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        int[] midpoints = midpointsLookup(size);
        int result = uniformBinarySearch(arr, x, midpoints);
        System.out.println(result);
        sc.close();
    }
}