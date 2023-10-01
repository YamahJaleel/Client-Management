import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class Mainwindow extends JFrame {

    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JPanel contentPane;

    private JTextField txtfieldLastName;                                                    // Textfields for each Client Attributes
    private JTextField txtfieldFirstName;
    private JTextField txtfieldTelephone;
    private JTextField txtfieldEmail;

    private JLabel labelLastName = new JLabel("Last Name");                            // Labels to match the Textfields
    private JLabel labelFirstName = new JLabel("First Name ");
    private JLabel labelEmail = new JLabel("Email ");
    private JLabel labelTelephone = new JLabel("Phone");

    private JRadioButton newClientButton = new JRadioButton("Add new Client");         // Radio Buttons to choose wether to (Add/Show/Find) a Client
    private JRadioButton showClientButton = new JRadioButton("Show all Clients");
    private JRadioButton findClientButton = new JRadioButton("Find a Client");

    private JButton validateButton = new JButton("Validate");                          // Buttons to operate the GUI to do things like Validate a chosen option,                                                                                     
    private JButton saveNewClientButton = new JButton("Save");                         // Save client information, Find a client and Quit the program
    private JButton quitButton = new JButton("Quit");
    private JButton findButton = new JButton("Find");

    String[] options = { "", "Last Name", "First Name", "Phone", "Email" };                 // Array of options to pass to the Combo box
    JComboBox findBox = new JComboBox(options);                                             // Combo Box to give user the option of which Client attribute to search for

    ArrayList<Client> clientList = new ArrayList<Client>();                                 // ArrayList to hold all Clients Information
    String aggregatedClient = "";                                                           // String that aggregates clients info to diplay on secondary window
    String temporaryClient = "";                                                            // String to hold temporary client information

    public Mainwindow() {
        setTitle("ClientWhiz");                                                       // Set the title of main Mainwindow
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                     // Formatting the Mainwindow (ends at line 150)
        setBounds(100, 100, 600, 625);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblOption = new JLabel("Select Option");
        lblOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblOption.setBounds(220, 11, 255, 25);
        contentPane.add(lblOption);

        buttonGroup.add(newClientButton);
        newClientButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        newClientButton.setBounds(49, 76, 125, 23);
        contentPane.add(newClientButton);

        buttonGroup.add(showClientButton);
        showClientButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        showClientButton.setBounds(213, 76, 131, 23);
        contentPane.add(showClientButton);

        buttonGroup.add(findClientButton);
        findClientButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        findClientButton.setBounds(393, 76, 142, 23);
        contentPane.add(findClientButton);

        validateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        validateButton.setBounds(213, 153, 131, 23);
        contentPane.add(validateButton);

        labelLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelLastName.setBounds(49, 217, 70, 23);
        contentPane.add(labelLastName);

        labelFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelFirstName.setBounds(49, 291, 70, 23);
        contentPane.add(labelFirstName);

        labelTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelTelephone.setBounds(49, 378, 86, 23);
        contentPane.add(labelTelephone);

        labelEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        labelEmail.setBounds(49, 457, 46, 23);
        contentPane.add(labelEmail);

        txtfieldLastName = new JTextField();
        txtfieldLastName.setEditable(false);
        txtfieldLastName.setBounds(213, 220, 131, 20);
        contentPane.add(txtfieldLastName);
        txtfieldLastName.setColumns(10);

        txtfieldFirstName = new JTextField();
        txtfieldFirstName.setEditable(false);
        txtfieldFirstName.setColumns(10);
        txtfieldFirstName.setBounds(213, 294, 131, 20);
        contentPane.add(txtfieldFirstName);

        txtfieldTelephone = new JTextField();
        txtfieldTelephone.setEditable(false);
        txtfieldTelephone.setColumns(10);
        txtfieldTelephone.setBounds(213, 381, 131, 20);
        contentPane.add(txtfieldTelephone);

        txtfieldEmail = new JTextField();
        txtfieldEmail.setEditable(false);
        txtfieldEmail.setColumns(10);
        txtfieldEmail.setBounds(213, 460, 131, 20);
        contentPane.add(txtfieldEmail);

        saveNewClientButton.setEnabled(false);
        saveNewClientButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        saveNewClientButton.setBounds(420, 186, 115, 34);
        contentPane.add(saveNewClientButton);

        quitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        quitButton.setBounds(213, 542, 131, 25);
        contentPane.add(quitButton);

        findBox.setEnabled(false);
        findBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        findBox.setBounds(420, 251, 115, 20);
        contentPane.add(findBox);
        findButton.setFont(new Font("Tahoma", Font.PLAIN, 14));

        findButton.setEnabled(false);
        findButton.setBounds(420, 293, 115, 34);
        contentPane.add(findButton);

       
        validateButton.addActionListener(new ActionListener() {          // Registering an ActionListener for the validateButton
            public void actionPerformed(ActionEvent e) {                 // Check if the newClientButton is selected
              
                if (newClientButton.isSelected()) {                      //Enable editing of text fields and buttons for adding a new client
                    txtfieldLastName.setEditable(true);
                    txtfieldFirstName.setEditable(true);
                    txtfieldTelephone.setEditable(true);
                    txtfieldEmail.setEditable(true);
                    saveNewClientButton.setEnabled(true); 

                    findBox.setEnabled(false);                        // Disable and reset fields and buttons for other modes
                    findBox.setSelectedItem("");
                    findButton.setEnabled(false);
                }

                if (showClientButton.isSelected()) {                    // Check if the showClientButton is selected
                    aggregatedClient = " ";                             // Initialize aggregatedClient to store client information

                    txtfieldLastName.setText("");                     // Reset and disable text fields and buttons
                    txtfieldFirstName.setText("");
                    txtfieldTelephone.setText("");
                    txtfieldEmail.setText("");
                    txtfieldLastName.setEditable(false);
                    txtfieldFirstName.setEditable(false);
                    txtfieldTelephone.setEditable(false);
                    txtfieldEmail.setEditable(false);
                    saveNewClientButton.setEnabled(false);

                    findBox.setEnabled(false);                       // Disable and reset fields and buttons for other modes
                    findBox.setSelectedItem("");
                    findButton.setEnabled(false);

                    for (Object Client : clientList) {                 // Iterate through clientList and aggregate client information
                        aggregatedClient += Client + "\n";
                    }

                    Secondarywindow clientDisplay = new Secondarywindow(aggregatedClient);       // Create a new secondary window to display aggregated client data
                    clientDisplay.setResizable(true);
                    clientDisplay.setLocationRelativeTo(null);
                    clientDisplay.setVisible(true);
                }

                if (findClientButton.isSelected()) {                     // Check if the findClientButton is selected
                    txtfieldLastName.setText("");                      // Check if the findClientButton is selected
                    txtfieldFirstName.setText("");
                    txtfieldTelephone.setText("");
                    txtfieldEmail.setText("");
                    txtfieldLastName.setEditable(false);
                    txtfieldFirstName.setEditable(false);
                    txtfieldTelephone.setEditable(false);
                    txtfieldEmail.setEditable(false);
                    saveNewClientButton.setEnabled(false);

                    findBox.setEnabled(true);                          // Enable findBox for search criteria and the findButton for executing the search                                
                    findButton.setEnabled(true);
                }
            }
        });

        saveNewClientButton.addActionListener(new ActionListener() {     // Registering an ActionListener for the saveNewClientButton

            public void actionPerformed(ActionEvent e) {

                clientList.add(new Client(txtfieldLastName.getText(), txtfieldFirstName.getText(),       // Create a new Client instance and add it to the clientList
                        txtfieldTelephone.getText(), txtfieldEmail.getText()));                             

                txtfieldLastName.setText("");                         // Clear the text fields after adding the new client
                txtfieldFirstName.setText("");
                txtfieldTelephone.setText("");
                txtfieldEmail.setText("");

            }
        });

        findButton.addActionListener(new ActionListener() {             // Registering an ActionListener for the findButton
            public void actionPerformed(ActionEvent e) {

                temporaryClient = "";                                  // Initialize temporaryClient to store found client information

                for (int i = 0; i < clientList.size(); i++) {          // Iterate through the clientList to search for a client based on criteria

                    Client X = clientList.get(i);                      // Retrieve the client at index 'i' from the 'clientList' and store it in the 'X' variable.

                    if (txtfieldLastName.isEditable() == true) {                      // Check if the last name text field is editable
                        if (X.getLastName().equals(txtfieldLastName.getText())) {     // Compare the last name of the current client (X) with the input value
                            temporaryClient = clientList.get(i).toString();           // Store the found client information and clear the last name text field
                            txtfieldLastName.setText("");
                        }

                    }

                    if (txtfieldFirstName.isEditable() == true) {                      // Check if the first name text field is editable
                        if (X.getFirstName().equals(txtfieldFirstName.getText())) {    // Compare the first name of the current client (X) with the input value
                            temporaryClient = clientList.get(i).toString();            // Store the found client information and clear the first name text field
                            txtfieldFirstName.setText("");
                        }

                    }

                    if (txtfieldTelephone.isEditable() == true) {                       // Check if the telephone text field is editable
                        if (X.getTelephone().equals(txtfieldTelephone.getText())) {     // Compare the telephone number of the current client (X) with the input value
                            temporaryClient = clientList.get(i).toString();             // Store the found client information and clear the telephone text field
                            txtfieldTelephone.setText("");
                        }

                    }

                    if (txtfieldEmail.isEditable() == true) {                           // Check if the email text field is editable
                        if (X.getEmail().equals(txtfieldEmail.getText())) {             // Compare the email of the current client (X) with the input value
                            temporaryClient = clientList.get(i).toString();             // Store the found client information and clear the email text field
                            txtfieldEmail.setText("");
                        }

                    }

                }

                Secondarywindow clientListDisplay = new Secondarywindow(temporaryClient);     // Create a new secondary window (clientListDisplay) to display the found client information
                clientListDisplay.setResizable(true);
                clientListDisplay.setLocationRelativeTo(null);
                clientListDisplay.setVisible(true);

            }
        });

        findBox.addActionListener(new ActionListener() {                            // Registering an ActionListener for the 'findBox' (a JComboBox).
            public void actionPerformed(ActionEvent e) {                             

                if (e.getSource() == findBox) {                                     // Check if the event source is the 'findBox' itself.
                    JComboBox optionsCombo = (JComboBox) e.getSource();             // Cast the event source to a JComboBox.
                    String Option = (String) findBox.getSelectedItem();             // Get the selected option from the 'findBox.'

                    if (Option == "Last Name") {                                    // Depending on the selected option, configure text field editability and clear other fields.

                        txtfieldLastName.setEditable(true);
                        txtfieldFirstName.setEditable(false);
                        txtfieldTelephone.setEditable(false);
                        txtfieldEmail.setEditable(false);

                        txtfieldFirstName.setText("");
                        txtfieldTelephone.setText("");
                        txtfieldEmail.setText("");
                    }

                    if (Option == "First Name") {

                        txtfieldLastName.setEditable(false);
                        txtfieldFirstName.setEditable(true);
                        txtfieldTelephone.setEditable(false);
                        txtfieldEmail.setEditable(false);

                        txtfieldLastName.setText("");
                        txtfieldTelephone.setText("");
                        txtfieldEmail.setText("");

                    }

                    if (Option == "Phone") {

                        txtfieldLastName.setEditable(false);
                        txtfieldFirstName.setEditable(false);
                        txtfieldTelephone.setEditable(true);
                        txtfieldEmail.setEditable(false);

                        txtfieldLastName.setText("");
                        txtfieldFirstName.setText("");
                        txtfieldEmail.setText("");

                    }

                    if (Option == "Email") {

                        txtfieldLastName.setEditable(false);
                        txtfieldFirstName.setEditable(false);
                        txtfieldTelephone.setEditable(false);
                        txtfieldEmail.setEditable(true);

                        txtfieldLastName.setText("");
                        txtfieldFirstName.setText("");
                        txtfieldTelephone.setText("");

                    }

                }

            }
        });

        quitButton.addActionListener(new ActionListener() {       // Register an ActionListener for the 'quitButton.'

            public void actionPerformed(ActionEvent e) {          // When the button is clicked, this action listener disposes of the current window, effectively closing it.

                dispose();
            }
        });

    }
}
