import java.util.Scanner;
class Shell {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        int gap = 1;
        while (gap < n / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (int outer = gap; outer < n; outer++) {
                int insertionValue = arr[outer];
                int inner = outer;
                while (inner >= gap && arr[inner - gap] > insertionValue) {
                    arr[inner] = arr[inner - gap];
                    inner -= gap;
                }
                arr[inner] = insertionValue;
            }
            gap = (gap - 1) / 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        shellSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + (i < array.length - 1 ? ", " : ""));
        }
    }
}
