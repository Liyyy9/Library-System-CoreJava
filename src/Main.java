public class Main {
    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface();
        MemberInterface memberInterface = new MemberInterface();
        StaffInterface staffInterface = new StaffInterface();

        // Set dependencies
        userInterface.setMemberInterface(memberInterface);
        userInterface.setStaffInterface(staffInterface);
        memberInterface.setUserInterface(userInterface);
        staffInterface.setUserInterface(userInterface);

        // Start the user interface
        userInterface.start();

    }
}