package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import connexion.AccesJDBC;
import erreurs.GestionErreurs;

public class Emprunt {

	public JFrame GESTON_EMPRUNTS;
	private JTextField textField_1;
	private JComboBox<String> comboBoxEmpruntsnonValides;
	private JTextField textFieldDateLimite;

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
		initChoixEmpruntsNonValides();
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

		JLabel lblNewLabel_1_2 = new JLabel("IdAbonn\u00E9 ");
		lblNewLabel_1_2.setBounds(434, 85, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Document");
		lblNewLabel_1_1_1.setBounds(434, 133, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setBounds(512, 170, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(504, 82, 97, 23);
		GESTON_EMPRUNTS.getContentPane().add(textField_1);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(490, 129, 111, 22);
		GESTON_EMPRUNTS.getContentPane().add(comboBox_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(
				new TitledBorder(null, "Validation d'un emprunt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(59, 65, 308, 219);
		GESTON_EMPRUNTS.getContentPane().add(panel);
		panel.setLayout(null);

		JButton buttonValider = new JButton("Valider");

		buttonValider.setBounds(205, 188, 75, 21);
		panel.add(buttonValider);

		comboBoxEmpruntsnonValides = new JComboBox<String>();

		comboBoxEmpruntsnonValides.setBounds(172, 24, 111, 22);
		panel.add(comboBoxEmpruntsnonValides);

		JLabel labelAdherentEmprunt = new JLabel("Adh\u00E9rent:");
		labelAdherentEmprunt.setBounds(10, 65, 273, 14);
		panel.add(labelAdherentEmprunt);

		JLabel labelDocemprunt = new JLabel("Emprunt à valider: ");
		labelDocemprunt.setBounds(10, 28, 159, 14);
		panel.add(labelDocemprunt);

		JLabel labelTitreDocEmprunt = new JLabel("Titre du document: ");
		labelTitreDocEmprunt.setBounds(10, 100, 273, 13);
		panel.add(labelTitreDocEmprunt);

		JLabel labelDateLimite = new JLabel("Date limite d'emprunt:");
		labelDateLimite.setBounds(10, 127, 117, 13);
		panel.add(labelDateLimite);

		textFieldDateLimite = new JTextField();
		textFieldDateLimite.setBounds(169, 123, 96, 19);
		panel.add(textFieldDateLimite);
		textFieldDateLimite.setColumns(10);

		JLabel labelFormatDate = new JLabel("(format: dd/mm/aa)");
		labelFormatDate.setForeground(Color.RED);
		labelFormatDate.setBounds(10, 141, 117, 13);
		panel.add(labelFormatDate);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setBounds(416, 65, 308, 219);
		GESTON_EMPRUNTS.getContentPane().add(panel_1);

		JButton btnNewButton_2 = new JButton("Requetes");
		btnNewButton_2.setBounds(135, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Documents");
		btnNewButton_2_1.setBounds(342, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Abonn\u00E9s");
		btnNewButton_2_1_1.setBounds(553, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1_1);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GESTON_EMPRUNTS.dispose();
			}
		});
		buttonRetour.setBounds(10, 294, 85, 21);
		GESTON_EMPRUNTS.getContentPane().add(buttonRetour);

		comboBoxEmpruntsnonValides.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEmpruntsnonValides.getSelectedItem() != null) {
					String sqlidadherent = "select idPersonne from Emprunts where id = "
							+ comboBoxEmpruntsnonValides.getSelectedItem();
					String sqlnomadherent = "select Nom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlprenomadherent = "select Prenom from Personnes where id = "
							+ AccesJDBC.trouverNom(sqlidadherent);
					String sqlidDoc = "select idDocument from Emprunts where id = "
							+ comboBoxEmpruntsnonValides.getSelectedItem();
					String sqlTitredoc = "select Titre from Documents where id = " + AccesJDBC.trouverNom(sqlidDoc);
					labelAdherentEmprunt.setText("Adhérent : " + AccesJDBC.trouverNom(sqlnomadherent) + " "
							+ AccesJDBC.trouverNom(sqlprenomadherent));
					labelTitreDocEmprunt.setText("Titre du document: " + AccesJDBC.trouverNom(sqlTitredoc));
				}
			}
		});
		buttonValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxEmpruntsnonValides.getSelectedItem() != null
						&& GestionErreurs.formatDate(textFieldDateLimite.getText())) {
					String query = "update Emprunts set etatEmprunt = 'valide', dateLimite = '"
							+ textFieldDateLimite.getText() + "' where id = "
							+ comboBoxEmpruntsnonValides.getSelectedItem();
					AccesJDBC.Edition(query);
					// mise à jour de la liste des emprunts à valider
					initChoixEmpruntsNonValides();
				}
			}
		});
	}

	public void initChoixEmpruntsNonValides() {
		// liste des emprunts non validés par le gérant
		String query = "select id from Emprunts where etatEmprunt = 'encoursvalidation'";
		AccesJDBC.listeChoix(query, comboBoxEmpruntsnonValides);
	}
}
