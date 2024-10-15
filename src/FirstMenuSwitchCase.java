import java.util.Scanner;

public class FirstMenuSwitchCase {

    Scanner scan = new Scanner(System.in);
    EmployeeManagement employeeManagement = new EmployeeManagement();

    public void mainMenu(){
        System.out.println("Select: ");
        System.out.println("1 Find employees of the IT department");
        System.out.println("2 Sort employees by age");
        System.out.println("3 average salary");
        System.out.println("4 Highest salary for the Finance department");
        System.out.println("5 Employee grouped by department");
        System.out.println("6 Increase salaries by 10%");
        System.out.println("7 to exit");
        String selection = scan.nextLine();
        switch (selection){
            case "1" -> employeeManagement.findEmployeeIt();
            case "2" -> employeeManagement.sortByAge();
            case "3" -> employeeManagement.averageSalary();
            case "4" -> employeeManagement.highSalaryFinance();
            case "5" -> employeeManagement.employeeGroupedByDepartment();
            case "6" -> employeeManagement.increaseSalary();
            case "7" -> System.exit(0);
            default -> mainMenu();
        }
    }
}