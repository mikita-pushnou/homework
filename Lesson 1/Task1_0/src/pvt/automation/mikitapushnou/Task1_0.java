package pvt.automation.mikitapushnou;

public class Task1_0 {

    public static void main(String[] args) {
        int integer1 = 5;
        int integer2 = 5;

        System.out.println("The difference is the following:");
        System.out.println("++ - в этом случае ++ являются постфиксом, используется старое значение i, а потом инкрементируется");
        System.out.println("++i - в этом случае ++ являются префиксом, сначала i инкрементируется, а потом используется новое значение");
        System.out.println();
        System.out.println("Using postfix: " + integer1++);
        System.out.println("integer1 after incrementation: " + integer1);
        System.out.println("Using prefix: " + ++integer2);
        System.out.println("integer2 after incrementation: " + integer1);
    }
}
