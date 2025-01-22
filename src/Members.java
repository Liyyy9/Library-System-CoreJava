import java.util.HashMap;
import java.util.Scanner;

public class Members {
    private String name;
    private String email;
    protected HashMap<String, String> memberList;

    public Members() {
        this.memberList = new HashMap<>();
    }

    public Members(String name, String email) {
        this.name = name;
        this.email = email;
        this.memberList = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void add(String name, String email) {
        if (memberList.containsValue(email)) {
            System.out.println("\nMember already exists!");
            return;
        }
        String cleanedName = cleanInput(name);
        String cleanedEmail = cleanInput(email);
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
        String cleanedNewName = cleanInput(scanner.nextLine());
        System.out.println("New email: ");
        String cleanedNewEmail = cleanInput(scanner.nextLine());

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
        String cleanedName = cleanInput(searchedName);
        if (memberList.isEmpty()) System.out.println("\nList is empty!");
        System.out.println("\nName: " + searchedName + ", Email: " + memberList.getOrDefault(cleanedName, "\nNo member found!"));
    }

    public void delete(String searchedName) {
        String cleanName = cleanInput(searchedName);
        if (!memberList.containsKey(cleanName)) {
            System.out.println("\nNot found!");
            return;
        }
        memberList.remove(cleanName);
        System.out.println("\nSuccessfully deleted!");
    }

    public String cleanInput(String input) {
        return input.toLowerCase().trim();
    }

}
