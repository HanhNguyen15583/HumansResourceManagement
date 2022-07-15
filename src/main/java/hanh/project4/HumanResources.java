package hanh.project4;

import console.lib.Console;

import java.util.ArrayList;
import java.util.Collections;
public class HumanResources {

    public ArrayList<Staff> listStaffInput = null; // tạo mảng đầu vào của danh sách nhân viên
    public ArrayList<Department> listDepartmentInput = null; // // tạo mảng đầu vào của danh sách các bộ phận

    public HumanResources() {
        this.listStaffInput = staffInformation(); // gán mảng đầu vào của danh sách nhân viên bằng mảng danh sách nhân viên có sẵn
        this.listDepartmentInput = departmentInformation(); //// gán mảng đầu vào của danh sách các bộ phận bằng mảng danh sách các bộ phận có sẵn
    }

    public ArrayList<Staff>  getListStaffInput() {
        return this.listStaffInput;
    }
    public ArrayList<Department>  getListDepartmentInput() {
        return this.listDepartmentInput;
    }
    public void setListEmployeeInput(ArrayList<Staff> input ) {
        this.listStaffInput = input;
    }
    public void setListDepartmentInput(ArrayList<Department> input ) {
        this.listDepartmentInput = input;
    }

    // Tạo phương thức trả về các số từ 1 đến 7 tương ứng với các chức năng cơ bản
    public int printFeatures() {
        System.out.println("\n-----------------Chương Trình Chính ----------------\n");
        System.out.println("Có 7 chức năng như sau: ");
        System.out.println("\n1: Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2: Hiển thị các bộ phận trong công ty");
        System.out.println("3: Hiển thị các nhân viên theo từng bộ phận");
        System.out.println("4: Thêm nhân viên mới vào công ty");
        System.out.println("5: Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
        System.out.println("6: Hiển thị bảng lương của nhân viên theo thứ tự tăng dần");
        System.out.println("7: Hiển thị bảng lương của nhân viên theo thứ tự giảm dần");
        int num = Integer.valueOf(Console.getInputKeyboard("\nBạn muốn chọn chức năng nào? "));
        return num;
    }

    // tạo phương thức trả về mảng danh sách nhân viên có sẵn
   public ArrayList<Staff> staffInformation(){
       ArrayList<Staff> listStaff = new ArrayList<Staff>();
       Staff ep1 = new Employee(1, "Nguyen Thi Sau", 29, 1.5,
               "15/4/2019", "Kinh doanh", 5, 20);
       Staff ep2 = new Employee(2, "Le Van Tam", 31, 0.5,
               "10/4/2020", "Du an", 7, 15);
       Staff mg1 = new Manager(6,"Tran Quoc Bay", 26, 3.0,
               "20/2/2020","Ky thuat", 10, "Business Leader");
       Staff mg2 = new Manager(8,"Nguyen Van Ba", 35, 2.5,
               "20/2/2020","Kinh doanh", 8, "Project Leader");
       Staff mg3 = new Manager(9,"Pham Van Tu", 25, 2.8,
               "20/2/2020","Ky thuat", 9, "Technical Leader");
       Staff ep3 = new Employee(7, "Le Van Chin", 32, 0.5,
               "10/4/2020", "Du an", 5, 15);
       Staff ep4 = new Employee(10, "Le Van Nam", 35, 1.5,
               "15/4/2020", "Ky thuat", 7, 25);
       listStaff.add(ep1);
       listStaff.add(ep2);
       listStaff.add(mg1);
       listStaff.add(mg2);
       listStaff.add(mg3);
       listStaff.add(ep3);
       listStaff.add(ep4);
       return  listStaff;
   }

    // tạo phương thức hiển thị danh sách nhân viên
    public void displayInformationOfStaff(ArrayList<Staff> listStaff) {
        for(Staff element: listStaff) {
            element.displayInformation();
        }
    }

    // Tạo phương thức trả về mảng danh sách các bộ phận
    public ArrayList<Department> departmentInformation() {
        ArrayList<Department> listDepartment = new ArrayList<Department>();
        Department dp1 = new Department(1111, "Kinh doanh", 0);
        Department dp2 = new Department(2222, "Ky thuat", 0);
        Department dp3 = new Department(3333, "Du an", 0);
        listDepartment.add(dp1);
        listDepartment.add(dp2);
        listDepartment.add(dp3);
        // duyệt từng đối tượng của mảng danh sách nhân viên,
        for(Staff element : staffInformation()) {
            // duyệt từng đối tượng của mảng danh sách bộ phận
            // Nếu tên bộ phận trùng nhau thì số lượng nhân viên được tăng thêm 1
            for(Department dp : listDepartment) {
                if (dp.getNameOfDepartment().equalsIgnoreCase(element.getDepartment())) {
                    dp.numberOfEmployee++;
                }
            }
        }
        // Trả về mảng danh sách các bộ phận
        return listDepartment;
    }

    // tạo phương thức hiển thị các bộ phận trong công ty
    public void displayListOfDepartment(ArrayList<Department> listDepartment) {
        for(Department element : listDepartment) {
            System.out.println(element.toString());
        }
    }

    // Tạo phương thức kiểm tra xem có tên bộ phận đó khi nhập vào không
    public boolean checkDepartment(String nameDepartment) {
        // duyệt từng đối tượng của mảng danh sách các bộ phận nhập vào,
        // nếu tên bộ phận trùng nhau thì số lượng nhân viên được tăng thêm 1 và trả về true
        for(Department element : getListDepartmentInput()) {
            if( nameDepartment.equalsIgnoreCase(element.getNameOfDepartment())) {
                element.numberOfEmployee++;
                return true;
            }
        }
        // Nếu không trùng nhau thì trả về false
        return false;

    }

    // Tạo phương thức trả về danh sách tên phòng ban có tham số là danh sách các bộ phận
    public ArrayList<String> getListOfNameDepartment(ArrayList<Department>  listDepartment) {
        ArrayList<String> listD = new ArrayList<String>();
        // duyệt từng phần tử của mảng, nếu mảng không chứa tên trong danh sách bộ phận thì thêm tên vào mảng
        for(Department element : listDepartment) {
            if(!listD.contains(element.getNameOfDepartment()))
            listD.add(element.getNameOfDepartment());
        }
        // Nếu mảng có tên rồi thì trả vể mảng tên
        return listD;
    }

    // Tao phương thức hiển thị danh sách nhân viên theo từng bộ phận
    public void displayListStaffWithDepartment(ArrayList<Staff>  listStaff ) {
        // khai báo mảng chứa danh sách tên bộ phận lấy dữ liệu từ đầu vào ( bao gồm cả dữ liệu có sẵn)
        ArrayList<String> li = getListOfNameDepartment(getListDepartmentInput());
        for(String e : li) {
            System.out.println("\nDanh sách nhân viên của bộ phận " + e + " là: ");
            for(Staff element : listStaff) {
                if(element.getDepartment().equalsIgnoreCase(e))
                    element.displayInformation();
            }
        }
    }

    // Tạo phương thức thêm nhân viên mới
    public void insertNewStaff() {
        int insert = 1;
        // dùng do...while để lặp lại việc nhập thông tin nhân viên mới
        do {
            int num = Integer.valueOf(Console.getInputKeyboard("\nBạn muốn thêm nhân viên thông thường hay nhân viên là cấp quản lý? (1 = Nhân viên thông thường, 2 = Quản lý): "));
            int id = Integer.valueOf(Console.getInputKeyboard("\nId: "));
            String name = Console.getInputKeyboard("Name: ");
            int age = Integer.valueOf(Console.getInputKeyboard("Age: "));
            double discount = Double.valueOf(Console.getInputKeyboard("Discount: "));
            String startWorkingDay = Console.getInputKeyboard("Start Working Day: ");
            String department = Console.getInputKeyboard("Department: ");
            // kiểm tra xem có tên bộ phận đó khi nhập vào không, nếu có thì nhập tiếp thông tin, nếu không có thì yêu cầu nhập lại
            if(checkDepartment(department)) {
                int numberOfDayOff = Integer.valueOf(Console.getInputKeyboard("Number of Day off: "));
                if (num == 1) {
                    // nếu là nhân viên thường thì nhập thêm số giờ làm thêm
                    int overtimehour = Integer.valueOf(Console.getInputKeyboard("Number of overtime hour: "));
                    Staff st1 = new Employee(id, name, age, discount, startWorkingDay, department, numberOfDayOff, overtimehour);
                    getListStaffInput().add(st1);
                } else {
                    // nếu là quản lý thì nhập thêm vị trí
                    String position = Console.getInputKeyboard("Position: ");
                    Staff st1 = new Manager(id, name, age, discount, startWorkingDay, department, numberOfDayOff, position);
                    getListStaffInput().add(st1);
                }
                insert = Integer.valueOf(Console.getInputKeyboard("\nBạn có muốn tiếp tục thêm nhân viên không? (1 = Yes, 2 = No) "));
            }else {
                System.out.println("\nKhông có bộ phận này. Xin mời bạn nhập lại.");
            }
        } while(insert == 1);
        displayInformationOfStaff(getListStaffInput());
    }

    // Tạo phương thức kiểm tra xem tên hoặc id có tồn tại trong danh sách nhân viên hay không
    public boolean checkNameOrId(String name, int id ,  ArrayList<Staff> datainput) {
        boolean checked = false;
        // Xét trường hợp check tên, nếu không có tên thì trả về false, nếu có tên thì in ra thông tin
        if (!name.equals("") && id==-1) {
            for (Staff element : datainput) {
                if (element.getName().equalsIgnoreCase(name)) {
                    System.out.println("\nDưới đây là thông tin của " + element.getName() + ": ");
                    element.displayInformation();
                    checked = true;
                }
            }
        }
        // Xét trường hợp check id, nếu id không có thì trả về false, nếu có thì in ra thông tin
        if(name.equals("") && id !=-1) {
            for (Staff element : datainput) {
                if (element.getId() ==id) {
                    System.out.println("\nDưới đây là thông tin của " + id + ": ");
                    element.displayInformation();
                    checked = true;
                }
            }
        }
        return checked;
    }

    // Tạo phương thức tìm kiếm nhân viên
    public void searchStaff() {
        // dùng vòng lặp để lặp lại chức năng tìm kiếm nhân viên theo tên hoặc theo mã
        int check = 1;
        do {
            ArrayList<Staff> t = getListStaffInput();
            int num = Integer.valueOf(Console.getInputKeyboard("\nBạn muốn tìm nhân viên theo tên hay theo mã? (1 = Tên, 2 = Mã): "));
            if (num == 1) {
                String name = Console.getInputKeyboard("Mời bạn nhập tên: ");
                boolean resultsearch = checkNameOrId(name, -1, t);
                if (!resultsearch) {
                    System.out.println("\nKhông tìm thấy tên");
                }
            }

            if (num == 2) {
                int id = Integer.valueOf(Console.getInputKeyboard("\nMời bạn nhập mã nhân viên: "));
                boolean resultsearch = checkNameOrId("", id, t);
                if (!resultsearch) {
                    System.out.println("\nKhông tìm thấy mã nhân viên");
                }
            }
            check = Integer.valueOf(Console.getInputKeyboard("\nBạn có muốn tiếp tục tìm kiếm không? (1 = yes, 2 = No): "));
        } while (check == 1);

    }

    // tạo phương thức hiển thị lương nhân viên  theo thứ tự tăng dần
    public void displayEmployeeSalaryInAscendingOrder() {
        ArrayList<Staff> t = getListStaffInput();
        Collections.sort(t);
        displayInformationOfStaff(t);
    }

    // tạo phương thức hiển thị lương nhân viên theo thứ tự giảm dần
    public  void displayEmployeeSalaryInDescendingOrder() {
        ArrayList<Staff> tt = getListStaffInput();
        Collections.sort(tt, Collections.reverseOrder());
        displayInformationOfStaff(tt);
    }

    // tạo phương thức thực hiện các chức năng
    public void executeFeatures() {
        int feature = printFeatures();

        switch(feature) {
            case 1:
                displayInformationOfStaff(getListStaffInput());
                break;
            case 2:
                displayListOfDepartment(getListDepartmentInput());
                break;
            case 3:
                displayListStaffWithDepartment(getListStaffInput());
                break;
            case 4:
                insertNewStaff();
                break;
            case 5:
                searchStaff();
                break;
            case 6:
                displayEmployeeSalaryInAscendingOrder();
                break;
            case 7:
                displayEmployeeSalaryInDescendingOrder();
                break;
            default:
        }
    }

    public static void main(String[] args) {
        HumanResources hr  = new HumanResources();
        hr.executeFeatures();
        int num = 1;
        while(num == 1) {
            num = Integer.valueOf(Console.getInputKeyboard("\nBạn có muốn tiếp tục thực hiện các chức năng khác không? (1 = Yes, 2 = No) "));
            if (num == 1)
                hr.executeFeatures();
            if (num == 2)
                System.out.println("Tạm biệt!");
        }
    }
}
