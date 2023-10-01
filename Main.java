import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        Mainwindow graphicalInterface = new Mainwindow();                       // Create a new instance of the 'Mainwindow' class, which represents the main graphical user interface.
        graphicalInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      // Set the default close operation for the main window to exit the application when closed.
        graphicalInterface.setResizable(true);                                  // Allow the main window to be resizable, so the user can adjust its size.
        graphicalInterface.setLocationRelativeTo(null);                         // Center the main window on the screen for better user visibility.
        graphicalInterface.setVisible(true);                                    // Make the main window visible to the user.

    }

}
