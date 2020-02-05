package pvt.automation.mikitapushnou;

public class Student extends Person {
    private String name;
    private String surname;
    private long phone;
    private static final int ADULT = 21;

    private int id;

    public void printFullName(String name, String surname) {
        System.out.println(name + " " + surname);
    }

    void printPhone(long phone) {
        System.out.println("Phone: " + phone);
    }

    protected boolean isAdult(int age) {
        return age > ADULT;
    }

    private void printId(int id) {
        System.out.println("Id: " + id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

}
