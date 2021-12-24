package graphique;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import connexion.AccesJDBC;

public class AdhérantEmprunt {

	public JFrame frmGestionemprunt;
	private JTextField textField;
	public static JTable table_docsempruntes;
	private JComboBox<String> comboBoxIdDoc;
	private JTextPane textPaneDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdhérantEmprunt window = new AdhérantEmprunt();
					window.frmGestionemprunt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdhérantEmprunt() {
		initialize();
		String sql = "Select id from Documents where Titre like '" + textField.getText() + "%'";
		AccesJDBC.listeChoix(sql, comboBoxIdDoc);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionemprunt = new JFrame();
		frmGestionemprunt.setTitle("GESTION_EMPRUNT");
		frmGestionemprunt.setBounds(100, 100, 780, 349);
		frmGestionemprunt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionemprunt.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 359, 209);
		frmGestionemprunt.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setBounds(10, 25, 46, 14);
		panel.add(labelTitre);

		textField = new JTextField();

		textField.setBounds(50, 25, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel labelId = new JLabel("Id");
		labelId.setBounds(10, 59, 46, 14);
		panel.add(labelId);

		comboBoxIdDoc = new JComboBox<String>();
		comboBoxIdDoc.setBounds(50, 55, 97, 22);
		panel.add(comboBoxIdDoc);

		JButton buttonVerifier = new JButton("V\u00E9rifier");

		buttonVerifier.setBounds(264, 56, 85, 21);
		panel.add(buttonVerifier);

		textPaneDescription = new JTextPane();
		textPaneDescription.setEditable(false);
		textPaneDescription.setBounds(10, 92, 339, 107);
		panel.add(textPaneDescription);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(397, 44, 359, 209);
		frmGestionemprunt.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		table_docsempruntes = new JTable();
		table_docsempruntes.setBounds(10, 33, 339, 166);
		panel_1.add(table_docsempruntes);

		JCheckBox checkBoxstatut = new JCheckBox("Trier par statut");
		checkBoxstatut.setBounds(10, 6, 160, 21);
		panel_1.add(checkBoxstatut);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Trier par date fin d'emprunt");
		chckbxNewCheckBox.setBounds(193, 6, 160, 21);
		panel_1.add(chckbxNewCheckBox);

		JLabel lblNewLabel = new JLabel("Documents disponibles ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(39, 11, 227, 22);
		frmGestionemprunt.getContentPane().add(lblNewLabel);

		JLabel lblDocumentsEmprunts = new JLabel("Documents emprunt\u00E9s");
		lblDocumentsEmprunts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDocumentsEmprunts.setBounds(417, 11, 227, 22);
		frmGestionemprunt.getContentPane().add(lblDocumentsEmprunts);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonRetour.setBounds(10, 276, 140, 23);
		frmGestionemprunt.getContentPane().add(buttonRetour);

		JButton btnEmprunt = new JButton("Emprunter");
		btnEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// d'abord vérifier si un document est sélectionné
				if (comboBoxIdDoc.getSelectedItem() != null) {
					// d'abord vérifier si le document est disponible
					boolean documentDispo = false;
					String sqldocdispo = "select isEmprunte from Documents where id = "
							+ comboBoxIdDoc.getSelectedItem();
					documentDispo = AccesJDBC.booleen(sqldocdispo);
					if (!documentDispo) {
						// document non emprunté
						String sqlcreationEmprunt = "insert into Emprunts values (" + comboBoxIdDoc.getSelectedItem()
								+ "," + Menu.idLogin + ",'encoursvalidation',null,null,null,null)";
						AccesJDBC.Edition(sqlcreationEmprunt);

						// il faut mettre à jour l'attribut "estEmprunté" pour éviter que 2 adhérents
						// empruntent simultanément le même document
						String sqlupdateDoc = "update Documents set isEmprunte = 1 where id = "
								+ comboBoxIdDoc.getSelectedItem();
						AccesJDBC.Edition(sqlupdateDoc);

					}
				}
			}
		});
		btnEmprunt.setBounds(160, 276, 140, 23);
		frmGestionemprunt.getContentPane().add(btnEmprunt);

		JButton buttonRecherche = new JButton("Recherche Document");
		buttonRecherche.setBounds(477, 276, 140, 23);
		frmGestionemprunt.getContentPane().add(buttonRecherche);

		JButton buttonfinEmprunt = new JButton("Rendre");
		buttonfinEmprunt.setBounds(310, 277, 140, 21);
		frmGestionemprunt.getContentPane().add(buttonfinEmprunt);

		JButton btnNewButton = new JButton("Reporter");
		btnNewButton.setBounds(625, 277, 131, 21);
		frmGestionemprunt.getContentPane().add(btnNewButton);

		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sql = "Select id from Documents where Titre like '" + textField.getText() + "%'";
				AccesJDBC.listeChoix(sql, comboBoxIdDoc);
			}
		});

		buttonVerifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDetailDoc();
			}
		});
	}

	public void afficherDetailDoc() {
		int id = Integer.parseInt(comboBoxIdDoc.getSelectedItem().toString());
		AccesJDBC.afficherDetailDocument(id, textPaneDescription);
	}
}
