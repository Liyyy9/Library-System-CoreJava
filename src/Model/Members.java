package Model;

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

    public String cleanInput(String input) {
        return input.toLowerCase().trim();
    }

}
