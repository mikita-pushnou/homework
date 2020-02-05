package pvt.automation.mikitapushnou;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_6 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        System.out.println(Arrays.toString(getModifiedArray(arr)));
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
        int temp = 0;
        int[] modifiedArr = arr;

        for (int i = 0; i < modifiedArr.length - 1; i = i + 2) {
            temp = modifiedArr[i];
            modifiedArr[i] = modifiedArr[i + 1];
            modifiedArr[i + 1] = temp;
        }
        return modifiedArr;
    }
}
