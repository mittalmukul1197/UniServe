package model;

public class Student extends User {

    private String studentId;
    private String course;
    private int year;

    public Student(int id, String name, String email,String password, String studentId,
        String course, int year) {

        super(id, name, email, password);

        this.studentId = studentId;
        this.course = course;
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String getRole() {
        return "STUDENT";
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Year: " + year);
    }
}
