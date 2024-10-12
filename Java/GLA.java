public abstract class Entity {
  @Override
  public abstract String toString();
}


public class Bill extends Entity {
  private String title;
  private String description;
  private boolean isPassed;

  public Bill(String title, String description) {
      this.title = title;
      this.description = description;
      this.isPassed = false;
  }

  public void pass() {
      this.isPassed = true;
  }

  @Override
  public String toString() {
      return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isPassed ? "Passed" : "Not Passed");
  }

public class MLA extends Entity {
  private String name;
  private String constituency;
  private String party;

  public MLA(String name, String constituency, String party) {
      this.name = name;
      this.constituency = constituency;
      this.party=party;
  }

  @Override
  public String toString() {
      return "Name: " + name + "\nConstituency: " + constituency + "\nPolitical party: " + party;
  }
}


public class Official extends Entity {
  private String position;
  private String name;

  public Official(String position, String name) {
      this.position = position;
      this.name = name;
  }

  @Override
  public String toString() {
      return "Position: " + position + "\nName: " + name;
  }
}


public class Session extends Entity {
  private String date;
  private String agenda;

  public  Session(String date, String agenda){
      this.date=date;
      this.agenda=agenda;
  }

  @Override
  public String toString() {
    return "Date of the session: " + date + "\n Agenda:  " + agenda;
  }



}


import java.util.ArrayList;
import java.util.Scanner;

public class GoaLegislativeAssembly {
    private static ArrayList<Session> sessions = new ArrayList<>();
    private static ArrayList<Bill> bills = new ArrayList<>();
    private static ArrayList<Official> officials = new ArrayList<>();
    private static ArrayList<MLA> mlas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
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
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    sessionDetails();
                    break;
                case 2:
                    displaySession();
                    break;
                case 3:
                    introduceBill();
                    break;
                case 4:
                    passBill();
                    break;
                case 5:
                    displayBills();
                    break;
                case 6:
                    addOfficial();
                    break;
                case 7:
                    viewOfficials();
                    break;
                case 8:
                    addMLA();
                    break;
                case 9:
                    viewMLAs();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }

    private static void sessionDetails(){
        System.out.print("Enter the Date of the session: ");
        String date = scanner.nextLine();
        System.out.print("Enter the Agenda of the session: ");
        String agenda = scanner.nextLine();
        sessions.add(new Session(date,agenda));
        System.out.println("Session may proceed.");
    }

    private static void displaySession(){
        if (sessions.isEmpty()) {
            System.out.println("No session conducted yet.");
            return;
        }
        for (Session session  : sessions) {
            System.out.println(session);
            System.out.println();
        }
        System.out.println("Bills introduced in the session.");
        for (Bill bill : bills) {
            System.out.println(bill);
            System.out.println();
        }
        if (officials.isEmpty()) {
            System.out.println("No officials to display.");
            return;
        }
        System.out.println("Officials present in today's Session:");
        for (Official official : officials) {
            System.out.println(official);
            System.out.println();
        }
        if (mlas.isEmpty()) {
            System.out.println("No MLAs to display.");
            return;
        }
        System.out.println("List of MLAs present for today's session:");
        for (MLA mla : mlas) {
            System.out.println(mla);
            System.out.println();
        }

    }

    private static void introduceBill() {
        System.out.print("Enter the title of the bill: ");
        String title = scanner.nextLine();
        System.out.print("Enter the description of the bill: ");
        String description = scanner.nextLine();
        bills.add(new Bill(title, description));
        System.out.println("Bill introduced successfully.");
    }

    private static void passBill() {
        if (bills.isEmpty()) {
            System.out.println("No bills available to pass.");
            return;
        }
        System.out.print("Enter the title of the bill to pass: ");
        String title = scanner.nextLine();
        for (Bill bill : bills) {
            if (bill.toString().contains(title)) {
                bill.pass();
                System.out.println("Bill passed successfully.");
                return;
            }
        }
        System.out.println("Bill not found.");
    }

    private static void displayBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills to display.");
            return;
        }
        for (Bill bill : bills) {
            System.out.println(bill);
            System.out.println();
        }
    }

    private static void addOfficial() { //speaker or deputy speaker or governer
        System.out.print("Enter the position of the official: ");
        String position = scanner.nextLine();
        System.out.print("Enter the name of the official: ");
        String name = scanner.nextLine();
        officials.add(new Official(position, name));
        System.out.println("Official added successfully.");
    }

    private static void viewOfficials() {
        if (officials.isEmpty()) {
            System.out.println("No officials to display.");
            return;
        }
        System.out.println("List of Officials:");
        for (Official official : officials) {
            System.out.println(official);
            System.out.println();
        }
    }

    private static void addMLA() {
        System.out.print("Enter the name of the MLA: ");
        String name = scanner.nextLine();
        System.out.print("Enter the constituency of the MLA: ");
        String constituency = scanner.nextLine();
        System.out.print("Enter the Political party of the MLA: ");
        String party = scanner.nextLine();
        mlas.add(new MLA(name, constituency, party));
        System.out.println("MLA added successfully.");
    }

    private static void viewMLAs() {
        if (mlas.isEmpty()) {
            System.out.println("No MLAs to display.");
            return;
        }
        System.out.println("List of MLAs:");
        for (MLA mla : mlas) {
            System.out.println(mla);
            System.out.println();
        }
    }
}






