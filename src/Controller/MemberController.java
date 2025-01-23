package Controller;

import Service.MemberService;

import java.util.Map;
import java.util.Scanner;

public class MemberController {
    private final MemberService memberService = new MemberService();
    private UserInterface userInterface;
    private boolean running = true;

    public MemberController(){   }

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start(Scanner scanner) {
        while (running) {
            System.out.print("""
                    
                    =======================================================================
                    
                    Member Options:
                    1. Sign up new member.
                    2. Edit existing member.
                    3. Find a member's details.
                    4. Member list.
                    5. Delete member.
                    6. Back to main menu.
                    7. Quit program.
                    
                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input, scanner);
        }
    }

    public void inputReader(String input, Scanner scanner) {
        switch (input) {
            case "1" -> signUp(scanner);
            case "2" -> editMember(scanner);
            case "3" -> searchByName(scanner);
            case "4" -> listMembers();
            case "5" -> deleteMember(scanner);
            case "6" -> userInterface.start(scanner);
            case "7" -> {
                System.out.println("""
                        
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                running = false;
                userInterface.end();
            }
            default -> System.out.println("\nInvalid option!");
        }
    }

    public void signUp(Scanner scanner) {
        System.out.print("\nName: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        memberService.add(name, email);
    }

    public void editMember(Scanner scanner) {
        System.out.print("\nSearch for (name): ");
        String searchedName = scanner.nextLine();

        memberService.edit(searchedName, scanner);
    }

    public void searchByName(Scanner scanner) {
        System.out.print("\nSearch for (name): ");
        String searchedName = scanner.nextLine();

        memberService.searchbyName(searchedName);
    }

    public void deleteMember(Scanner scanner) {
        System.out.print("\nName of member to delete: ");
        String searchedName = scanner.nextLine();

        memberService.delete(searchedName);
    }

    public void listMembers() {
        if(memberService.getMemberList().isEmpty()){
            System.out.println("\nList is currently empty!\n");
        }

        System.out.println("\nList of Members:");
        for (Map.Entry<String, String> member : memberService.getMemberList().entrySet()) {
            System.out.println("Name: " + member.getKey() + ", Email: " + member.getValue());
        }
    }
}
