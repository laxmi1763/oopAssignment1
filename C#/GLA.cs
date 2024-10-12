using System;
using System.Collections.Generic;

abstract class Entity
{
    public abstract override string ToString();
}

class Bill : Entity
{
    private string title;
    private string description;
    private bool isPassed;

    public Bill(string title, string description)
    {
        this.title = title;
        this.description = description;
        this.isPassed = false;
    }

    public void Pass()
    {
        this.isPassed = true;
    }

    public override string ToString()
    {
        return $"Title: {title}\nDescription: {description}\nStatus: {(isPassed ? "Passed" : "Not Passed")}";
    }
}

class MLA : Entity
{
    private string name;
    private string constituency;
    private string party;

    public MLA(string name, string constituency, string party)
    {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
    }

    public override string ToString()
    {
        return $"Name: {name}\nConstituency: {constituency}\nPolitical party: {party}";
    }
}

class Official : Entity
{
    private string position;
    private string name;

    public Official(string position, string name)
    {
        this.position = position;
        this.name = name;
    }

    public override string ToString()
    {
        return $"Position: {position}\nName: {name}";
    }
}

class Session : Entity
{
    private string date;
    private string agenda;

    public Session(string date, string agenda)
    {
        this.date = date;
        this.agenda = agenda;
    }

    public override string ToString()
    {
        return $"Date of the session: {date}\nAgenda: {agenda}";
    }
}

class GoaLegislativeAssembly
{
    private static List<Session> sessions = new List<Session>();
    private static List<Bill> bills = new List<Bill>();
    private static List<Official> officials = new List<Official>();
    private static List<MLA> mlas = new List<MLA>();
    private static Scanner scanner = new Scanner();

    public static void Main(string[] args)
    {
        int choice;
        do
        {
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
        } while (choice != 10);
    }

    private static void SessionDetails()
    {
        Console.Write("Enter the Date of the session: ");
        string date = Console.ReadLine();
        Console.Write("Enter the Agenda of the session: ");
        string agenda = Console.ReadLine();
        sessions.Add(new Session(date, agenda));
        Console.WriteLine("Session may proceed.");
    }

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

    private static void IntroduceBill()
    {
        Console.Write("Enter the title of the bill: ");
        string title = Console.ReadLine();
        Console.Write("Enter the description of the bill: ");
        string description = Console.ReadLine();
        bills.Add(new Bill(title, description));
        Console.WriteLine("Bill introduced successfully.");
    }

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
                bill.Pass();
                Console.WriteLine("Bill passed successfully.");
                return;
            }
        }
        Console.WriteLine("Bill not found.");
    }

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

    private static void AddOfficial()
    {
        Console.Write("Enter the position of the official: ");
        string position = Console.ReadLine();
        Console.Write("Enter the name of the official: ");
        string name = Console.ReadLine();
        officials.Add(new Official(position, name));
        Console.WriteLine("Official added successfully.");
    }

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

    private static void AddMLA()
    {
        Console.Write("Enter the name of the MLA: ");
        string name = Console.ReadLine();
        Console.Write("Enter the constituency of the MLA: ");
        string constituency = Console.ReadLine();
        Console.Write("Enter the Political party of the MLA: ");
        string party = Console.ReadLine();
        mlas.Add(new MLA(name, constituency, party));
        Console.WriteLine("MLA added successfully.");
    }

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

class Scanner
{
    public static string NextLine()
    {
        return Console.ReadLine();
    }
}