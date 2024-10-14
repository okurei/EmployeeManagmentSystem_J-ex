import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                            return new Employee(
                                Integer.parseInt(data[0].trim()),
                                data[1].trim(),
                                Integer.parseInt(data[2].trim()),
                                data[3].trim(),
                                Double.parseDouble(data[4].trim())
                            );
                        }).toList();

            }catch (IOException e){
                System.out.println("Error 101");
            }
        }
        for (Employee employee : employeeList){
            System.out.println(employee);
        }
    }

}
