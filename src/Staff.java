import java.util.HashMap;
import java.util.ArrayList;

public class Staff extends Members{
    private String role;
    private HashMap<String, ArrayList<String>> staffList;

    public Staff(){
        this.staffList = new HashMap<>();
    }

    public Staff(String name, String email, String role){
        super(name, email);
        this.role = role;
        this.staffList = new HashMap<>();
    }

    public void add(String name, String email, String role){
        if(staffList.containsKey(name)){
            System.out.println("Staff member already exists!");
            return;
        }

        String cleanedName = cleanInput(name);
        String cleanedEmail = cleanInput(email);
        String cleanedRole = cleanInput(role);

        ArrayList<String> details = new ArrayList<>();
        details.add(cleanedEmail);
        details.add(cleanedRole);

        staffList.put(cleanedName, details);

    }

}
