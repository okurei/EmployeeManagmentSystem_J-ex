import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeManagement {
    private final String filePath = "src/employeeList.txt";
    File listFile = new File(filePath);
    List<Employee> employeeList = new ArrayList<>();

    public void populateList(){
        if (listFile.exists() && listFile.canRead()){
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
                employeeList = bufferedReader.lines()
                        .map(line-> {
                            String[] data = line.split(", ");
                            try{return new Employee(
                                Integer.parseInt(data[0].trim()),
                                data[1].trim(),
                                Integer.parseInt(data[2].trim()),
                                data[3].trim(),
                                Double.parseDouble(data[4].trim())
                            );}catch (NumberFormatException e){return null;}
                        }).toList();

            }catch (IOException e){
                System.out.println("Error 101");
            }
        }
        int counter = 0;
        for (Employee employee : employeeList){
            counter++;
            System.out.println("Line: " + counter+"\n" + employee);
        }
    }
    public void findEmployeeIt(){
        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("IT"))
                .forEach(System.out::println);
    }
    public void sortByAge(){
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
                .forEach(System.out::println);
    }
    public void averageSalary(){
        System.out.println(
        employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0));
    }
    public void highSalaryFinance(){
        employeeList.stream()
                .filter(employee -> employee.getDepartment().equals("Finance"))
                .max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);
    }
    public void employeeGroupedByDepartment(){
        //first method used, the second after checking.
        /**List<Employee> financeEmployee = employeeList.stream().filter(employee -> employee.getDepartment().equals("Finance")).toList();
        List<Employee> hrEmployee = employeeList.stream().filter(employee -> employee.getDepartment().equals("HR")).toList();
        List<Employee> itEmployee = employeeList.stream().filter(employee -> employee.getDepartment().equals("IT")).toList();
        System.out.println("HR employee\n"+ hrEmployee + "\n Finance employee\n"+ financeEmployee + "\nIT employee"+ itEmployee);*/
        Map<String, List<Employee>> employeeByDepartment = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(employeeByDepartment);

    }
    public void increaseSalary(){
        employeeList.forEach(employee -> employee.setSalary(10));
        int counter = 0;
        for (Employee employee : employeeList) {
            counter++;
            System.out.println("Line: " + counter + "\n" + employee);
        }
    }
}
