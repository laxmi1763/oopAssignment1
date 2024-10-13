
/* Author Name: Laxmi Chari
Roll No: 22
Title: Program to implement OO Concepts using C#
Start Date: 22/07/2024,
Modified Date: 25/07/2024
Description: The program helps in understanding the structure of the Goa Legislative assembly using Object Oriented Concepts 
 */
using System;
using System.Collections.Generic;

// Abstract base class 'Entity' that defines the blueprint for other classes. 
// It requires every subclass to implement the ToString() method.
abstract class Entity
{
    public abstract override string ToString();
}

// The 'Bill' class represents a legislative bill.
class Bill : Entity
{
    private string title;  // Title of the bill
    private string description;  // Description of the bill
    private bool isPassed;  // Status of whether the bill is passed

    // Constructor to initialize a bill's title and description
    public Bill(string title, string description)
    {
        this.title = title;
        this.description = description;
        this.isPassed = false;  // Bill is not passed initially
    }

    // Method to mark the bill as passed
    public void Pass()
    {
        this.isPassed = true;
    }

    // Overriding the ToString() method to display the bill details
    public override string ToString()
    {
        return $"Title: {title}\nDescription: {description}\nStatus: {(isPassed ? "Passed" : "Not Passed")}";
    }
}

// The 'MLA' class represents a Member of the Legislative Assembly.
class MLA : Entity
{
    private string name;  // MLA's name
    private string constituency;  // MLA's constituency
    private string party;  // MLA's political party

    // Constructor to initialize MLA details
    public MLA(string name, string constituency, string party)
    {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    // Overriding the ToString() method to display MLA details
    public override string ToString()
    {
        return $"Name: {name}\nConstituency: {constituency}\nPolitical party: {party}";
    }
}

// The 'Official' class represents an official present in the assembly.
class Official : Entity
{
    private string position;  // Position of the official
    private string name;  // Name of the official

    // Constructor to initialize the official's details
    public Official(string position, string name)
    {
        this.position = position;
        this.name = name;
    }

    // Overriding the ToString() method to display official details
    public override string ToString()
    {
        return $"Position: {position}\nName: {name}";
    }
}

// The 'Session' class represents a legislative session.
class Session : Entity
{
    private string date;  // Date of the session
    private string agenda;  // Agenda of the session

    // Constructor to initialize session details
    public Session(string date, string agenda)
    {
        this.date = date;
        this.agenda = agenda;
    }

    // Overriding the ToString() method to display session details
    public override string ToString()
    {
        return $"Date of the session: {date}\nAgenda: {agenda}";
    }
}

// Main class representing the Goa Legislative Assembly with various operations
class GoaLegislativeAssembly
{
    // Static lists to store sessions, bills, officials, and MLAs
    private static List<Session> sessions = new List<Session>();
    private static List<Bill> bills = new List<Bill>();
    private static List<Official> officials = new List<Official>();
    private static List<MLA> mlas = new List<MLA>();
    private static Scanner scanner = new Scanner();

