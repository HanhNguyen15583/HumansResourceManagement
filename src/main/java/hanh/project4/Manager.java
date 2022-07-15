package hanh.project4;

import java.util.ArrayList;

public class Manager extends Staff implements ICalculator {
    public String position;
    public int salary;
    public Manager(int id, String name, int age, double discount, String startWorkingDay, String department, int numberOfDayOff, String position) {
        super(id, name, age, discount, startWorkingDay, department, numberOfDayOff);
        this.position = position;
    }

    public void setPosition(String position) {
        this.position =position;
    }

    public String getPosition() {
        return position;
    }

    public int calculateSalary() {

        if(getPosition().equalsIgnoreCase("Business Leader"))
            salary =  (int)(getDiscount() * 5000000 + 8000000);
        if(getPosition().equalsIgnoreCase("Project Leader"))
            salary = (int)(getDiscount() * 5000000 + 5000000);
        if(getPosition().equalsIgnoreCase("Technical Leader"))
            salary = (int)(getDiscount() * 5000000 + 6000000);
        return  salary;
    }


    public void displayInformation() {
        System.out.println("\nId: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Discount: " + getDiscount());
        System.out.println("Start Working Day: " + getStartWorkingDay());
        System.out.println("Department: " + getDepartment());
        System.out.println("Number of Day off: " + getNumberOfDayOff());
        System.out.println("Position: " + getPosition());
        System.out.println("Salary: " + calculateSalary());
    }
}
