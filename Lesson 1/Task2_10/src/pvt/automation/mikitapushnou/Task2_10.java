package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_10 {

    public static void main(String[] args) {
        int numberOfIterations = 2;
        while (numberOfIterations > 0) {
            int[] arr = createFilledInArray();
            System.out.println(isAscendingArray(arr));
            numberOfIterations--;
        }
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

    public static boolean isAscendingArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
