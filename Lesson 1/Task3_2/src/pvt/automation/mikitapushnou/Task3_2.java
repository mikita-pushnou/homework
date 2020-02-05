package pvt.automation.mikitapushnou;

import java.util.Arrays;
import java.util.Scanner;

public class Task3_2 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int enterIntValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        return 0;
    }

    public static int[] createFilledInArray() {
        int[] arr = new int[enterIntValue()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length + (int)(Math.random() * arr.length);
        }
        return arr;
    }

    public static void shellSort(int arr[]) {
        int length = arr.length;

        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < length; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }
}
