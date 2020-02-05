package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_4 {

    public static void main(String[] args) {
        int numberOfIterations = 2;

        while (numberOfIterations > 0) {
            int[] arr = createFilledInArray();
            printNumberOfZeroElementsInArray(arr);
            numberOfIterations--;
        }
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

    public static void printNumberOfZeroElementsInArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                count++;
            }
        }

        System.out.println(count > 0 ? "Number of zero elements: " + count : "There are no zero elements.");
    }
}
