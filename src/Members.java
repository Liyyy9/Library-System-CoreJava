import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Members {
    private String name;
    private String email;
    private HashMap<String, String> memberList;

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
        if(memberList.containsValue(email)){
            System.out.println("Member already exists!");
            return;
        }
        String cleanedName = cleanInput(name);
        String cleanedEmail = cleanInput(email);
        memberList.put(cleanedName, cleanedEmail);
        System.out.println(memberList);
        System.out.printf("New member successfully registered! Welcome %s!\n", name);
    }

    public void edit(String searchedName, Scanner scanner) {
        String cleanedSearchedName = searchedName.toLowerCase().trim();
        if (!memberList.containsKey(cleanedSearchedName)) {
            System.out.printf("No member with the name '%s' found!\n", searchedName);
            return;
        }

        System.out.println("New name: ");
        String newName = scanner.nextLine();
        System.out.println("New email: ");
        String newEmail = scanner.nextLine();
        setEmail(newEmail);

        memberList.remove(cleanedSearchedName);
        memberList.put(newName, newEmail);

        System.out.printf("Member details updated: \nName: %s\nEmail: %s", newName, newEmail);
        System.out.println(memberList);
    }

    public HashMap<String, String> getMemberList(){
        return memberList;
    }

    public void searchbyName(String searchedName){
        String cleanedName = cleanInput(searchedName);
        if (memberList.isEmpty()) System.out.println("List is empty!");
        System.out.println("Email: " + memberList.getOrDefault(cleanedName, "No member found!"));
    }

    public void searchbyEmail(String searchedEmail){
        String cleanedEmail = cleanInput(searchedEmail);
        if (memberList.isEmpty()) System.out.println("List is empty!");

        for(Map.Entry<String, String> entry : memberList.entrySet()) {
            if(entry.getValue().equals(cleanedEmail)){
                System.out.println("Name: " + entry.getKey());
                return;
            }
        }
    }

    public void delete(String searchedName){
        String cleanName = cleanInput(searchedName);
        if(!memberList.containsKey(cleanName)){
            System.out.println("No member found!");
            return;
        }
        memberList.remove(cleanName);
        System.out.println("Member removed successfully!");
    }

    public String cleanInput(String input){
        return input.toLowerCase().trim();
    }

}
