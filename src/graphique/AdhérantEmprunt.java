package graphique;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.TableColumnModel;

import connexion.AccesJDBC;
import operations.Operation;

public class AdhérantEmprunt {

	public JFrame frmGestionemprunt;
	private JTextField textField;
	public static JTable table_docsempruntes;
	public static boolean demandeReporter = false;
	public static String idEmpruntReport;
	private JComboBox<String> comboBoxIdDoc;
	private JTextPane textPaneDescription;
	private JCheckBox checkBoxstatut;
	private JCheckBox checkBoxfindateemprunt;

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
		afficherDocsEmprunts();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionemprunt = new JFrame();
		frmGestionemprunt.setTitle("GESTION_EMPRUNT");
		frmGestionemprunt.setBounds(100, 100, 901, 349);
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
		panel_1.setBounds(397, 44, 480, 209);
		frmGestionemprunt.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 460, 166);
		panel_1.add(scrollPane);

		table_docsempruntes = new JTable();
		scrollPane.setViewportView(table_docsempruntes);
		table_docsempruntes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		checkBoxstatut = new JCheckBox("Trier par statut");
		checkBoxstatut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDocsEmprunts();
			}
		});
		checkBoxstatut.setBounds(10, 6, 160, 21);
		panel_1.add(checkBoxstatut);

		checkBoxfindateemprunt = new JCheckBox("Trier par date fin d'emprunt");
		checkBoxfindateemprunt.setBounds(193, 6, 160, 21);
		panel_1.add(checkBoxfindateemprunt);
		checkBoxfindateemprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDocsEmprunts();
			}
		});
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
				frmGestionemprunt.dispose();
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
					boolean documentEmprunte = false;
					String sqldocdispo = "select isEmprunte from Documents where id = "
							+ comboBoxIdDoc.getSelectedItem();
					documentEmprunte = AccesJDBC.booleen(sqldocdispo);
					if (!documentEmprunte) {
						// document non emprunté
						String dateEmprunt = Operation.dateFormat(new Date());

						String sqlcreationEmprunt = "insert into Emprunts values (" + comboBoxIdDoc.getSelectedItem()
								+ "," + Menu.idLogin + ",'encoursvalidation','" + dateEmprunt + "',null,null,null)";
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
		btnEmprunt.setBounds(186, 276, 140, 23);
		frmGestionemprunt.getContentPane().add(btnEmprunt);

		JButton buttonRecherche = new JButton("Recherche Document");
		buttonRecherche.setBounds(382, 276, 140, 23);
		frmGestionemprunt.getContentPane().add(buttonRecherche);

		JButton buttonfinEmprunt = new JButton("Rendre");
		buttonfinEmprunt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table_docsempruntes.getSelectedRow());
				if (table_docsempruntes.getSelectedRow() > -1) {
					String sql = "Update Emprunts set etatEmprunt = 'renteencours' where id = "
							+ table_docsempruntes.getValueAt(table_docsempruntes.getSelectedRow(), 0);
					AccesJDBC.Edition(sql);
				}
			}
		});
		buttonfinEmprunt.setBounds(565, 277, 140, 21);
		frmGestionemprunt.getContentPane().add(buttonfinEmprunt);

		JButton buttonReporter = new JButton("Reporter");
		buttonReporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table_docsempruntes.getSelectedRow() > -1 && table_docsempruntes
						.getValueAt(table_docsempruntes.getSelectedRow(), 3).toString().equals("valide")) {
					idEmpruntReport = table_docsempruntes.getValueAt(table_docsempruntes.getSelectedRow(), 0)
							.toString();
					// message
					demandeReporter = true;
					JOptionPane.showMessageDialog(frmGestionemprunt,
							"Demandez au gérant s'il est possible, au moyen d'un message, de reporter l'échéance.",
							"Reporter l'échéance", JOptionPane.INFORMATION_MESSAGE);
					NouveauMessage.idExpediteur = Menu.idLogin;
					String sqlIdGerant = "Select id from Personnes where statut = 'Gerant'";
					String sqlNomGerant = "Select Nom from Personnes where statut = 'Gerant'";
					String sqlPrenomGerant = "Select Prenom from Personnes where statut = 'Gerant'";
					NouveauMessage.idDestinataire = Integer.parseInt(AccesJDBC.trouverNom(sqlIdGerant));
					NouveauMessage nouveaumessage = new NouveauMessage();
					nouveaumessage.frame.setVisible(true);
					nouveaumessage.txtdestinatairefield
							.setText(AccesJDBC.trouverNom(sqlNomGerant) + " " + AccesJDBC.trouverNom(sqlPrenomGerant));
					nouveaumessage.txtsujetfield.setText("Report emprunt id "
							+ table_docsempruntes.getValueAt(table_docsempruntes.getSelectedRow(), 0));
				}
			}
		});
		buttonReporter.setBounds(746, 277, 131, 21);
		frmGestionemprunt.getContentPane().add(buttonReporter);

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

	public void afficherDocsEmprunts() {
		// liste des documents empruntés par l'adhérent
		String sql = "Select * from Emprunts where idPersonne = " + Menu.idLogin + " and etatEmprunt <> 'rendu'";
		if (checkBoxstatut.isSelected() && !checkBoxfindateemprunt.isSelected()) {
			sql = sql + " order by etatEmprunt";
		} else if (!checkBoxstatut.isSelected() && checkBoxfindateemprunt.isSelected()) {
			sql = sql + " order by dateLimite";
		} else if (checkBoxstatut.isSelected() && checkBoxfindateemprunt.isSelected()) {
			sql = sql + " order by etatEmprunt,dateLimite";
		}
		AccesJDBC.afficherEmprunt(sql);
		TableColumnModel columnModel = table_docsempruntes.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(20);
		columnModel.getColumn(1).setPreferredWidth(20);
		columnModel.getColumn(2).setPreferredWidth(20);
	}
}
