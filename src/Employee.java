public class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final String department;
    private double salary;
    private static int idBase = 100;

    public Employee(int id,String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        idBase++;
        this.id = idBase + id;
    }
    public void setSalary(double percentage){
        this.salary = salary * (1 + (percentage/100));
    }
    public String getDepartment(){
        return department;
    }

    public int getAge() {
        return age;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee " +
                "ID: " + id +
                ", Name: " + name +
                ", Age: " + age +
                ", Department: " + department +
                ", Salary: " + salary +
                ".\n";
    }

}
