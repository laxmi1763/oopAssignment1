/* Author Name: Laxmi Chari
Roll No: 22
Title: Program to implement OO Concepts using C++
Start Date: 23/07/2024,
Modified Date: 25/07/2024
Description: The program helps in understanding the structure of the Goa Legislative assembly using Object Oriented Concepts 
 */
#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Abstract base class for all entities (Bills, MLAs, Officials, Sessions)
class Entity {
public:
    // Pure virtual function to be overridden by derived classes for string representation
    virtual string toString() const = 0;
    virtual ~Entity() = default;  // Virtual destructor for proper cleanup of derived classes
};

// Bill class, derived from Entity, represents a legislative bill
class Bill : public Entity {
private:
    string title;        // Title of the bill
    string description;  // Description of the bill
    bool isPassed;       // Status of the bill (passed or not)

public:
    // Constructor to initialize the title and description of the bill, sets isPassed to false
    Bill(const string &title, const string &description) : title(title), description(description), isPassed(false) {}

    // Method to pass the bill
    void pass() {
        isPassed = true;
    }

    // Override the toString method to provide a string representation of the bill
    string toString() const override {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isPassed ? "Passed" : "Not Passed");
    }
};

// MLA class, derived from Entity, represents a Member of Legislative Assembly
class MLA : public Entity {
private:
    string name;          // Name of the MLA
    string constituency;  // Constituency of the MLA
    string party;         // Political party of the MLA

public:
    // Constructor to initialize the name, constituency, and party of the MLA
    MLA(const string &name, const string &constituency, const string &party) : name(name), constituency(constituency), party(party) {}

    // Override the toString method to provide a string representation of the MLA
    string toString() const override {
        return "Name: " + name + "\nConstituency: " + constituency + "\nPolitical party: " + party;
    }
};

// Official class, derived from Entity, represents an official in the assembly
class Official : public Entity {
private:
    string position;  // Position of the official
    string name;      // Name of the official

public:
    // Constructor to initialize the position and name of the official
    Official(const string &position, const string &name) : position(position), name(name) {}

    // Override the toString method to provide a string representation of the official
    string toString() const override {
        return "Position: " + position + "\nName: " + name;
    }
};

// Session class, derived from Entity, represents a session of the legislative assembly
class Session : public Entity {
private:
    string date;    // Date of the session
    string agenda;  // Agenda of the session

public:
    // Constructor to initialize the date and agenda of the session
    Session(const string &date, const string &agenda) : date(date), agenda(agenda) {}

    // Override the toString method to provide a string representation of the session
    string toString() const override {
        return "Date of the session: " + date + "\nAgenda: " + agenda;
    }
};

