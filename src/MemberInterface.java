import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MemberInterface {
    private Members members = new Members();
    private UserInterface userInterface;

    public MemberInterface(){   }

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start(Scanner scanner) {
        while (true) {
            System.out.println("""
                    =======================================================================
                    
                    Member Options:
                    1. Sign up new member.
                    2. Edit existing member.
                    3. Find a member's email by their name.
                    4. Find a member's name by their email.
                    5. Member list.
                    6. Delete member.
                    7. Back to main menu.
                    8. Quit program.
                    
                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input);
        }
    }

    public void inputReader(String input) {
        switch (input) {
            case "1" -> signUp();
            case "2" -> editMember();
            case "3" -> searchByName();
            case "4" -> searchByEmail();
            case "5" -> listMembers();
            case "6" -> deleteMember();
            case "7" -> userInterface.start();
            case "8" -> {
                System.out.println("""
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                System.exit(0);
            }
            default -> System.out.println("Invalid entry!");
        }
    }

    public void signUp() {
        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        members.add(name, email);
    }

    public void editMember() {
        System.out.println("Search for (name): ");
        String searchedName = scanner.nextLine();

        members.edit(searchedName, scanner);
    }

    public void searchByName() {
        System.out.println("Search for (name): ");
        String searchedName = scanner.nextLine();

        members.searchbyName(searchedName);
    }

    public void searchByEmail() {
        System.out.println("Search for (email): ");
        String searchedEmail = scanner.nextLine();

        members.searchbyEmail(searchedEmail);
    }

    public void deleteMember() {
        System.out.println("Name of member to delete: ");
        String searchedName = scanner.nextLine();

        members.delete(searchedName);
    }

    public void listMembers() {
        System.out.println("List of Members:");
        // Access the memberList from the Members instance
        for (Map.Entry<String, String> member : members.getMemberList().entrySet()) {
            System.out.println("Name: " + member.getKey() + ", Email: " + member.getValue());
        }
    }
}
