package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import connexion.AccesJDBC;
import erreurs.GestionErreurs;
import operations.Operation;

public class Emprunt {

	public JFrame GESTON_EMPRUNTS;
	private JComboBox<String> comboBoxEmpruntsnonValidesAjourne;
	private JComboBox<String> comboBoxRetourEmprunt;
	private JTextField textFieldDateLimite;
	private JButton buttonAjourner;
	private JButton buttonValider1;
	private JButton buttonValider2;
	private JButton buttonRetard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprunt window = new Emprunt();
					window.GESTON_EMPRUNTS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Emprunt() {
		initialize();
		initChoixEmpruntsNonValidesAjourne();
		initChoixEmpruntsRetours();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GESTON_EMPRUNTS = new JFrame();
		GESTON_EMPRUNTS.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		GESTON_EMPRUNTS.setTitle("                                                           GESTON_EMPRUNTS");
		GESTON_EMPRUNTS.setBounds(100, 100, 768, 367);
		GESTON_EMPRUNTS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GESTON_EMPRUNTS.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Emprunt des documents");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(49, 11, 288, 43);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel);

		JLabel lblRetourDesDocuments = new JLabel("Retour des documents");
		lblRetourDesDocuments.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblRetourDesDocuments.setBounds(416, 11, 288, 43);
		GESTON_EMPRUNTS.getContentPane().add(lblRetourDesDocuments);

		JPanel panelValidation = new JPanel();
		panelValidation.setBackground(new Color(240, 230, 140));
		panelValidation.setBorder(
				new TitledBorder(null, "Validation d'un emprunt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelValidation.setBounds(31, 65, 336, 219);
		GESTON_EMPRUNTS.getContentPane().add(panelValidation);
		panelValidation.setLayout(null);

		buttonValider1 = new JButton("Valider");

		buttonValider1.setBounds(10, 188, 75, 21);
		panelValidation.add(buttonValider1);

		comboBoxEmpruntsnonValidesAjourne = new JComboBox<String>();

		comboBoxEmpruntsnonValidesAjourne.setBounds(172, 24, 111, 22);
		panelValidation.add(comboBoxEmpruntsnonValidesAjourne);

		JLabel labelAdherentEmprunt = new JLabel("Adh\u00E9rent:");
		labelAdherentEmprunt.setBounds(10, 65, 273, 14);
		panelValidation.add(labelAdherentEmprunt);

		JLabel labelDocemprunt = new JLabel("Emprunt \u00E0 valider ou ajourner: ");
		labelDocemprunt.setBounds(10, 28, 159, 14);
		panelValidation.add(labelDocemprunt);

		JLabel labelTitreDocEmprunt = new JLabel("Titre du document: ");
		labelTitreDocEmprunt.setBounds(10, 100, 273, 13);
		panelValidation.add(labelTitreDocEmprunt);

		JLabel labelDateLimite = new JLabel("Date limite d'emprunt:");
		labelDateLimite.setBounds(10, 127, 131, 13);
		panelValidation.add(labelDateLimite);

		textFieldDateLimite = new JTextField();
		textFieldDateLimite.setBounds(169, 123, 96, 19);
		panelValidation.add(textFieldDateLimite);
		textFieldDateLimite.setColumns(10);

		JLabel labelFormatDate = new JLabel("(format: dd/mm/aa)");
		labelFormatDate.setForeground(Color.RED);
		labelFormatDate.setBounds(10, 141, 117, 13);
		panelValidation.add(labelFormatDate);

		buttonAjourner = new JButton("Ajourner");

		buttonAjourner.setBounds(241, 188, 85, 21);
		panelValidation.add(buttonAjourner);

		JPanel panelRetour = new JPanel();
		panelRetour.setBorder(
				new TitledBorder(null, "Retour d'emprunt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRetour.setBackground(new Color(240, 230, 140));
		panelRetour.setBounds(416, 65, 308, 219);
		GESTON_EMPRUNTS.getContentPane().add(panelRetour);
		panelRetour.setLayout(null);

		comboBoxRetourEmprunt = new JComboBox<String>();
		comboBoxRetourEmprunt.setBounds(137, 22, 122, 21);
		panelRetour.add(comboBoxRetourEmprunt);

		JLabel labelAherent2 = new JLabel("Adh\u00E9rent : ");
		labelAherent2.setBounds(22, 62, 237, 14);
		panelRetour.add(labelAherent2);

		buttonValider2 = new JButton("Valider");

		buttonValider2.setBounds(10, 186, 89, 23);
		panelRetour.add(buttonValider2);

		JLabel labelEmpruntRetour = new JLabel("Retour d'emprunt");
		labelEmpruntRetour.setBounds(22, 25, 105, 14);
		panelRetour.add(labelEmpruntRetour);

		buttonRetard = new JButton("Alerter");
		buttonRetard.setBounds(213, 187, 85, 21);
		panelRetour.add(buttonRetard);

		JLabel labelTitreDocEmprunt2 = new JLabel("Titre du document : ");
		labelTitreDocEmprunt2.setBounds(22, 94, 237, 13);
		panelRetour.add(labelTitreDocEmprunt2);

		JLabel labelEtat = new JLabel("Etat de l'emprunt: ");
		labelEtat.setBounds(22, 132, 237, 13);
		panelRetour.add(labelEtat);

		JButton btnNewButton_2 = new JButton("Requetes");
		btnNewButton_2.setBounds(278, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Documents");
		btnNewButton_2_1.setBounds(426, 294, 112, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Abonn\u00E9s");
		btnNewButton_2_1_1.setBounds(635, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1_1);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GESTON_EMPRUNTS.dispose();
			}
		});
		buttonRetour.setBounds(31, 294, 85, 21);
		GESTON_EMPRUNTS.getContentPane().add(buttonRetour);

		comboBoxEmpruntsnonValidesAjourne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null) {
					String sqlidadherent = "select idPersonne from Emprunts where id = "
							+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
					String sqlnomadherent = "select Nom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlprenomadherent = "select Prenom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlidDoc = "select idDocument from Emprunts where id = "
							+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
					String sqlTitredoc = "select Titre from Documents where id = " + AccesJDBC.trouverNom(sqlidDoc);
					labelAdherentEmprunt.setText("Adhérent : " + AccesJDBC.trouverNom(sqlnomadherent) + " "
							+ AccesJDBC.trouverNom(sqlprenomadherent));
					labelTitreDocEmprunt.setText("Titre du document: " + AccesJDBC.trouverNom(sqlTitredoc));
					String sqlEtatEmprunt = "select etatEmprunt from Emprunts where id = "
							+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
					if (AccesJDBC.trouverNom(sqlEtatEmprunt).equals("valide")) {
						buttonValider1.setEnabled(false);
						buttonAjourner.setEnabled(true);
					} else {
						buttonValider1.setEnabled(true);
						buttonAjourner.setEnabled(false);
					}
				}
			}
		});
		if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null) {
			String sqlidadherent = "select idPersonne from Emprunts where id = "
					+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
			String sqlnomadherent = "select Nom from Personnes where id = " + AccesJDBC.trouverNom(sqlidadherent);
			String sqlprenomadherent = "select Prenom from Personnes where id = " + AccesJDBC.trouverNom(sqlidadherent);
			String sqlidDoc = "select idDocument from Emprunts where id = "
					+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
			String sqlTitredoc = "select Titre from Documents where id = " + AccesJDBC.trouverNom(sqlidDoc);
			labelAdherentEmprunt.setText("Adhérent : " + AccesJDBC.trouverNom(sqlnomadherent) + " "
					+ AccesJDBC.trouverNom(sqlprenomadherent));
			labelTitreDocEmprunt.setText("Titre du document: " + AccesJDBC.trouverNom(sqlTitredoc));
		}
		comboBoxRetourEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxRetourEmprunt.getSelectedItem() != null) {
					String sqlidadherent = "select idPersonne from Emprunts where id = "
							+ comboBoxRetourEmprunt.getSelectedItem();
					String sqlnomadherent = "select Nom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlprenomadherent = "select Prenom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlidDoc = "select idDocument from Emprunts where id = "
							+ comboBoxRetourEmprunt.getSelectedItem();
					String sqlTitredoc = "select Titre from Documents where id = " + AccesJDBC.trouverNom(sqlidDoc);
					String sqletat = "select etatEmprunt from Emprunts where id = "
							+ comboBoxRetourEmprunt.getSelectedItem();
					labelAherent2.setText("Adhérent : " + AccesJDBC.trouverNom(sqlnomadherent) + " "
							+ AccesJDBC.trouverNom(sqlprenomadherent));
					labelTitreDocEmprunt2.setText("Titre du document: " + AccesJDBC.trouverNom(sqlTitredoc));
					labelEtat.setText("Etat de l'emprunt: " + AccesJDBC.trouverNom(sqletat));
				}
			}
		});
		if (comboBoxRetourEmprunt.getSelectedItem() != null) {
			String sqlidadherent = "select idPersonne from Emprunts where id = "
					+ comboBoxRetourEmprunt.getSelectedItem();
			String sqlnomadherent = "select Nom from Personnes where id = " + AccesJDBC.trouverNom(sqlidadherent);
			String sqlprenomadherent = "select Prenom from Personnes where id = " + AccesJDBC.trouverNom(sqlidadherent);
			String sqlidDoc = "select idDocument from Emprunts where id = " + comboBoxRetourEmprunt.getSelectedItem();
			String sqlTitredoc = "select Titre from Documents where id = " + AccesJDBC.trouverNom(sqlidDoc);
			String sqletat = "select etatEmprunt from Emprunts where id = " + comboBoxRetourEmprunt.getSelectedItem();
			labelAherent2.setText("Adhérent : " + AccesJDBC.trouverNom(sqlnomadherent) + " "
					+ AccesJDBC.trouverNom(sqlprenomadherent));
			labelTitreDocEmprunt2.setText("Titre du document: " + AccesJDBC.trouverNom(sqlTitredoc));
			labelEtat.setText("Etat de l'emprunt: " + AccesJDBC.trouverNom(sqletat));
		}
		buttonValider1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null
						&& GestionErreurs.formatDate(textFieldDateLimite.getText())) {
					String query = "update Emprunts set etatEmprunt = 'valide', dateLimite = '"
							+ textFieldDateLimite.getText() + "' where id = "
							+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
					AccesJDBC.Edition(query);
					// mise à jour de la liste des emprunts à valider
					initChoixEmpruntsNonValidesAjourne();
				}
			}
		});
		buttonAjourner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null
						&& GestionErreurs.formatDate(textFieldDateLimite.getText())) {
					String query = "update Emprunts set etatEmprunt = 'ajourne', dateRelance = '"
							+ textFieldDateLimite.getText() + "' where id = "
							+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
					AccesJDBC.Edition(query);
					// mise à jour de la liste des emprunts à valider
					initChoixEmpruntsNonValidesAjourne();
				}

			}
		});
		buttonValider2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// document rendu
				System.out.println("essai rente");
				if (comboBoxRetourEmprunt.getSelectedItem() != null) {
					String sql = "Select etatEmprunt from Emprunts where id = "
							+ comboBoxRetourEmprunt.getSelectedItem();
					String etatEmprunt = AccesJDBC.trouverNom(sql);
					System.out.println(etatEmprunt);
					if (etatEmprunt.equals("renteencours")) {
						Date date = new Date();
						System.out.println(date);
						String datestring = Operation.dateFormat(date);
						System.out.println(datestring);
						String query = "update Emprunts set etatEmprunt = 'rendu', dateRetour = '" + datestring
								+ "' where id = " + comboBoxRetourEmprunt.getSelectedItem();
						AccesJDBC.Edition(query);
						String querydoc = "Select idDocument from Emprunts where id = "
								+ comboBoxRetourEmprunt.getSelectedItem();
						String idDoc = AccesJDBC.trouverNom(querydoc);
						query = "update Documents set isEmprunte = 0 where id = '" + idDoc;
						AccesJDBC.Edition(query);

					}
				}
			}
		});
	}

	public void initChoixEmpruntsNonValidesAjourne() {
		// liste des emprunts non validés par le gérant
		String query = "select id from Emprunts where etatEmprunt = 'encoursvalidation' or etatEmprunt = 'encoursajourné'";
		AccesJDBC.listeChoix(query, comboBoxEmpruntsnonValidesAjourne);
		if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null) {
			String query2 = "select etatEmprunt from Emprunts where id = "
					+ comboBoxEmpruntsnonValidesAjourne.getSelectedItem();
			System.out.println("selectedItem: " + AccesJDBC.trouverNom(query2));
			if (AccesJDBC.trouverNom(query2).equals("encoursvalidation")) {
				System.out.println("cas1");
				buttonValider1.setEnabled(true);
				buttonAjourner.setEnabled(false);
			} else if (comboBoxEmpruntsnonValidesAjourne.getSelectedItem() != null) {
				System.out.println("cas2");
				buttonValider1.setEnabled(false);
				buttonAjourner.setEnabled(true);
			} else {
				System.out.println("cas3");
				buttonAjourner.setEnabled(false);
				buttonValider1.setEnabled(false);
			}
		}
	}

	public void initChoixEmpruntsRetours() {
		// liste des emprunts prêts à être rendus ou périmés
		String query = "select id from Emprunts where etatEmprunt = 'perime' or etatEmprunt = 'renteencours'";
		AccesJDBC.listeChoix(query, comboBoxRetourEmprunt);
		if (comboBoxRetourEmprunt.getSelectedItem() != null) {
			query = "select etatEmprunt from Emprunts where id = " + comboBoxRetourEmprunt.getSelectedItem();
			if (AccesJDBC.trouverNom(query).equals("perime")) {
				buttonValider2.setEnabled(false);
				buttonRetard.setEnabled(true);
			} else if (comboBoxRetourEmprunt.getSelectedItem() != null) {
				buttonValider2.setEnabled(true);
				buttonRetard.setEnabled(false);
			}
		} else {
			buttonValider2.setEnabled(false);
			buttonRetard.setEnabled(false);
		}
	}
}
