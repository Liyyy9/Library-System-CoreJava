package Controller;

import java.util.Scanner;


public class UserInterface {
    private MemberController memberController;
    private StaffController staffController;
    private BookController bookController;
    private boolean running;

    public UserInterface() {
        this.running = true;
    }

    public void setMemberController(MemberController memberController) {
        this.memberController = memberController;
    }

    public void setStaffController(StaffController staffController) {
        this.staffController = staffController;
    }

    public void setBookController(BookController bookController){ this.bookController = bookController; }

    public void start(Scanner scanner) {
        System.out.println("\n=======================================================================");
        while (running) {
            System.out.println("""
                    
                    Welcome to our Library System. Please choose from the options below.
                    1. Members.
                    2. Staff.
                    3. Books.
                    4. Quit Program.
                    
                    Choose option:\s""");
            String input = scanner.nextLine();

            inputReader(input, scanner);
        }
    }

    public void inputReader(String input, Scanner scanner) {
        switch (input) {
            case "1" -> memberController.start(scanner);
            case "2" -> staffController.start(scanner);
            case "3" -> bookController.start(scanner);
            case "4" -> {
                System.out.println("""
                        
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                running = false;
                System.exit(0);
            }
            default -> System.out.println("""
                   
                   Invalid entry!
                   =======================================================================
                   """);
        }
    }

    public void end(){
        System.exit(0);
    }
}
