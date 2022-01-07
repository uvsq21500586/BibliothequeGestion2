package graphique;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import connexion.AccesJDBC;
import erreurs.GestionErreurs;

public class AjoutDoc {

	public static JFrame frame;
	public JTable tableAuteurs;
	private JTextField prenom;
	private JTextField dateDeces;
	private JTextField dateNaissance;
	private JTextField nom;
	private JLabel lblNewLabel_2;
	private JTextField sousTitre;
	private JTextField titre;
	private JTextField codeReference;
	private JTextField dateEdition;
	private JLabel lblNewLabel_3;
	private JTextField nomEditeur;
	private JTextField prenomEditeur;
	private JTextField adresse;
	private JTextField siteWeb;
	private JTextField telephone;
	private JLabel lblNewLabel_4;
	private JTextField themeNouveau;
	public JTable tableEditeurs;
	private JComboBox<String> comboBoxTypeDoc;
	private JComboBox<String> comboBoxThemes;
	private JCheckBox checkBoxNouveauTheme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutDoc window = new AjoutDoc();
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
	public AjoutDoc() {
		initialize();
		afficherAuteurs();
		afficherEditeurs();
		InitialiserListeThemes();
		// afficher();
		// ajouter();
		// supprimer();
		// modifier();

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 1250, 821);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton btnAjouterDoc = new JButton("Ajouter un document");
		btnAjouterDoc.setBounds(20, 10, 450, 62);
		btnAjouterDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter();

			}
		});
		frame.getContentPane().setLayout(null);
		btnAjouterDoc.setForeground(Color.GREEN);
		btnAjouterDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.getContentPane().add(btnAjouterDoc);

		JPanel panel = new JPanel();
		panel.setBounds(20, 82, 1206, 696);
		panel.setBackground(new Color(245, 245, 245));
		panel.setForeground(new Color(192, 192, 192));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel labelAuteurs = new JLabel("Auteurs");
		labelAuteurs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelAuteurs.setBounds(464, 4, 137, 37);
		panel.add(labelAuteurs);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 48, 732, 275);
		panel.add(scrollPane);

		tableAuteurs = new JTable();
		tableAuteurs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(tableAuteurs);

		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		prenom.setBounds(119, 78, 335, 25);
		panel.add(prenom);
		prenom.setColumns(10);

		dateDeces = new JTextField();
		dateDeces.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateDeces.setColumns(10);
		dateDeces.setBounds(339, 113, 115, 25);
		panel.add(dateDeces);

		dateNaissance = new JTextField();
		dateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateNaissance.setColumns(10);
		dateNaissance.setBounds(117, 113, 115, 25);
		panel.add(dateNaissance);

		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nom.setColumns(10);
		nom.setBounds(119, 43, 335, 25);
		panel.add(nom);

		JLabel lblNewLabel_1 = new JLabel("Auteur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(209, -2, 103, 43);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Document");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(197, 148, 115, 28);
		panel.add(lblNewLabel_2);

		sousTitre = new JTextField();
		sousTitre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sousTitre.setColumns(10);
		sousTitre.setBounds(127, 215, 327, 25);
		panel.add(sousTitre);

		titre = new JTextField();
		titre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titre.setColumns(10);
		titre.setBounds(127, 180, 327, 25);
		panel.add(titre);

		codeReference = new JTextField();
		codeReference.setFont(new Font("Tahoma", Font.PLAIN, 16));
		codeReference.setColumns(10);
		codeReference.setBounds(127, 285, 327, 25);
		panel.add(codeReference);

		dateEdition = new JTextField();
		dateEdition.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dateEdition.setColumns(10);
		dateEdition.setBounds(127, 250, 327, 25);
		panel.add(dateEdition);

		lblNewLabel_3 = new JLabel("Editeur");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(209, 363, 96, 28);
		panel.add(lblNewLabel_3);

		nomEditeur = new JTextField();
		nomEditeur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nomEditeur.setColumns(10);
		nomEditeur.setBounds(127, 401, 327, 25);
		panel.add(nomEditeur);

		prenomEditeur = new JTextField();
		prenomEditeur.setFont(new Font("Tahoma", Font.PLAIN, 16));
		prenomEditeur.setColumns(10);
		prenomEditeur.setBounds(127, 439, 327, 25);
		panel.add(prenomEditeur);

		adresse = new JTextField();
		adresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adresse.setColumns(10);
		adresse.setBounds(127, 477, 327, 25);
		panel.add(adresse);

		siteWeb = new JTextField();
		siteWeb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		siteWeb.setColumns(10);
		siteWeb.setBounds(127, 515, 327, 25);
		panel.add(siteWeb);

		telephone = new JTextField();
		telephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
					e.consume();

					JOptionPane.showMessageDialog(null, "Numéros seulement", "Numéros",
							JOptionPane.INFORMATION_MESSAGE);
					telephone.setText("");
				}

			}
		});
		telephone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		telephone.setColumns(10);
		telephone.setBounds(127, 553, 327, 25);
		panel.add(telephone);

		lblNewLabel_4 = new JLabel("Th\u00E8me");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(209, 581, 115, 28);
		panel.add(lblNewLabel_4);

		themeNouveau = new JTextField();
		themeNouveau.setEditable(false);
		themeNouveau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		themeNouveau.setColumns(10);
		themeNouveau.setBounds(175, 657, 276, 28);
		panel.add(themeNouveau);

		JLabel lblNewLabel_5 = new JLabel("Nouveau th\u00E8me");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5.setBounds(11, 656, 154, 31);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_5_1 = new JLabel("T\u00E9l\u00E9phone");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_1.setBounds(14, 553, 103, 25);
		panel.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Site Web");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_2.setBounds(14, 512, 103, 25);
		panel.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Adresse");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_3.setBounds(14, 477, 103, 25);
		panel.add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_4 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5_4.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_4.setBounds(14, 439, 103, 25);
		panel.add(lblNewLabel_5_4);

		JLabel lblNewLabel_5_5 = new JLabel("Nom");
		lblNewLabel_5_5.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5.setBounds(14, 401, 103, 25);
		panel.add(lblNewLabel_5_5);

		JLabel lblNewLabel_5_5_1 = new JLabel("Titre");
		lblNewLabel_5_5_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5_1.setBounds(11, 181, 103, 25);
		panel.add(lblNewLabel_5_5_1);

		JLabel lblNewLabel_5_4_1 = new JLabel("Sous-Titre");
		lblNewLabel_5_4_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_4_1.setBounds(11, 216, 103, 25);
		panel.add(lblNewLabel_5_4_1);

		JLabel lblNewLabel_5_3_1 = new JLabel("Date \u00E9dition");
		lblNewLabel_5_3_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_3_1.setBounds(11, 251, 103, 25);
		panel.add(lblNewLabel_5_3_1);

		JLabel lblNewLabel_5_2_1 = new JLabel("Code Ref");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_2_1.setBounds(11, 286, 103, 25);
		panel.add(lblNewLabel_5_2_1);

		JLabel lblNewLabel_5_1_1 = new JLabel("Type Doc");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_1_1.setBounds(11, 321, 103, 31);
		panel.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_5_1_1 = new JLabel("N\u00E9(e) le");
		lblNewLabel_5_5_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5_1_1.setBounds(14, 113, 103, 25);
		panel.add(lblNewLabel_5_5_1_1);

		JLabel lblNewLabel_5_5_1_2 = new JLabel("Nom");
		lblNewLabel_5_5_1_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5_1_2.setBounds(11, 44, 103, 25);
		panel.add(lblNewLabel_5_5_1_2);

		JLabel lblNewLabel_5_5_1_1_1 = new JLabel("D\u00E9c\u00E8s");
		lblNewLabel_5_5_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5_1_1_1.setBounds(269, 113, 72, 25);
		panel.add(lblNewLabel_5_5_1_1_1);

		JLabel lblNewLabel_5_5_1_2_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5_5_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel_5_5_1_2_1.setBounds(11, 79, 103, 25);
		panel.add(lblNewLabel_5_5_1_2_1);

		JLabel labelEditeurs = new JLabel("Editeurs");
		labelEditeurs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelEditeurs.setBounds(464, 333, 103, 31);
		panel.add(labelEditeurs);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(464, 373, 732, 312);
		panel.add(scrollPane_1);

		tableEditeurs = new JTable();
		scrollPane_1.setViewportView(tableEditeurs);

		comboBoxTypeDoc = new JComboBox<String>();
		comboBoxTypeDoc.setBounds(127, 320, 327, 25);
		panel.add(comboBoxTypeDoc);

		checkBoxNouveauTheme = new JCheckBox("Nouveau th\u00E8me ?");

		checkBoxNouveauTheme.setFont(new Font("Tahoma", Font.ITALIC, 16));
		checkBoxNouveauTheme.setBounds(11, 621, 164, 21);
		panel.add(checkBoxNouveauTheme);

		JLabel lblNewLabel = new JLabel("Th\u00E8me existant");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNewLabel.setBounds(179, 619, 130, 25);
		panel.add(lblNewLabel);

		comboBoxThemes = new JComboBox<String>();
		comboBoxThemes.setBounds(300, 623, 154, 28);
		panel.add(comboBoxThemes);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonRetour.setBounds(776, 10, 450, 62);
		frame.getContentPane().add(buttonRetour);
		comboBoxTypeDoc.addItem("livre");
		comboBoxTypeDoc.addItem("dictionnaire");
		comboBoxTypeDoc.addItem("revue");
		comboBoxTypeDoc.addItem("video");
		comboBoxTypeDoc.addItem("audio");
		comboBoxTypeDoc.addItem("bd");
		comboBoxTypeDoc.addItem("volume");
		comboBoxTypeDoc.addItem("journal");

		checkBoxNouveauTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBoxNouveauTheme.isSelected()) {
					themeNouveau.setEditable(true);
					comboBoxThemes.setEditable(false);
				} else {
					themeNouveau.setEditable(false);
					comboBoxThemes.setEditable(true);
				}
			}
		});
	}

	public void ajouter() {
		if ((dateEdition.getText().equals("") || GestionErreurs.formatDate2(dateEdition.getText(), frame))
				&& GestionErreurs.titreDocument(titre.getText())) {
			try {
				int idauteur = -1;
				int idediteur = -1;
				if (tableAuteurs.getSelectedRow() > -1) {
					idauteur = Integer.parseInt(tableAuteurs.getValueAt(tableAuteurs.getSelectedRow(), 0).toString());
				}
				if (tableAuteurs.getSelectedRow() == -1 && !nom.getText().equals("")) {
					// nouvel auteur
					String sql = "insert into Auteurs (nom,prenom,dateNaissance,dateDeces) values ('" + nom.getText()
							+ "','" + prenom.getText() + "',";
					if (!GestionErreurs.formatDate2(dateNaissance.getText().toString(), frame)) {
						sql = sql + "null,";
					} else {
						sql = sql + "'" + dateNaissance.getText().toString() + "',";
					}
					if (!GestionErreurs.formatDate2(dateDeces.getText().toString(), frame)) {
						sql = sql + "null)";
					} else {
						sql = sql + "'" + dateDeces.getText().toString() + "')";
					}
					AccesJDBC.Edition(sql);
				}
				if (tableEditeurs.getSelectedRow() > -1) {
					idediteur = Integer
							.parseInt(tableEditeurs.getValueAt(tableEditeurs.getSelectedRow(), 0).toString());
				}
				if (tableEditeurs.getSelectedRow() == -1 && !nomEditeur.getText().equals("")) {
					// nouvel editeur
					String sql2 = "insert into Editeurs(nom,prenom,adresse,siteWeb,telephone) values ('" + nom.getText()
							+ "','" + prenom.getText() + "','" + adresse.getText().toString() + "','"
							+ siteWeb.getText().toString() + "','" + telephone.getText().toString() + "')";
					AccesJDBC.Edition(sql2);
				}
				if (idediteur == -1 && nomEditeur.getText().equals("")) {
					String sql1 = "insert into Documents (titre,soustitre,dateEdition,codeReference,typeDocument,isEmprunte) values ('"
							+ titre.getText().toString() + "','" + sousTitre.getText().toString() + "','"
							+ dateEdition.getText().toString() + "','" + codeReference.getText().toString() + "','"
							+ comboBoxTypeDoc.getSelectedItem() + "',0)";
					System.out.println("sql1: " + sql1);
					AccesJDBC.Edition(sql1);
				} else {
					String sql1 = "insert into Documents (titre,soustitre,dateEdition,codeReference,typeDocument,idEditeur,isEmprunte) values ('"
							+ titre.getText().toString() + "','" + sousTitre.getText().toString() + "','"
							+ dateEdition.getText().toString() + "','" + codeReference.getText().toString() + "','"
							+ comboBoxTypeDoc.getSelectedItem() + "'," + idediteur + ",0)";
					System.out.println("sql1: " + sql1);
					AccesJDBC.Edition(sql1);
				}
				// recherche id du nouveau document
				String sqlIdNouveaudoc = "select id from Documents where titre = '" + titre.getText().toString() + "'";
				if (!sousTitre.getText().toString().equals("")) {
					sqlIdNouveaudoc = sqlIdNouveaudoc + " and soustitre = '" + sousTitre.getText() + "'";
				}
				if (!dateEdition.getText().toString().equals("")) {
					sqlIdNouveaudoc = sqlIdNouveaudoc + " and dateEdition = '" + dateEdition.getText() + "'";
				}
				if (!codeReference.getText().toString().equals("")) {
					sqlIdNouveaudoc = sqlIdNouveaudoc + " and codeReference = '" + codeReference.getText() + "'";
				}
				sqlIdNouveaudoc = sqlIdNouveaudoc + " and typeDocument = '" + comboBoxTypeDoc.getSelectedItem() + "'";
				String iddoc = AccesJDBC.trouverNom(sqlIdNouveaudoc);

				// thème
				if (checkBoxNouveauTheme.isSelected()) {
					String sql3 = "insert into Themes (nom) values ('" + themeNouveau.getText() + "')";
					AccesJDBC.Edition(sql3);
					String sqltheme = "select id from Themes where nom = '" + themeNouveau.getText() + "'";
					System.out.println("sqltheme: " + sqltheme);
					sql3 = "insert into DocumentTheme values(" + iddoc + "," + AccesJDBC.trouverNom(sqltheme) + ")";
					System.out.println("sql3: " + sql3);
					AccesJDBC.Edition(sql3);
				} else {
					String sqltheme = "Select id from Themes where nom = '" + comboBoxThemes.getSelectedItem() + "'";
					String sql3 = "insert into DocumentTheme values(" + iddoc + "," + AccesJDBC.trouverNom(sqltheme)
							+ ")";
					System.out.println("sql3: " + sql3);
					AccesJDBC.Edition(sql3);
				}

				// lien Document-auteur
				if (idauteur > -1 && !nom.getText().equals("")) {
					String sql4 = "insert into DocumentsAuteurs values (" + iddoc + "," + idauteur + ")";
					AccesJDBC.Edition(sql4);
				}
				afficherAuteurs();
				afficherEditeurs();

			}

			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void afficherAuteurs() {

		String sql = "SELECT * FROM [Pgi].[dbo].[Auteurs]";
		AccesJDBC.afficherAuteurs(sql, this);

	}

	public void afficherEditeurs() {

		String sql = "SELECT * FROM [Pgi].[dbo].[Editeurs]";
		AccesJDBC.afficherEditeurs(sql, this);

	}

	public void InitialiserListeThemes() {
		String query = "select Nom from Themes";
		AccesJDBC.listeChoix(query, comboBoxThemes);
	}
}
