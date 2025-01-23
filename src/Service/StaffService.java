package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Model.Members;


public class StaffService extends MemberService{
    private Members members = new Members();

    public void add(String name, String email, String role) {
        if (getMemberList().containsKey(members.cleanInput(name))) {
            System.out.println("Staff member already exists!");
            return;
        }

        String cleanedName = members.cleanInput(name);
        String cleanedEmail = members.cleanInput(email);
        String cleanedRole = members.cleanInput(role);

        ArrayList<String> details = new ArrayList<>();
        details.add(cleanedEmail);
        details.add(cleanedRole);

        getMemberList().put(cleanedName, String.join(" | ", details));
        System.out.printf("\nNew Staff successfully registered! Welcome %s!\n", name);
    }

    public void edit(String searchedName, Scanner scanner) {
        String cleanedSearchedName = members.cleanInput(searchedName);

        if (!getMemberList().containsKey(cleanedSearchedName)) {
            System.out.printf("\nNo staff with the name '%s' found!", cleanedSearchedName);
            return;
        }

        System.out.println("New Name: ");
        String cleanedNewName = members.cleanInput(scanner.nextLine());
        System.out.println("New Email: ");
        String cleanedNewEmail = members.cleanInput(scanner.nextLine());
        System.out.println("New Role: ");
        String cleanedNewRole = members.cleanInput(scanner.nextLine());

        ArrayList<String> details = new ArrayList<>();
        details.add(cleanedNewEmail);
        details.add(cleanedNewRole);

        getMemberList().remove(searchedName);
        getMemberList().put(cleanedNewName, String.join(" | ", details));
        System.out.printf("""
                
                Member details updated successfully!
                Name: %s
                Email: %s
                Role: %s
                """, cleanedNewName, cleanedNewEmail, cleanedNewRole);
    }

    public void searchByRole(String role) {
        boolean found = false;

        for (Map.Entry<String, String> entry : getMemberList().entrySet()) {
            String value = String.valueOf(entry.getValue());
            String[] parts = value.split(" \\| ");
            if (parts[1].equals(role)) {
                String email = parts[0];
                String name = String.valueOf(entry.getKey());
                System.out.printf("\nName: %s, Email: %s, Role: %s", name, email, role);
                found = true;
            }

            if(!found){
                System.out.println("Role not found!");
            }
        }
    }
}
