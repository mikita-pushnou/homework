package pvt.automation.mikitapushnou;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_11 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        int[] modifiedArr = getModifiedArray(arr);
        System.out.println(Arrays.toString(modifiedArr));
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

    public static int[] getModifiedArray(int[] arr) {
        int[] modifiedArray = arr;

        for (int i = 1; i < arr.length - 1; i++) {
            modifiedArray[i] = (modifiedArray[i - 1] + modifiedArray[i + 1]) / 2;
        }

        return modifiedArray;
    }

}
