package pvt.automation.mikitapushnou;

public class Task1 {

    public static void main(String[] args) {
        Methods methods = new Methods();
        int a = methods.enterNumber();
        int b = methods.enterNumber();
        System.out.println("The min between " + a + " and " + b + " is " + methods.findMin(a, b));

        int c = methods.enterNumber();
        int d = methods.enterNumber();
        System.out.println("Is the number " + c + " even? " + methods.isEven(c));
        System.out.println("Is the number " + d + " even? " + methods.isEven(d));

        int e = methods.enterNumber();
        int f = methods.enterNumber();
        System.out.println(e + " raised to the second power is " + methods.powering(e, Methods.SQUARE));
        System.out.println(f + " raised to the third power is " + methods.powering(f, Methods.CUBE));


    }
}
