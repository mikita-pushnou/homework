package pvt.automation.mikitapushnou;

import java.util.Arrays;
import java.util.Scanner;

public class Task2_3 {

    public static void main(String[] args) {
	    int[] arr = createFilledInArray();
        System.out.println(Arrays.toString(getModifiedArray(arr)));
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

    public static int[] getModifiedArray(int[] arr) {
        int[] modifiedArr = arr;
        System.out.print("Multiplied array: ");
        for (int i = 2; i < modifiedArr.length; i = i + 3) {
            //modifiedArr[i] = modifiedArr[i] * 2;
            modifiedArr[i] = Math.multiplyExact(modifiedArr[i], 2);
        }
        return modifiedArr;
    }
}
