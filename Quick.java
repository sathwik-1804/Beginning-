30import java.util.Scanner;
class Quick {
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; 
        int i = start - 1;  
        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++; 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;
        return i + 1;
    }
    public static void quicksort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end); 
            quicksort(arr, start, pIndex - 1); 
            quicksort(arr, pIndex + 1, end);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        quicksort(array, 0, size - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", "); 
            }
        }
    }
}
