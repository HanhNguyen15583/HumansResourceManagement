package hanh.project4;
public abstract class Staff implements Comparable<Staff>{
    private int id;
    private String name;
    private int age;
    private double discount;
    private String startWorkingDay;
    private String department;
    private int numberOfDayOff;

    public Staff(int id, String name, int age, double discount, String startWorkingDay, String department, int numberOfDayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.discount = discount;
        this.startWorkingDay = startWorkingDay;
        this.department = department;
        this.numberOfDayOff = numberOfDayOff;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setStartWorkingDay(String startWorkingDay) {
        this.startWorkingDay = startWorkingDay;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setNumberOfDayOff(int numberOfDayOff) {
        this.numberOfDayOff = numberOfDayOff;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getDiscount() {
        return discount;
    }

    public String getStartWorkingDay() {
        return startWorkingDay;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumberOfDayOff() {
        return numberOfDayOff;
    }

    abstract public int calculateSalary();


    public int compareTo(Staff staff) {
        return this.calculateSalary() - staff.calculateSalary();
    }

    abstract void displayInformation();
}



