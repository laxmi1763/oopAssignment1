/* Author Name: Laxmi Chari
Roll No: 22
Title: Program to implement OO Concepts using JAVA
Start Date: 21/07/2024
Modified Date: 25/07/2024
Description: The program helps in understanding the structure of the Goa Legislative assembly using Object Oriented Concepts 
 */
// Abstract base class representing a generic entity in the legislative assembly
public abstract class Entity {
    // Abstract method that must be implemented by subclasses for string representation
    @Override
    public abstract String toString();
}

// Class representing a legislative bill
public class Bill extends Entity {
    private String title;        // Title of the bill
    private String description;  // Description of the bill
    private boolean isPassed;    // Indicates whether the bill has been passed

    // Constructor to initialize a new bill with a title and description
    public Bill(String title, String description) {
        this.title = title;
        this.description = description;
        this.isPassed = false;  // Bill is not passed initially
    }

    // Method to mark the bill as passed
    public void pass() {
        this.isPassed = true;
    }

    // Override the toString method to provide a string representation of the bill
    @Override
    public String toString() {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isPassed ? "Passed" : "Not Passed");
    }
}

// Class representing a Member of Legislative Assembly (MLA)
public class MLA extends Entity {
    private String name;          // Name of the MLA
    private String constituency;  // Constituency of the MLA
    private String party;         // Political party of the MLA

    // Constructor to initialize an MLA with name, constituency, and party
    public MLA(String name, String constituency, String party) {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    // Override the toString method to provide a string representation of the MLA
    @Override
    public String toString() {
        return "Name: " + name + "\nConstituency: " + constituency + "\nPolitical party: " + party;
    }
}

// Class representing an official in the assembly (e.g., Speaker, Deputy Speaker, Governor)
public class Official extends Entity {
    private String position;  // Position of the official (e.g., Speaker)
    private String name;      // Name of the official

    // Constructor to initialize the official's position and name
    public Official(String position, String name) {
        this.position = position;
        this.name = name;
    }

    // Override the toString method to provide a string representation of the official
    @Override
    public String toString() {
        return "Position: " + position + "\nName: " + name;
    }
}

// Class representing a session of the legislative assembly
public class Session extends Entity {
    private String date;    // Date of the session
    private String agenda;  // Agenda of the session

    // Constructor to initialize a session with date and agenda
    public Session(String date, String agenda) {
        this.date = date;
        this.agenda = agenda;
    }

    // Override the toString method to provide a string representation of the session
    @Override
    public String toString() {
        return "Date of the session: " + date + "\nAgenda: " + agenda;
    }
}

// Main class to manage the Goa Legislative Assembly
import java.util.ArrayList; // Importing the ArrayList class to manage collections
import java.util.Scanner;   // Importing the Scanner class for user input

public class GoaLegislativeAssembly {
    // Lists to store sessions, bills, officials, and MLAs
    private static ArrayList<Session> sessions = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    private static ArrayList<Official> officials = new ArrayList<>();
    private static ArrayList<MLA> mlas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in); // Scanner for reading user input

    public static void main(String[] args) {
        int choice; // Variable to store user menu choice
        do {
            // Display the menu options
            System.out.println("\nGoa Legislative Assembly Menu");
            System.out.println("1. Enter the Session Details");
            System.out.println("2. Display Session Details");
            System.out.println("3. Introduce a Bill");
            System.out.println("4. Pass a Bill");
            System.out.println("5. Display Bills");
            System.out.println("6. Add an Official");
            System.out.println("7. View Officials");
            System.out.println("8. Add an MLA");
            System.out.println("9. View MLAs");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt(); // Read user choice
            scanner.nextLine(); // Clear the buffer

            // Handle user choice using a switch statement
            switch (choice) {
                case 1:
                    sessionDetails();  // Call method to enter session details
                    break;
                case 2:
                    displaySession();  // Call method to display session details
                    break;
                case 3:
                    introduceBill();   // Call method to introduce a new bill
                    break;
                case 4:
                    passBill();       // Call method to pass a bill
                    break;
                case 5:
                    displayBills();    // Call method to display all bills
                    break;
                case 6:
                    addOfficial();     // Call method to add an official
                    break;
                case 7:
                    viewOfficials();    // Call method to view all officials
                    break;
                case 8:
                    addMLA();         // Call method to add a new MLA
                    break;
                case 9:
                    viewMLAs();       // Call method to view all MLAs
                    break;
                case 10:
                    System.out.println("Exiting..."); // Exit message
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Handle invalid choices
            }
        } while (choice != 10); // Continue until the user chooses to exit
    }

