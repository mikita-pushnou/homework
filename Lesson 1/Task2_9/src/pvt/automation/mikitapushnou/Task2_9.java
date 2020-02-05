package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_9 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        int min = getMinElementIndexOfArray(arr);
        System.out.println("Index of Min element: " + min);
        int max = getMaxElementIndexOfArray(arr);
        System.out.println("Index of Max element: " + max);
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

    public static int getMinElementIndexOfArray(int[] arr) {
        int min = getMinElementOfArray(arr);
        int minIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (min == arr[i]){
                return i;
            }
        }
        return minIndex;
    }

    public static int getMaxElementIndexOfArray(int[] arr) {
        int max = getMaxElementOfArray(arr);
        int maxIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]){
                return i;
            }
        }
        return maxIndex;
    }
}
