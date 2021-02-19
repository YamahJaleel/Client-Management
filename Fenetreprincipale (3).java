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

public class Fenetreprincipale extends JFrame {

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel contentPane;

	private JTextField txtfNom;
	private JTextField txtfPrenom;
	private JTextField txtfTelephone;
	private JTextField txtfEmail;

	private JLabel lblNom = new JLabel("Nom :");
	private JLabel lblPrenom = new JLabel("Prenom :");
	private JLabel lblEmail = new JLabel("Email :");
	private JLabel lblTelephone = new JLabel("Telephone :");

	private JRadioButton rdbtnNouvC = new JRadioButton("Nouveau client");
	private JRadioButton rdbtnAffiC = new JRadioButton("Afficher les clients");
	private JRadioButton rdbtnTrouC = new JRadioButton("Trouver un client");

	private JButton btnValider = new JButton("Valider");
	private JButton btnEnregistrer = new JButton("Enregistrer");
	private JButton btnQuitter = new JButton("Quitter");
	private JButton btnChercher = new JButton("Chercher");

	String[] Options = { "", "Nom", "Prenom", "Telephone", "Email" };
	JComboBox Boxtrouver = new JComboBox(Options);

	ArrayList<Client> Liste = new ArrayList<Client>();
	String s = "";
	String s1 = "";

	public Fenetreprincipale() {
		setTitle("Fenetreprincipale");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblOption = new JLabel("Veuillez choisir une des options");
		lblOption.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOption.setBounds(165, 11, 253, 25);
		contentPane.add(lblOption);

		buttonGroup.add(rdbtnNouvC);
		rdbtnNouvC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNouvC.setBounds(49, 76, 115, 23);
		contentPane.add(rdbtnNouvC);

		buttonGroup.add(rdbtnAffiC);
		rdbtnAffiC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAffiC.setBounds(213, 76, 131, 23);
		contentPane.add(rdbtnAffiC);

		buttonGroup.add(rdbtnTrouC);
		rdbtnTrouC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnTrouC.setBounds(393, 76, 142, 23);
		contentPane.add(rdbtnTrouC);

		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnValider.setBounds(213, 153, 131, 23);
		contentPane.add(btnValider);

		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNom.setBounds(49, 217, 46, 23);
		contentPane.add(lblNom);

		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrenom.setBounds(49, 291, 63, 23);
		contentPane.add(lblPrenom);

		lblTelephone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephone.setBounds(49, 378, 86, 23);
		contentPane.add(lblTelephone);

		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(49, 457, 46, 23);
		contentPane.add(lblEmail);

		txtfNom = new JTextField();
		txtfNom.setEditable(false);
		txtfNom.setBounds(213, 220, 131, 20);
		contentPane.add(txtfNom);
		txtfNom.setColumns(10);

		txtfPrenom = new JTextField();
		txtfPrenom.setEditable(false);
		txtfPrenom.setColumns(10);
		txtfPrenom.setBounds(213, 294, 131, 20);
		contentPane.add(txtfPrenom);

		txtfTelephone = new JTextField();
		txtfTelephone.setEditable(false);
		txtfTelephone.setColumns(10);
		txtfTelephone.setBounds(213, 381, 131, 20);
		contentPane.add(txtfTelephone);

		txtfEmail = new JTextField();
		txtfEmail.setEditable(false);
		txtfEmail.setColumns(10);
		txtfEmail.setBounds(213, 460, 131, 20);
		contentPane.add(txtfEmail);

		btnEnregistrer.setEnabled(false);
		btnEnregistrer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEnregistrer.setBounds(420, 186, 115, 34);
		contentPane.add(btnEnregistrer);

		btnQuitter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnQuitter.setBounds(213, 542, 131, 25);
		contentPane.add(btnQuitter);

		Boxtrouver.setEnabled(false);
		Boxtrouver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Boxtrouver.setBounds(420, 251, 115, 20);
		contentPane.add(Boxtrouver);
		btnChercher.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnChercher.setEnabled(false);
		btnChercher.setBounds(420, 293, 115, 34);
		contentPane.add(btnChercher);

		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnNouvC.isSelected()) {

					txtfNom.setEditable(true);
					txtfPrenom.setEditable(true);
					txtfTelephone.setEditable(true);
					txtfEmail.setEditable(true);
					btnEnregistrer.setEnabled(true);
					Boxtrouver.setEnabled(false);
					Boxtrouver.setSelectedItem("");
					btnChercher.setEnabled(false);

				}

