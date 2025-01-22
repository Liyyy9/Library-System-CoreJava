import java.util.Scanner;


public class UserInterface {
    private MemberInterface memberInterface;
    private StaffInterface staffInterface;
    private boolean running;

    public UserInterface() {
        this.running = true;
    }

    public void setMemberInterface(MemberInterface memberInterface) {
        this.memberInterface = memberInterface;
    }

    public void setStaffInterface(StaffInterface staffInterface) {
        this.staffInterface = staffInterface;
    }

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
            case "1" -> memberInterface.start(scanner);
            case "2" -> staffInterface.start(scanner);
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
