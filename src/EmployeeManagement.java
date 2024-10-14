import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private final String filePath = "src/employeeList.txt";
    File listFile = new File(filePath);
    List<Employee> employeeList = new ArrayList<>();

    public void populateList(){
        if (listFile.exists() && listFile.canRead()){
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

            }catch (FileNotFoundException e){
                System.out.println("Error 101");
            }
        }
    }

}
