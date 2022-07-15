package hanh.project4;

import java.util.ArrayList;

public class Department  {
    public int idOfDepartment;
    public String nameOfDepartment;
    public int numberOfEmployee;

    public Department(int idOfDepartment, String nameOfDepartment, int numberOfEmployee) {
        this.idOfDepartment = idOfDepartment;
        this.nameOfDepartment = nameOfDepartment;
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setIdOfDepartment(int idOfDepartment) {
        this.idOfDepartment = idOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public int getIdOfDepartment() {
        return idOfDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    // Phương thức hiển thị tên bộ phận cũng như số lượng nhân viên từng bộ phận
    public String toString() {
            return "\nId of Department: " + idOfDepartment + ", Name of Department: " + nameOfDepartment + ", Number of Employee: " + numberOfEmployee;
        }
}


