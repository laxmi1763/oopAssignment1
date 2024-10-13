#Author Name: Laxmi Chari
#Roll No: 22
#Title: Program to implement OO Concepts using Python
#Start Date: 22/07/2024,
#Modified Date: 25/07/2024
#Description: The program helps in understanding the structure of the Goa Legislative Assembly using Object Oriented Concepts 

# Abstract base class representing a generic entity in the legislative assembly
class Entity:
    def __str__(self):
        pass  # Abstract method to be implemented by subclasses for string representation


# Class representing a legislative bill
class Bill(Entity):
    def __init__(self, title, description):
        self.title = title  # Title of the bill
        self.description = description  # Description of the bill
        self.is_passed = False  # Indicates whether the bill has been passed

    # Method to mark the bill as passed
    def pass_bill(self):
        self.is_passed = True  # Set the is_passed attribute to True

    # Override the __str__ method to provide a string representation of the bill
    def __str__(self):
        return f"Title: {self.title}\nDescription: {self.description}\nStatus: {'Passed' if self.is_passed else 'Not Passed'}"


# Class representing a Member of Legislative Assembly (MLA)
class MLA(Entity):
    def __init__(self, name, constituency, party):
        self.name = name  # Name of the MLA
        self.constituency = constituency  # Constituency of the MLA
        self.party = party  # Political party of the MLA

    # Override the __str__ method to provide a string representation of the MLA
    def __str__(self):
        return f"Name: {self.name}\nConstituency: {self.constituency}\nPolitical party: {self.party}"


# Class representing an official in the assembly (e.g., Speaker, Deputy Speaker, Governor)
class Official(Entity):
    def __init__(self, position, name):
        self.position = position  # Position of the official (e.g., Speaker)
        self.name = name  # Name of the official

    # Override the __str__ method to provide a string representation of the official
    def __str__(self):
        return f"Position: {self.position}\nName: {self.name}"


# Class representing a session of the legislative assembly
class Session(Entity):
    def __init__(self, date, agenda):
        self.date = date  # Date of the session
        self.agenda = agenda  # Agenda of the session

    # Override the __str__ method to provide a string representation of the session
    def __str__(self):
        return f"Date of the session: {self.date}\nAgenda: {self.agenda}"


# Class to manage the Goa Legislative Assembly
class GoaLegislativeAssembly:
    def __init__(self):
        # Lists to store sessions, bills, officials, and MLAs
        self.sessions = []
        self.bills = []
        self.officials = []
        self.mlas = []

    # Method to display the menu and handle user input
    def menu(self):
        while True:
            # Display menu options
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
            choice = int(input("Enter your choice: "))  # Read user choice

            # Handle user choice using if-elif statements
            if choice == 1:
                self.session_details()  # Call method to enter session details
            elif choice == 2:
                self.display_session()  # Call method to display session details
            elif choice == 3:
                self.introduce_bill()  # Call method to introduce a new bill
            elif choice == 4:
                self.pass_bill()  # Call method to pass a bill
            elif choice == 5:
                self.display_bills()  # Call method to display all bills
            elif choice == 6:
                self.add_official()  # Call method to add an official
            elif choice == 7:
                self.view_officials()  # Call method to view all officials
            elif choice == 8:
                self.add_mla()  # Call method to add a new MLA
            elif choice == 9:
                self.view_mlas()  # Call method to view all MLAs
            elif choice == 10:
                print("Exiting...")  # Exit message
                break  # Exit the loop
            else:
                print("Invalid choice. Please try again.")  # Handle invalid choices

    # Method to enter session details
    def session_details(self):
        date = input("Enter the Date of the session: ")  # Read session date
        agenda = input("Enter the Agenda of the session: ")  # Read session agenda
        self.sessions.append(Session(date, agenda))  # Add the new session to the list
        print("Session may proceed.")  # Confirmation message

    # Method to display details of all sessions
    def display_session(self):
        if not self.sessions:  # Check if there are no sessions
            print("No session conducted yet.")  # Handle case where no sessions exist
            return

        # Loop through and display all sessions
        for session in self.sessions:
            print(session)  # Print session details
            print()
        
        if not self.bills:  # Check if there are no bills
            print("No bills introduced in the session.")  # Handle case where no bills exist
        else:
            print("Bills introduced in the session:")
            for bill in self.bills:  # Loop through bills to display them
                print(bill)  # Print bill details
                print()
        
        if not self.officials:  # Check if there are no officials
            print("No officials to display.")  # Handle case where no officials exist
        else:
            print("Officials present in today's Session:")
            for official in self.officials:  # Loop through officials to display them
                print(official)  # Print official details
                print()
        
        if not self.mlas:  # Check if there are no MLAs
            print("No MLAs to display.")  # Handle case where no MLAs exist
        else:
            print("List of MLAs present for today's session:")
            for mla in self.mlas:  # Loop through MLAs to display them
                print(mla)  # Print MLA details
                print()

    # Method to introduce a new bill
    def introduce_bill(self):
        title = input("Enter the title of the bill: ")  # Read bill title
        description = input("Enter the description of the bill: ")  # Read bill description
        self.bills.append(Bill(title, description))  # Add the new bill to the list
        print("Bill introduced successfully.")  # Confirmation message

    # Method to pass a bill
    def pass_bill(self):
        if not self.bills:  # Check if there are no bills
            print("No bills available to pass.")  # Handle case where no bills exist
            return
        
        title = input("Enter the title of the bill to pass: ")  # Read the title of the bill to pass
        # Loop through bills to find the one matching the title
        for bill in self.bills:
            if bill.title == title:  # Check if bill title matches
                bill.pass_bill()  # Mark the bill as passed
                print("Bill passed successfully.")  # Confirmation message
                return
        print("Bill not found.")  # Handle case where the bill is not found

    # Method to display all bills
    def display_bills(self):
        if not self.bills:  # Check if there are no bills
            print("No bills to display.")  # Handle case where no bills exist
            return
        
        # Loop through and display all bills
        for bill in self.bills:
            print(bill)  # Print bill details
            print()

    # Method to add a new official
    def add_official(self):
        position = input("Enter the position of the official: ")  # Read official's position
        name = input("Enter the name of the official: ")  # Read official's name
        self.officials.append(Official(position, name))  # Add the new official to the list
        print("Official added successfully.")  # Confirmation message

    # Method to view all officials
    def view_officials(self):
        if not self.officials:  # Check if there are no officials
            print("No officials to display.")  # Handle case where no officials exist
            return
        
        print("List of Officials:")  # Display header
        # Loop through and display all officials
        for official in self.officials:
            print(official)  # Print official details
            print()

    # Method to add a new MLA
    def add_mla(self):
        name = input("Enter the name of the MLA: ")  # Read MLA name
        constituency = input("Enter the constituency of the MLA: ")  # Read MLA constituency
        party = input("Enter the Political party of the MLA: ")  # Read MLA party
        self.mlas.append(MLA(name, constituency, party))  # Add the new MLA to the list
        print("MLA added successfully.")  # Confirmation message

    # Method to view all MLAs
    def view_mlas(self):
        if not self.mlas:  # Check if there are no MLAs
            print("No MLAs to display.")  # Handle case where no MLAs exist
            return
        
        print("List of MLAs:")  # Display header
        # Loop through and display all MLAs
        for mla in self.mlas:
            print(mla)  # Print MLA details
            print()


# Main block to run the application
if __name__ == "__main__":
    assembly = GoaLegislativeAssembly()  # Create an instance of the GoaLegislativeAssembly class
    assembly.menu()  # Start the menu
