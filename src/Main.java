public class Main {
    public static void main(String[] args) {
        FirstMenuSwitchCase firstMenuSwitchCase = new FirstMenuSwitchCase();
        firstMenuSwitchCase.employeeManagement.populateList();
        for(int i = 0; i < 10; i++){
            firstMenuSwitchCase.mainMenu();
        }
    }
}