package hanh.project4;

public class Employee extends Staff implements ICalculator {
    private int overtimeHour;

    public Employee(int id, String name, int age, double discount, String startWorkingDay, String department, int numberOfDayOff, int overtimeHour) {
        super(id, name, age, discount, startWorkingDay, department, numberOfDayOff);
        this.overtimeHour = overtimeHour;
    }
    public void setOvertimeHour(int overtimeHour) {
        this.overtimeHour =overtimeHour;
    }

    public int getOvertimeHour() {
        return overtimeHour;
    }

    public int calculateSalary() {
        return (int)(getDiscount()*3000000 + (double)getOvertimeHour() * 200000);
    }

    public void displayInformation() {
        System.out.println("\nId: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Discount: " + getDiscount());
        System.out.println("Start Working Day: " + getStartWorkingDay());
        System.out.println("Department: " + getDepartment());
        System.out.println("Number of Day off: " + getNumberOfDayOff());
        System.out.println("Number of Overtime Hours: " + getNumberOfDayOff());
        System.out.println("Salary: " + calculateSalary());
    }


}
