package Service;

import java.util.HashMap;
import java.util.Scanner;

import Model.Members;

public class MemberService {
    private HashMap<String, String> memberList = new HashMap<>();
    private Members members = new Members();

    public void add(String name, String email) {
        if (memberList.containsValue(email)) {
            System.out.println("\nMember already exists!");
            return;
        }
        String cleanedName = members.cleanInput(name);
        String cleanedEmail = members.cleanInput(email);
        memberList.put(cleanedName, cleanedEmail);
        System.out.printf("\nNew member successfully registered! Welcome %s!\n", name);
    }

    public void edit(String searchedName, Scanner scanner) {
        String cleanedSearchedName = searchedName.toLowerCase().trim();
        if (!memberList.containsKey(cleanedSearchedName)) {
            System.out.printf("\nNo member with the name '%s' found!\n", searchedName);
            return;
        }

        System.out.println("New name: ");
        String cleanedNewName = members.cleanInput(scanner.nextLine());
        System.out.println("New email: ");
        String cleanedNewEmail = members.cleanInput(scanner.nextLine());

        memberList.remove(cleanedSearchedName);
        memberList.put(cleanedNewName, cleanedNewEmail);

        System.out.printf("""
                
                Member details updated successfully!
                Name: %s
                Email: %s
                """, cleanedNewName, cleanedNewEmail);
    }

    public HashMap<String, String> getMemberList() {
        return memberList;
    }

    public void searchbyName(String searchedName) {
        String cleanedName = members.cleanInput(searchedName);
        if (memberList.isEmpty()) System.out.println("\nList is empty!");
        System.out.println("\nName: " + searchedName + ", Email: " + memberList.getOrDefault(cleanedName, "\nNo member found!"));
    }

    public void delete(String searchedName) {
        String cleanName = members.cleanInput(searchedName);
        if (!memberList.containsKey(cleanName)) {
            System.out.println("\nNot found!");
            return;
        }
        memberList.remove(cleanName);
        System.out.println("\nSuccessfully deleted!");
    }
}
