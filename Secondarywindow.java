import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Secondarywindow extends JFrame{

	private JPanel contentPane;

	public Secondarywindow(String s) {

		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane textClient = new JTextPane();
		textClient.setBounds(10, 11, 464, 279);
		contentPane.add(textClient);
		textClient.setText("Last name                  Name              Phone               Email" + "\n" + s);
		textClient.setEditable(false);

		JButton btnQuitter = new JButton("Fermer");
		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuitter.setBounds(177, 319, 107, 31);
		contentPane.add(btnQuitter);

		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();

			}
		});

	}

}