    // Method to enter session details
    private static void sessionDetails() {
        System.out.print("Enter the Date of the session: ");
        String date = scanner.nextLine(); // Read session date
        System.out.print("Enter the Agenda of the session: ");
        String agenda = scanner.nextLine(); // Read session agenda
        sessions.add(new Session(date, agenda)); // Add the new session to the list
        System.out.println("Session may proceed."); // Confirmation message
    }

    // Method to display details of all sessions
    private static void displaySession() {
        if (sessions.isEmpty()) {
            System.out.println("No session conducted yet."); // Handle case where no sessions exist
            return;
        }
        // Loop through and display all sessions
        for (Session session : sessions) {
            System.out.println(session); // Print session details
            System.out.println();
        }

        // Display bills introduced in the session
        System.out.println("Bills introduced in the session.");
        for (Bill bill : bills) {
            System.out.println(bill); // Print bill details
            System.out.println();
        }

        // Check if there are any officials to display
        if (officials.isEmpty()) {
            System.out.println("No officials to display."); // No officials found
            return;
        }
        // Display officials present in today's session
        System.out.println("Officials present in today's Session:");
        for (Official official : officials) {
            System.out.println(official); // Print official details
            System.out.println();
        }

        // Check if there are any MLAs to display
        if (mlas.isEmpty()) {
            System.out.println("No MLAs to display."); // No MLAs found
            return;
        }
        // Display MLAs present for today's session
        System.out.println("List of MLAs present for today's session:");
        for (MLA mla : mlas) {
            System.out.println(mla); // Print MLA details
            System.out.println();
        }
    }

    // Method to introduce a new bill
    private static void introduceBill() {
        System.out.print("Enter the title of the bill: ");
        String title = scanner.nextLine(); // Read bill title
        System.out.print("Enter the description of the bill: ");
        String description = scanner.nextLine(); // Read bill description
        bills.add(new Bill(title, description)); // Add the new bill to the list
        System.out.println("Bill introduced successfully."); // Confirmation message
    }

    // Method to pass a bill
    private static void passBill() {
        if (bills.isEmpty()) {
            System.out.println("No bills available to pass."); // Handle case where no bills exist
            return;
        }
        System.out.print("Enter the title of the bill to pass: ");
        String title = scanner.nextLine(); // Read the title of the bill to pass
        // Loop through bills to find the one matching the title
        for (Bill bill : bills) {
            if (bill.toString().contains(title)) { // Check if bill title matches
                bill.pass(); // Mark the bill as passed
                System.out.println("Bill passed successfully."); // Confirmation message
                return;
            }
        }
        System.out.println("Bill not found."); // Handle case where the bill is not found
    }

    // Method to display all bills
    private static void displayBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills to display."); // Handle case where no bills exist
            return;
        }
        // Loop through and display all bills
        for (Bill bill : bills) {
            System.out.println(bill); // Print bill details
            System.out.println();
        }
    }

    // Method to add a new official
    private static void addOfficial() { // speaker or deputy speaker or governor
        System.out.print("Enter the position of the official: ");
        String position = scanner.nextLine(); // Read official's position
        System.out.print("Enter the name of the official: ");
        String name = scanner.nextLine(); // Read official's name
        officials.add(new Official(position, name)); // Add the new official to the list
        System.out.println("Official added successfully."); // Confirmation message
    }

    // Method to view all officials
    private static void viewOfficials() {
        if (officials.isEmpty()) {
            System.out.println("No officials to display."); // Handle case where no officials exist
            return;
        }
        System.out.println("List of Officials:"); // Display header
        // Loop through and display all officials
        for (Official official : officials) {
            System.out.println(official); // Print official details
            System.out.println();
        }
    }

    // Method to add a new MLA
    private static void addMLA() {
        System.out.print("Enter the name of the MLA: ");
        String name = scanner.nextLine(); // Read MLA name
        System.out.print("Enter the constituency of the MLA: ");
        String constituency = scanner.nextLine(); // Read MLA constituency
        System.out.print("Enter the Political party of the MLA: ");
        String party = scanner.nextLine(); // Read MLA party
        mlas.add(new MLA(name, constituency, party)); // Add the new MLA to the list
        System.out.println("MLA added successfully."); // Confirmation message
    }

    // Method to view all MLAs
    private static void viewMLAs() {
        if (mlas.isEmpty()) {
            System.out.println("No MLAs to display."); // Handle case where no MLAs exist
            return;
        }
        System.out.println("List of MLAs:"); // Display header
        // Loop through and display all MLAs
        for (MLA mla : mlas) {
            System.out.println(mla); // Print MLA details
            System.out.println();
        }
    }
}






