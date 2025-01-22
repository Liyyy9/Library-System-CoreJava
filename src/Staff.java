import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Staff extends Members {
    private String role;

    public Staff() {
        super();
    }

    public Staff(String name, String email, String role) {
        super(name, email);
        this.role = role;
    }

    public void add(String name, String email, String role) {
        if (memberList.containsKey(cleanInput(name))) {
            System.out.println("Staff member already exists!");
            return;
        }

        String cleanedName = cleanInput(name);
        String cleanedEmail = cleanInput(email);
        String cleanedRole = cleanInput(role);

        ArrayList<String> details = new ArrayList<>();
        details.add(cleanedEmail);
        details.add(cleanedRole);

        memberList.put(cleanedName, String.join(" | ", details));
        System.out.printf("New Staff successfully registered! Welcome %s!\n", name);
    }

    public void edit(String searchedName, Scanner scanner) {
        String cleanedSearchedName = cleanInput(searchedName);

        if (!memberList.containsKey(cleanedSearchedName)) {
            System.out.printf("\nNo staff with the name '%s' found!", cleanedSearchedName);
            return;
        }

        System.out.println("New Name: ");
        String cleanedNewName = cleanInput(scanner.nextLine());
        System.out.println("New Email: ");
        String cleanedNewEmail = cleanInput(scanner.nextLine());
        System.out.println("New Role: ");
        String cleanedNewRole = cleanInput(scanner.nextLine());

        ArrayList<String> details = new ArrayList<>();
        details.add(cleanedNewEmail);
        details.add(cleanedNewRole);

        memberList.remove(searchedName);
        memberList.put(cleanedNewName, String.join(" | ", details));
        System.out.printf("""
                
                Member details updated successfully!
                Name: %s
                Email: %s
                Role: %s
                """, cleanedNewName, cleanedNewEmail, cleanedNewRole);
    }

    public void searchByRole(String role) {
        boolean found = false;

        for (Map.Entry<String, String> entry : memberList.entrySet()) {
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
