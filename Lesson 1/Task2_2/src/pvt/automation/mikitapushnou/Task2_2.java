package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Task2_2 {

    public static void main(String[] args) {
        int[] arr = createFilledInArray();
        printMultipliedElementsOfArray(arr);

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

    public static void printMultipliedElementsOfArray(int[] arr) {
        int product = 1;
        int index = 0;
        while (index < arr.length) {
            product = product * arr[index];
            index++;
        }
        System.out.println("The product of all elements is: " + product);
    }
}
