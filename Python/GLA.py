class Entity:
    def __str__(self):
        pass


class Bill(Entity):
    def __init__(self, title, description):
        self.title = title
        self.description = description
        self.is_passed = False

    def pass_bill(self):
        self.is_passed = True

    def __str__(self):
        return f"Title: {self.title}\nDescription: {self.description}\nStatus: {'Passed' if self.is_passed else 'Not Passed'}"


class MLA(Entity):
    def __init__(self, name, constituency, party):
        self.name = name
        self.constituency = constituency
        self.party = party

    def __str__(self):
        return f"Name: {self.name}\nConstituency: {self.constituency}\nPolitical party: {self.party}"


class Official(Entity):
    def __init__(self, position, name):
        self.position = position
        self.name = name

    def __str__(self):
        return f"Position: {self.position}\nName: {self.name}"


class Session(Entity):
    def __init__(self, date, agenda):
        self.date = date
        self.agenda = agenda

    def __str__(self):
        return f"Date of the session: {self.date}\nAgenda: {self.agenda}"


class GoaLegislativeAssembly:
    def __init__(self):
        self.sessions = []
        self.bills = []
        self.officials = []
        self.mlas = []

    def menu(self):
        while True:
            print("\nGoa Legislative Assembly Menu")
            print("1. Enter the Session Details")
            print("2. Display Session Details")
            print("3. Introduce a Bill")
            print("4. Pass a Bill")
            print("5. Display Bills")
            print("6. Add an Official")
            print("7. View Officials")
            print("8. Add an MLA")
            print("9. View MLAs")
            print("10. Exit")
            choice = int(input("Enter your choice: "))

            if choice == 1:
                self.session_details()
            elif choice == 2:
                self.display_session()
            elif choice == 3:
                self.introduce_bill()
            elif choice == 4:
                self.pass_bill()
            elif choice == 5:
                self.display_bills()
            elif choice == 6:
                self.add_official()
            elif choice == 7:
                self.view_officials()
            elif choice == 8:
                self.add_mla()
            elif choice == 9:
                self.view_mlas()
            elif choice == 10:
                print("Exiting...")
                break
            else:
                print("Invalid choice. Please try again.")

    def session_details(self):
        date = input("Enter the Date of the session: ")
        agenda = input("Enter the Agenda of the session: ")
        self.sessions.append(Session(date, agenda))
        print("Session may proceed.")

    def display_session(self):
        if not self.sessions:
            print("No session conducted yet.")
            return

        for session in self.sessions:
            print(session)
            print()
        
        if not self.bills:
            print("No bills introduced in the session.")
        else:
            print("Bills introduced in the session:")
            for bill in self.bills:
                print(bill)
                print()
        
        if not self.officials:
            print("No officials to display.")
        else:
            print("Officials present in today's Session:")
            for official in self.officials:
                print(official)
                print()
        
        if not self.mlas:
            print("No MLAs to display.")
        else:
            print("List of MLAs present for today's session:")
            for mla in self.mlas:
                print(mla)
                print()

    def introduce_bill(self):
        title = input("Enter the title of the bill: ")
        description = input("Enter the description of the bill: ")
        self.bills.append(Bill(title, description))
        print("Bill introduced successfully.")

    def pass_bill(self):
        if not self.bills:
            print("No bills available to pass.")
            return
        
        title = input("Enter the title of the bill to pass: ")
        for bill in self.bills:
            if bill.title == title:
                bill.pass_bill()
                print("Bill passed successfully.")
                return
        print("Bill not found.")

    def display_bills(self):
        if not self.bills:
            print("No bills to display.")
            return
        
        for bill in self.bills:
            print(bill)
            print()

    def add_official(self):
        position = input("Enter the position of the official: ")
        name = input("Enter the name of the official: ")
        self.officials.append(Official(position, name))
        print("Official added successfully.")

    def view_officials(self):
        if not self.officials:
            print("No officials to display.")
            return
        
        print("List of Officials:")
        for official in self.officials:
            print(official)
            print()

    def add_mla(self):
        name = input("Enter the name of the MLA: ")
        constituency = input("Enter the constituency of the MLA: ")
        party = input("Enter the Political party of the MLA: ")
        self.mlas.append(MLA(name, constituency, party))
        print("MLA added successfully.")

    def view_mlas(self):
        if not self.mlas:
            print("No MLAs to display.")
            return
        
        print("List of MLAs:")
        for mla in self.mlas:
            print(mla)
            print()


if __name__ == "__main__":
    assembly = GoaLegislativeAssembly()
    assembly.menu()
