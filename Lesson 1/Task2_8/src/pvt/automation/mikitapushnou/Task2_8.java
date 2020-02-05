package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_8 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        int min = getMinElementOfArray(arr);
        System.out.println("Min element: " + min);
        int max = getMaxElementOfArray(arr);
        System.out.println("Max element: " + max);
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
            arr[i] = enterIntValue();
        }
        return arr;
    }

    public static int getMinElementOfArray(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int getMaxElementOfArray(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
