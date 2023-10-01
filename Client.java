public class Client {                         // Defining a class named 'Client' to represent client information.

    private String LastName;                  // Declaring private instance variables to store client information.
    private String FirstName;
    private String telephone;
    private String email;

    public Client(String LastName, String FirstName, String telephone, String email) {      // Constructor method for creating a new 'Client' instance.

        this.LastName = LastName;               // Initialize the client object with provided information.
        this.FirstName = FirstName;
        this.telephone = telephone;
        this.email = email;

    }

    public String getLastName() {             // Getter method to retrieve the last name of the client.
        return LastName;
    }

    public String getFirstName() {           // Getter method to retrieve the first name of the client.
        return FirstName;
    }

    public String getTelephone() {          // Getter method to retrieve the telephone number of the client.
        return telephone;
    }

    public String getEmail() {              // Getter method to retrieve the email address of the client.
        return email;
    }

    public void setLastName(String nom) {    // Setter method to update the last name of the client.
        this.LastName = nom;
    }

    public void setFirstName(String prenom) {     // Setter method to update the first name of the client.
        this.FirstName = prenom;
    }

    public void setTelephone(String telephone) {   // Setter method to update the telephone number of the client.
        this.telephone = telephone;
    }

    public void setEmail(String email) {          // Setter method to update the email address of the client.
        this.email = email;
    }

    @Override                                   // Override the 'toString' method to provide a formatted string representation of the client object.
    public String toString() {

        return String.format("%-20s %-20s %-20s %-20s", this.LastName, this.FirstName, this.telephone, this.email);   // Format client information with specified column widths.

    }
}
