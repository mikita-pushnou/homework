package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_1 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        printArray(arr);
        printArrayReversed(arr);

    }

    public static int enterIntValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        if(scanner.hasNextInt()) {
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

    public static void printArray(int[] arr) {
        System.out.println("Original: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArrayReversed(int[] arr) {
        System.out.println("Reversed: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
