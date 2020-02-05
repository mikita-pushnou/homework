package pvt.automation.mikitapushnou;

public class Task2 {

    public static void main(String[] args) {
	    Student student = new Student();
	    student.setId(1);
	    int id = student.getId();
	    student.setName("John");
        String name = student.getName();
        student.setSurname("Doe");
        String surname = student.getSurname();
        student.setPhone(375291111111L);
        long phone = student.getPhone();
        student.setAge(20);
        int age = student.getAge();

        student.printFullName(name, surname);
        student.printPhone(phone);
        System.out.println("Adult: " + student.isAdult(age));
        //student.printId(id);
    }
}