				if (rdbtnAffiC.isSelected()) {
					s = "";

					txtfNom.setText("");
					txtfPrenom.setText("");
					txtfTelephone.setText("");
					txtfEmail.setText("");

					txtfNom.setEditable(false);
					txtfPrenom.setEditable(false);
					txtfTelephone.setEditable(false);
					txtfEmail.setEditable(false);
					btnEnregistrer.setEnabled(false);
					Boxtrouver.setEnabled(false);
					Boxtrouver.setSelectedItem("");
					btnChercher.setEnabled(false);

					for (Object Client : Liste) {
						s += Client + "\n";
					}

					Affichageclient Affichage = new Affichageclient(s);
					Affichage.setResizable(true);
					Affichage.setLocationRelativeTo(null);
					Affichage.setVisible(true);

				}

				if (rdbtnTrouC.isSelected()) {

					txtfNom.setText("");
					txtfPrenom.setText("");
					txtfTelephone.setText("");
					txtfEmail.setText("");

					txtfNom.setEditable(false);
					txtfPrenom.setEditable(false);
					txtfTelephone.setEditable(false);
					txtfEmail.setEditable(false);
					btnEnregistrer.setEnabled(false);
					Boxtrouver.setEnabled(true);
					btnChercher.setEnabled(true);

				}

			}
		});

		btnEnregistrer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Liste.add(new Client(txtfNom.getText(), txtfPrenom.getText(), txtfTelephone.getText(),
						txtfEmail.getText()));

				txtfNom.setText("");
				txtfPrenom.setText("");
				txtfTelephone.setText("");
				txtfEmail.setText("");

			}
		});

		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				s1 = "";

				for (int i = 0; i < Liste.size(); i++) {

					Client x = Liste.get(i);

					if (txtfNom.isEditable() == true) {

						if (x.getNom().equals(txtfNom.getText())) {
							s1 = Liste.get(i).toString();
							txtfNom.setText("");
						}

					}

					if (txtfPrenom.isEditable() == true) {
						if (x.getPrenom().equals(txtfPrenom.getText())) {
							s1 = Liste.get(i).toString();
							txtfPrenom.setText("");
						}

					}

					if (txtfTelephone.isEditable() == true) {
						if (x.getTelephone().equals(txtfTelephone.getText())) {
							s1 = Liste.get(i).toString();
							txtfTelephone.setText("");
						}

					}

					if (txtfEmail.isEditable() == true) {
						if (x.getEmail().equals(txtfEmail.getText())) {
							s1 = Liste.get(i).toString();
							txtfEmail.setText("");
						}

					}

				}

				Affichageclient Affichage = new Affichageclient(s1);
				Affichage.setResizable(true);
				Affichage.setLocationRelativeTo(null);
				Affichage.setVisible(true);

			}
		});

		btnQuitter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

		Boxtrouver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == Boxtrouver) {
					JComboBox c = (JComboBox) e.getSource();
					String Option = (String) Boxtrouver.getSelectedItem();

					if (Option == "Nom") {

						txtfNom.setEditable(true);
						txtfPrenom.setEditable(false);
						txtfTelephone.setEditable(false);
						txtfEmail.setEditable(false);

						txtfPrenom.setText("");
						txtfTelephone.setText("");
						txtfEmail.setText("");
					}

					if (Option == "Prenom") {

						txtfNom.setEditable(false);
						txtfPrenom.setEditable(true);
						txtfTelephone.setEditable(false);
						txtfEmail.setEditable(false);

						txtfNom.setText("");
						txtfTelephone.setText("");
						txtfEmail.setText("");

					}

					if (Option == "Telephone") {

						txtfNom.setEditable(false);
						txtfPrenom.setEditable(false);
						txtfTelephone.setEditable(true);
						txtfEmail.setEditable(false);

						txtfNom.setText("");
						txtfPrenom.setText("");
						txtfEmail.setText("");

					}

					if (Option == "Email") {

						txtfNom.setEditable(false);
						txtfPrenom.setEditable(false);
						txtfTelephone.setEditable(false);
						txtfEmail.setEditable(true);

						txtfNom.setText("");
						txtfPrenom.setText("");
						txtfTelephone.setText("");

					}

				}

			}
		});

	}
}