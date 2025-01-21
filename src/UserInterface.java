import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private MemberInterface memberInterface;
    private StaffInterface staffInterface;

    public UserInterface() {
    }

    public void setMemberInterface(MemberInterface memberInterface) {
        this.memberInterface = memberInterface;
    }

    public void setStaffInterface(StaffInterface staffInterface) {
        this.staffInterface = staffInterface;
    }

    public void start() {
        System.out.println("=======================================================================");
        while (true) {
            System.out.println("""
                    Welcome to our Library System. Please choose from the options below.
                    1. Members.
                    2. Staff.
                    3. Books.
                    4. Quit Program.
                    
                    Choose option:\s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }

    public void inputReader(String input) {
        switch (input) {
            case "1" -> memberInterface.start(scanner);
            case "2" -> staffInterface.start(scanner);
            case "4" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("""
                   Invalid entry!
                   =======================================================================
                    """);
        }
    }
}
