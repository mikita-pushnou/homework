package pvt.automation.mikitapushnou;

import java.util.Scanner;

public class Methods {

    public static final int SQUARE = 2;
    public static final int CUBE = 3;

    public int enterNumber() {
        int number = 0;
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        }
        return number;
    }

    public int findMin(int firstNumber, int secondNumber) {
        return Math.min(firstNumber, secondNumber);
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int powering(int number, int degree) {
        return (int) Math.pow(number, degree);
    }
}
