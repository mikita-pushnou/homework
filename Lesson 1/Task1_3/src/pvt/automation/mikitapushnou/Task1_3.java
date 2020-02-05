package pvt.automation.mikitapushnou;

public class Task1_3 {

    public static void main(String[] args) {
        int number1 = 2;
        int number2 = 20;

        for (int i = number1; i <= number2; i++) {
            if(i % 2 == 0 & i > 10) {
                System.out.println(i);
            }
        }
    }
}
