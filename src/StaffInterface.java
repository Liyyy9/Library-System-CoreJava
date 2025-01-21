import java.util.Scanner;

public class StaffInterface {
    private UserInterface userInterface;

    public StaffInterface(){    }

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start(Scanner scanner){
        while (true) {
            System.out.println("""
                    =======================================================================
                    
                    Member Options:
                    1. Register new staff.
                    2. Edit existing staff.
                    3. Find a staff's email by their name.
                    4. Find a staff's name by their email.
                    5. Find staffs by their role.
                    6. Staff list.
                    7. Delete staff.
                    8. Back to main menu.
                    9. Quit program.
                    
                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }

    public void inputReader(String input){
        switch (input) {
            case "1" -> newStaff();
            case "2" -> editStaff();
            case "3" -> searchByName();
            case "4" -> searchByEmail();
            case "5" -> searchByRole();
            case "6" -> listStaff();
            case "7" -> deleteStaff();
            case "8" -> userInterface.start();
            case "9" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("WRONG entry!");
        }
    }

    private void newStaff() {

    }

    private void editStaff() {
    }

    private void searchByName() {
    }

    private void searchByEmail() {
    }

    private void searchByRole() {
    }

    private void listStaff() {
    }

    private void deleteStaff() {
    }



}
