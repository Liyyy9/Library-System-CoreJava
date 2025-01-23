package Controller;

import Model.Members;
import Service.MemberService;
import Service.StaffService;

import java.util.Map;
import java.util.Scanner;

public class StaffController {
    private UserInterface userInterface;
    private boolean running = true;
    private StaffService staffService = new StaffService();
    private MemberService memberService = new MemberService();
    private Members members = new Members();

    public StaffController(){
        this.staffService = new StaffService();
    }

    public void setUserInterface(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public void start(Scanner scanner){
        while (running) {
            System.out.print("""
                    
                    =======================================================================
                    
                    Staff Options:
                    1. Register new staff.
                    2. Edit existing staff.
                    3. Find a staff's details.
                    4. Search staffs under a certain Role.
                    5. Staff list.
                    6. Delete staff.
                    7. Back to main menu.
                    8. Quit program.
                    
                    Choose option: \s""");
            String input = scanner.nextLine();

            inputReader(input, scanner);
        }
    }

    public void inputReader(String input, Scanner scanner){
        switch (input) {
            case "1" -> newStaff(scanner);
            case "2" -> editStaff(scanner);
            case "3" -> searchStaff(scanner);
            case "4" -> searchByRole(scanner);
            case "5" -> listStaff();
            case "6" -> deleteStaff(scanner);
            case "7" -> userInterface.start(scanner);
            case "8" -> {
                System.out.println("""
                        
                        Thank you for using our Library System! Goodbye!
                        =======================================================================
                        """);
                running = false;
                userInterface.end();
            }
            default -> System.out.println("Invalid option!");
        }
    }

    private void newStaff(Scanner scanner) {
        System.out.println("\nName: ");
        String name = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Role: ");
        String role = scanner.nextLine();

        staffService.add(name, email, role);
    }

    private void editStaff(Scanner scanner) {
        System.out.print("\nSearch for (name): ");
        String searchedName = scanner.nextLine();

        staffService.edit(searchedName, scanner);
    }

    private void searchStaff(Scanner scanner) {
        System.out.print("\nSearch for (name):");
        String searchedName = members.cleanInput(scanner.nextLine());

        staffService.searchbyName(searchedName);
    }
    private void searchByRole(Scanner scanner) {
        System.out.print("\nRole: ");
        String searchedRole = members.cleanInput(scanner.nextLine());

        staffService.searchByRole(searchedRole);
    }

    private void listStaff() {
        System.out.println("\nList of Staff members:");
        Map<String, String> memberList = staffService.getMemberList();

        if(memberList.isEmpty()){
            System.out.println("No staff members found!");
            return;
        }

        for (Map.Entry<String, String> member : memberList.entrySet()) {
            String[] parts = member.getValue().split(" \\| ");

            String name = member.getKey();
            String email = parts[0];
            String role = parts[1];

            System.out.printf("Name: %s, Email: %s, Role: %s\n", name, email, role);
        }
    }

    private void deleteStaff(Scanner scanner) {
        System.out.print("Staff name to remove: ");
        String cleanedSearchedName = members.cleanInput(scanner.nextLine());

        staffService.delete(cleanedSearchedName);
    }



}