    // Main method, entry point for the application
    public static void Main(string[] args)
    {
        int choice;
        do
        {
            // Displaying the menu options for the user
            Console.WriteLine("\nGoa Legislative Assembly Menu");
            Console.WriteLine("1. Enter the Session Details");
            Console.WriteLine("2. Display Session Details");
            Console.WriteLine("3. Introduce a Bill");
            Console.WriteLine("4. Pass a Bill");
            Console.WriteLine("5. Display Bills");
            Console.WriteLine("6. Add an Official");
            Console.WriteLine("7. View Officials");
            Console.WriteLine("8. Add an MLA");
            Console.WriteLine("9. View MLAs");
            Console.WriteLine("10. Exit");
            Console.Write("Enter your choice: ");
            choice = int.Parse(Console.ReadLine());

            // Switch statement to handle user menu choices
            switch (choice)
            {
                case 1:
                    SessionDetails();
                    break;
                case 2:
                    DisplaySession();
                    break;
                case 3:
                    IntroduceBill();
                    break;
                case 4:
                    PassBill();
                    break;
                case 5:
                    DisplayBills();
                    break;
                case 6:
                    AddOfficial();
                    break;
                case 7:
                    ViewOfficials();
                    break;
                case 8:
                    AddMLA();
                    break;
                case 9:
                    ViewMLAs();
                    break;
                case 10:
                    Console.WriteLine("Exiting...");
                    break;
                default:
                    Console.WriteLine("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 10);  // Loop until the user chooses to exit
    }

    // Method to input session details and add them to the list
    private static void SessionDetails()
    {
        Console.Write("Enter the Date of the session: ");
        string date = Console.ReadLine();
        Console.Write("Enter the Agenda of the session: ");
        string agenda = Console.ReadLine();
        sessions.Add(new Session(date, agenda));  // Add session to the list
        Console.WriteLine("Session may proceed.");
    }

    // Method to display details of all sessions
    private static void DisplaySession()
    {
        if (sessions.Count == 0)
        {
            Console.WriteLine("No session conducted yet.");
            return;
        }

        foreach (var session in sessions)
        {
            Console.WriteLine(session);
            Console.WriteLine();
        }

        // Display bills introduced in the session
        if (bills.Count == 0)
        {
            Console.WriteLine("No bills introduced in the session.");
        }
        else
        {
            Console.WriteLine("Bills introduced in the session:");
            foreach (var bill in bills)
            {
                Console.WriteLine(bill);
                Console.WriteLine();
            }
        }

        // Display officials present in the session
        if (officials.Count == 0)
        {
            Console.WriteLine("No officials to display.");
        }
        else
        {
            Console.WriteLine("Officials present in today's Session:");
            foreach (var official in officials)
            {
                Console.WriteLine(official);
                Console.WriteLine();
            }
        }

        // Display MLAs present in the session
        if (mlas.Count == 0)
        {
            Console.WriteLine("No MLAs to display.");
        }
        else
        {
            Console.WriteLine("List of MLAs present for today's session:");
            foreach (var mla in mlas)
            {
                Console.WriteLine(mla);
                Console.WriteLine();
            }
        }
    }

    // Method to introduce a new bill
    private static void IntroduceBill()
    {
        Console.Write("Enter the title of the bill: ");
        string title = Console.ReadLine();
        Console.Write("Enter the description of the bill: ");
        string description = Console.ReadLine();
        bills.Add(new Bill(title, description));  // Add bill to the list
        Console.WriteLine("Bill introduced successfully.");
    }

    // Method to pass a bill by marking it as passed
    private static void PassBill()
    {
        if (bills.Count == 0)
        {
            Console.WriteLine("No bills available to pass.");
            return;
        }

        Console.Write("Enter the title of the bill to pass: ");
        string title = Console.ReadLine();
        foreach (var bill in bills)
        {
            if (bill.ToString().Contains(title))
            {
                bill.Pass();  // Mark the bill as passed
                Console.WriteLine("Bill passed successfully.");
                return;
            }
        }
        Console.WriteLine("Bill not found.");
    }

    // Method to display all bills
    private static void DisplayBills()
    {
        if (bills.Count == 0)
        {
            Console.WriteLine("No bills to display.");
            return;
        }

        foreach (var bill in bills)
        {
            Console.WriteLine(bill);
            Console.WriteLine();
        }
    }

    // Method to add a new official to the session
    private static void AddOfficial()
    {
        Console.Write("Enter the position of the official: ");
        string position = Console.ReadLine();
        Console.Write("Enter the name of the official: ");
        string name = Console.ReadLine();
        officials.Add(new Official(position, name));  // Add official to the list
        Console.WriteLine("Official added successfully.");
    }

    // Method to display all officials
    private static void ViewOfficials()
    {
        if (officials.Count == 0)
        {
            Console.WriteLine("No officials to display.");
            return;
        }

        Console.WriteLine("List of Officials:");
        foreach (var official in officials)
        {
            Console.WriteLine(official);
            Console.WriteLine();
        }
    }

    // Method to add a new MLA to the session
    private static void AddMLA()
    {
        Console.Write("Enter the name of the MLA: ");
        string name = Console.ReadLine();
        Console.Write("Enter the constituency of the MLA: ");
        string constituency = Console.ReadLine();
        Console.Write("Enter the Political party of the MLA: ");
        string party = Console.ReadLine();
        mlas.Add(new MLA(name, constituency, party));  // Add MLA to the list
        Console.WriteLine("MLA added successfully.");
    }

    // Method to display all MLAs
    private static void ViewMLAs()
    {
        if (mlas.Count == 0)
        {
            Console.WriteLine("No MLAs to display.");
            return;
        }

        Console.WriteLine("List of MLAs:");
        foreach (var mla in mlas)
        {
            Console.WriteLine(mla);
            Console.WriteLine();
        }
    }
}

// Custom scanner class for input (not really needed as Console.ReadLine() already exists)
class Scanner
{
    public static string NextLine()
    {
        return Console.ReadLine();
    }
}
