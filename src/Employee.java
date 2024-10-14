public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;
    private static int idBase = 100;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        idBase++;
        this.id = idBase;
    }
    public void setSalary(double percentage){
        this.salary = salary * (1 + (percentage/100));
    }

    @Override
    public String toString() {
        return "Employee: " +
                "id: " + id +
                ", name:'" + name + '\'' +
                ", age: " + age +
                ", department: '" + department + '\'' +
                ", salary: " + salary +
                ".\n";
    }

}