// GoaLegislativeAssembly class handles the management of sessions, bills, officials, and MLAs
class GoaLegislativeAssembly {
private:
    vector<Session> sessions;   // List of sessions
    vector<Bill> bills;         // List of bills
    vector<Official> officials; // List of officials
    vector<MLA> mlas;           // List of MLAs

public:
    // Menu method to display options and interact with the user
    void menu() {
        int choice;
        do {
            cout << "\nGoa Legislative Assembly Menu\n";
            cout << "1. Enter the Session Details\n";
            cout << "2. Display Session Details\n";
            cout << "3. Introduce a Bill\n";
            cout << "4. Pass a Bill\n";
            cout << "5. Display Bills\n";
            cout << "6. Add an Official\n";
            cout << "7. View Officials\n";
            cout << "8. Add an MLA\n";
            cout << "9. View MLAs\n";
            cout << "10. Exit\n";
            cout << "Enter your choice: ";
            cin >> choice;
            cin.ignore(); // Ignore the newline character left in the buffer

            // Call the appropriate method based on user's choice
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
                    cout << "Exiting...\n";
                    break;
                default:
                    cout << "Invalid choice. Please try again.\n";
            }
        } while (choice != 10);  // Continue until the user chooses to exit
    }

    // Method to add session details
    void sessionDetails() {
        string date, agenda;
        cout << "Enter the Date of the session: ";
        getline(cin, date);
        cout << "Enter the Agenda of the session: ";
        getline(cin, agenda);
        sessions.emplace_back(date, agenda);  // Add the session to the list
        cout << "Session may proceed.\n";
    }

    // Method to display details of all sessions
    void displaySession() {
        if (sessions.empty()) {
            cout << "No session conducted yet.\n";
            return;
        }

        for (const auto &session : sessions) {
            cout << session.toString() << "\n\n";
        }

        // Display bills, officials, and MLAs for the session
        if (bills.empty()) {
            cout << "No bills introduced in the session.\n";
        } else {
            cout << "Bills introduced in the session:\n";
            for (const auto &bill : bills) {
                cout << bill.toString() << "\n\n";
            }
        }

        if (officials.empty()) {
            cout << "No officials to display.\n";
        } else {
            cout << "Officials present in today's Session:\n";
            for (const auto &official : officials) {
                cout << official.toString() << "\n\n";
            }
        }

        if (mlas.empty()) {
            cout << "No MLAs to display.\n";
        } else {
            cout << "List of MLAs present for today's session:\n";
            for (const auto &mla : mlas) {
                cout << mla.toString() << "\n\n";
            }
        }
    }

    // Method to introduce a new bill
    void introduceBill() {
        string title, description;
        cout << "Enter the title of the bill: ";
        getline(cin, title);
        cout << "Enter the description of the bill: ";
        getline(cin, description);
        bills.emplace_back(title, description);  // Add the bill to the list
        cout << "Bill introduced successfully.\n";
    }

    // Method to pass a bill
    void passBill() {
        if (bills.empty()) {
            cout << "No bills available to pass.\n";
            return;
        }

        string title;
        cout << "Enter the title of the bill to pass: ";
        getline(cin, title);
        // Search for the bill by title and mark it as passed
        for (auto &bill : bills) {
            if (bill.toString().find(title) != string::npos) {
                bill.pass();
                cout << "Bill passed successfully.\n";
                return;
            }
        }
        cout << "Bill not found.\n";
    }

    // Method to display all bills
    void displayBills() {
        if (bills.empty()) {
            cout << "No bills to display.\n";
            return;
        }

        for (const auto &bill : bills) {
            cout << bill.toString() << "\n\n";
        }
    }

    // Method to add an official
    void addOfficial() {
        string position, name;
        cout << "Enter the position of the official: ";
        getline(cin, position);
        cout << "Enter the name of the official: ";
        getline(cin, name);
        officials.emplace_back(position, name);  // Add the official to the list
        cout << "Official added successfully.\n";
    }

    // Method to view all officials
    void viewOfficials() {
        if (officials.empty()) {
            cout << "No officials to display.\n";
            return;
        }

        cout << "List of Officials:\n";
        for (const auto &official : officials) {
            cout << official.toString() << "\n\n";
        }
    }

    // Method to add an MLA
    void addMLA() {
        string name, constituency, party;
        cout << "Enter the name of the MLA: ";
        getline(cin, name);
        cout << "Enter the constituency of the MLA: ";
        getline(cin, constituency);
        cout << "Enter the Political party of the MLA: ";
        getline(cin, party);
        mlas.emplace_back(name, constituency, party);  // Add the MLA to the list
        cout << "MLA added successfully.\n";
    }

    // Method to view all MLAs
    void viewMLAs() {
        if (mlas.empty()) {
            cout << "No MLAs to display.\n";
            return;
        }

        cout << "List of MLAs:\n";
        for (const auto &mla : mlas) {
            cout << mla.toString() << "\n\n";
        }
    }
};

int main() {
    // Create an instance of the assembly and call the menu method to start the program
    GoaLegislativeAssembly assembly;
    assembly.menu();
    return 0;
}
