#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Entity {
public:
    virtual string toString() const = 0;
    virtual ~Entity() = default;
};

class Bill : public Entity {
private:
    string title;
    string description;
    bool isPassed;

public:
    Bill(const string &title, const string &description) : title(title), description(description), isPassed(false) {}

    void pass() {
        isPassed = true;
    }

    string toString() const override {
        return "Title: " + title + "\nDescription: " + description + "\nStatus: " + (isPassed ? "Passed" : "Not Passed");
    }
};

class MLA : public Entity {
private:
    string name;
    string constituency;
    string party;

public:
    MLA(const string &name, const string &constituency, const string &party) : name(name), constituency(constituency), party(party) {}

    string toString() const override {
        return "Name: " + name + "\nConstituency: " + constituency + "\nPolitical party: " + party;
    }
};

class Official : public Entity {
private:
    string position;
    string name;

public:
    Official(const string &position, const string &name) : position(position), name(name) {}

    string toString() const override {
        return "Position: " + position + "\nName: " + name;
    }
};

class Session : public Entity {
private:
    string date;
    string agenda;

public:
    Session(const string &date, const string &agenda) : date(date), agenda(agenda) {}

    string toString() const override {
        return "Date of the session: " + date + "\nAgenda: " + agenda;
    }
};

class GoaLegislativeAssembly {
private:
    vector<Session> sessions;
    vector<Bill> bills;
    vector<Official> officials;
    vector<MLA> mlas;

public:
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
        } while (choice != 10);
    }

    void sessionDetails() {
        string date, agenda;
        cout << "Enter the Date of the session: ";
        getline(cin, date);
        cout << "Enter the Agenda of the session: ";
        getline(cin, agenda);
        sessions.emplace_back(date, agenda);
        cout << "Session may proceed.\n";
    }

    void displaySession() {
        if (sessions.empty()) {
            cout << "No session conducted yet.\n";
            return;
        }

        for (const auto &session : sessions) {
            cout << session.toString() << "\n\n";
        }

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

    void introduceBill() {
        string title, description;
        cout << "Enter the title of the bill: ";
        getline(cin, title);
        cout << "Enter the description of the bill: ";
        getline(cin, description);
        bills.emplace_back(title, description);
        cout << "Bill introduced successfully.\n";
    }

    void passBill() {
        if (bills.empty()) {
            cout << "No bills available to pass.\n";
            return;
        }

        string title;
        cout << "Enter the title of the bill to pass: ";
        getline(cin, title);
        for (auto &bill : bills) {
            if (bill.toString().find(title) != string::npos) {
                bill.pass();
                cout << "Bill passed successfully.\n";
                return;
            }
        }
        cout << "Bill not found.\n";
    }

    void displayBills() {
        if (bills.empty()) {
            cout << "No bills to display.\n";
            return;
        }

        for (const auto &bill : bills) {
            cout << bill.toString() << "\n\n";
        }
    }

    void addOfficial() {
        string position, name;
        cout << "Enter the position of the official: ";
        getline(cin, position);
        cout << "Enter the name of the official: ";
        getline(cin, name);
        officials.emplace_back(position, name);
        cout << "Official added successfully.\n";
    }

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

    void addMLA() {
        string name, constituency, party;
        cout << "Enter the name of the MLA: ";
        getline(cin, name);
        cout << "Enter the constituency of the MLA: ";
        getline(cin, constituency);
        cout << "Enter the Political party of the MLA: ";
        getline(cin, party);
        mlas.emplace_back(name, constituency, party);
        cout << "MLA added successfully.\n";
    }

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
    GoaLegislativeAssembly assembly;
    assembly.menu();
    return 0;
}