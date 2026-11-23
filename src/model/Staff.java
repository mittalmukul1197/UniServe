package model;

public class Staff extends User {

    private String employeeId;
    private String designation;

    public Staff(int id, String name, String email,
                 String password, String employeeId,
                 String designation) {

        super(id, name, email, password);

        this.employeeId = employeeId;
        this.designation = designation;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String getRole() {
        return "STAFF";
    }

    @Override
    public void displayDetails() {

        super.displayDetails();

        System.out.println("Employee ID: " + employeeId);
        System.out.println("Designation: " + designation);
    }
}