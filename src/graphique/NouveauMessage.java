package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import connexion.AccesJDBC;
import operations.Operation;

public class NouveauMessage {

	public JFrame frame;
	public static int idExpediteur;
	public static int idDestinataire;
	private JTextField txtsujetfield;
	private JTextField txtdestinatairefield;
	private JTextField txtexpediteurfield;
	private JTextField txtdatefield;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauMessage window = new NouveauMessage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NouveauMessage() {
		initialize();
		// String dateEnvoi = Operation.dateFormat(new Date());
		txtdatefield.setText(Operation.dateFormat(new Date()));
		String sqlNomExpediteur = "select Nom from Personnes where id = " + idExpediteur;
		String sqlPrenomExpediteur = "select Prenom from Personnes where id = " + idExpediteur;
		txtexpediteurfield
				.setText(AccesJDBC.trouverNom(sqlNomExpediteur) + " " + AccesJDBC.trouverNom(sqlPrenomExpediteur));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Sujet");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(94, 59, 78, 30);
		frame.getContentPane().add(lblNewLabel_1);

		txtsujetfield = new JTextField();
		txtsujetfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsujetfield.setBounds(227, 61, 501, 30);
		frame.getContentPane().add(txtsujetfield);
		txtsujetfield.setColumns(10);

		JButton btnCancelMsg = new JButton("ANNULER");
		btnCancelMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelMsg.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelMsg.setBounds(634, 580, 144, 57);
		frame.getContentPane().add(btnCancelMsg);

		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(358, 244, 119, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(
				"Une remarque, une suggestion ? N'h\u00E9sitez pas \u00E0 nous \u00E9crire ! ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(130, 0, 632, 69);
		frame.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 280, 716, 265);
		frame.getContentPane().add(scrollPane);

		JTextArea textAreaMsg = new JTextArea();
		scrollPane.setViewportView(textAreaMsg);
		textAreaMsg.setLineWrap(true);
		textAreaMsg.setWrapStyleWord(true);
		textAreaMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("Destinataire");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(60, 141, 131, 30);
		frame.getContentPane().add(lblNewLabel_3);

		txtdestinatairefield = new JTextField();
		txtdestinatairefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtdestinatairefield.setBounds(227, 143, 501, 30);
		frame.getContentPane().add(txtdestinatairefield);
		txtdestinatairefield.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("Expediteur");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(60, 100, 131, 30);
		frame.getContentPane().add(lblNewLabel_3_1);

		JButton btnSendMsg = new JButton("ENVOYER");
		btnSendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// String sqlIdExpediteur =

				String sql = "insert into Message values ('" + txtsujetfield.getText() + "'," + idExpediteur + ","
						+ idDestinataire + ",'" + txtdatefield.getText().toString() + "','"
						+ textAreaMsg.getText().toString() + "',0)";
				System.out.println(sql);
				AccesJDBC.Edition(sql);

				JOptionPane.showMessageDialog(null, "Message Envoyé");

			}
		});

		btnSendMsg.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSendMsg.setBounds(60, 582, 144, 53);
		frame.getContentPane().add(btnSendMsg);

		txtexpediteurfield = new JTextField();
		txtexpediteurfield.setEditable(false);
		txtexpediteurfield.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtexpediteurfield.setColumns(10);
		txtexpediteurfield.setBounds(227, 102, 501, 30);
		frame.getContentPane().add(txtexpediteurfield);

		JLabel lblNewLabel_1_1 = new JLabel("Date d'envoi");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(60, 192, 131, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		txtdatefield = new JTextField();
		txtdatefield.setEditable(false);
		txtdatefield.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtdatefield.setColumns(10);
		txtdatefield.setBounds(227, 192, 501, 30);
		frame.getContentPane().add(txtdatefield);

		JButton buttonRecherche = new JButton("Recherche");
		buttonRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlListePersonnes = "select id from Personnes where Nom like '" + txtdestinatairefield.getText()
						+ "%'";
				JComboBox<String> combobox = new JComboBox<String>();
				AccesJDBC.listeChoix(sqlListePersonnes, combobox);
				String[] choixDestinataire = new String[combobox.getItemCount()];
				for (int i = 0; i < combobox.getItemCount(); i++) {
					String sqlNomPersonnes = "select Nom from Personnes where id = '" + combobox.getItemAt(i) + "'";
					String sqlPrenomPersonnes = "select Prenom from Personnes where id = '" + combobox.getItemAt(i)
							+ "'";
					choixDestinataire[i] = AccesJDBC.trouverNom(sqlNomPersonnes) + " "
							+ AccesJDBC.trouverNom(sqlPrenomPersonnes);
				}
				if (combobox.getItemCount() > 0) {
					String reponse = JOptionPane.showInputDialog(frame, "Choisissez un destinataire",
							"Choix destinataire", JOptionPane.QUESTION_MESSAGE, null, choixDestinataire, "Noms")
							.toString();
					if (reponse != null) {
						txtdestinatairefield.setText(reponse);
						String sqlIdDestinataire = "select id from Personnes where nom = '";
						String[] nomPrenom = reponse.split(" ");
						sqlIdDestinataire = sqlIdDestinataire + nomPrenom[0] + "' and Prenom = '" + nomPrenom[1] + "'";
						System.out.println(sqlIdDestinataire);
						idDestinataire = Integer.parseInt(AccesJDBC.trouverNom(sqlIdDestinataire));
					}
				}
			}
		});
		buttonRecherche.setBackground(Color.GREEN);
		buttonRecherche.setBounds(738, 141, 119, 30);
		frame.getContentPane().add(buttonRecherche);
	}
}
