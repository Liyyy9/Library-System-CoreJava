import Controller.BookController;
import Controller.MemberController;
import Controller.StaffController;
import Controller.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface();
        MemberController memberController = new MemberController();
        StaffController staffController = new StaffController();
        BookController bookController = new BookController();

        userInterface.setMemberController(memberController);
        userInterface.setStaffController(staffController);
        userInterface.setBookController(bookController);
        memberController.setUserInterface(userInterface);
        staffController.setUserInterface(userInterface);
        bookController.setUserInterface(userInterface);

        userInterface.start(scanner);

        scanner.close();
    }
}