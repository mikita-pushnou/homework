package pvt.automation.mikitapushnou;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_12 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        int[] modifiedArray = getModifiedArray(arr);
        System.out.println(Arrays.toString(modifiedArray));
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
        int[] modifiedArray = new int[arr.length + 2];

        for (int i = 0; i < modifiedArray.length - 2; i++) {
            modifiedArray[i + 2] = arr[i];
        }

        return modifiedArray;
    }
}
