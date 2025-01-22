import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface();
        MemberInterface memberInterface = new MemberInterface();
        StaffInterface staffInterface = new StaffInterface();

        // Set dependencies
        userInterface.setMemberInterface(memberInterface);
        userInterface.setStaffInterface(staffInterface);
        memberInterface.setUserInterface(userInterface);
        staffInterface.setUserInterface(userInterface);

        // Start the user interface
        userInterface.start(scanner);

        scanner.close();
    }
}