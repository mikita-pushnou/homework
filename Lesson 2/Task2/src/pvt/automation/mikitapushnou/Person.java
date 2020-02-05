package pvt.automation.mikitapushnou;

public class Person {
    private int age;
    private static final int ADULT = 18;

    protected boolean isAdult(int age) {

        return age > ADULT;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
