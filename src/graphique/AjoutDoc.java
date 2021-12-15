package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import net.proteanit.sql.DbUtils;

public class AjoutDoc {

	JFrame frame;
	private JTextField textRecherche;
	private JButton btnNewButton;
	private JTable table;
	private JTextField prenom;
	private JTextField dateDeces;
	private JTextField dateNaissance;
	private JTextField nom;
	private JLabel lblNewLabel_2;
	private JTextField sousTitre;
	private JTextField titre;
	private JTextField codeReference;
	private JTextField dateEdition;
	private JTextField typeDocument;
	private JLabel lblNewLabel_3;
	private JTextField nomEditeur;
	private JTextField prenomEditeur;
	private JTextField adresse;
	private JTextField siteWeb;
	private JTextField telephone;
	private JLabel lblNewLabel_4;
	private JTextField theme;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 1250, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAjouterDoc = new JButton("Ajouter un document");
		btnAjouterDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String url = "jdbc:sqlserver://DESKTOP-RRKJRL7\\SQLEXPRESS; databaseName=Pgi";
				String user = "sa";
				String mdp = "1234";

				try {
					Connection con = DriverManager.getConnection(url, user, mdp);
					String sql = "insert into Auteurs(nom,prenom,dateNaissance,dateDeces)values(?,?,?,?)";
					String sql1 = "insert into Documents(titre,sousTitre,dateEdition,codeReference,typeDocument)values(?,?,?,?,?)";
					String sql2 = "insert into Editeurs(nom,prenom,adresse,siteWeb,telephone)values(?,?,?,?,?)";
					String sql3 = "insert into Themes(nom)values(?)";
					PreparedStatement stm = con.prepareStatement(sql);
					PreparedStatement stm1 = con.prepareStatement(sql1);
					PreparedStatement stm2 = con.prepareStatement(sql2);
					PreparedStatement stm3 = con.prepareStatement(sql3);

					// DBO AUTEURS
					stm.setString(1, nom.getText());
					stm.setString(2, prenom.getText());
					stm.setString(3, dateNaissance.getText());
					stm.setString(4, dateDeces.getText());

					// DBO DOCUMENTS
					stm1.setString(1, titre.getText());
					stm1.setString(2, sousTitre.getText());
					stm1.setString(3, dateEdition.getText());
					stm1.setString(4, codeReference.getText());
					stm1.setString(5, typeDocument.getText());
					// DBO EDITEURS
					stm2.setString(1, nomEditeur.getText());
					stm2.setString(2, prenomEditeur.getText());
					stm2.setString(3, adresse.getText());
					stm2.setString(4, siteWeb.getText());
					stm2.setString(5, telephone.getText());

					// DBO THEMES
					stm3.setString(1, theme.getText());
					stm.executeUpdate();
					stm1.executeUpdate();
					stm2.executeUpdate();
					stm3.executeUpdate();
					con.close();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAjouterDoc.setForeground(Color.GREEN);
		btnAjouterDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAjouterDoc.setBounds(61, 37, 204, 62);
		frame.getContentPane().add(btnAjouterDoc);

		JButton btnSupprimerDoc = new JButton("Supprimer un document");
		btnSupprimerDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String url = "jdbc:sqlserver://DESKTOP-RRKJRL7\\SQLEXPRESS; databaseName=Pgi";
					String user = "sa";
					String mdp = "1234";

					Connection con = DriverManager.getConnection(url, user, mdp);

					String nom = table.getValueAt(table.getSelectedRow(), 0).toString();
					String query = "delete from Documents where id = '" + nom + "'";
					PreparedStatement stm1 = con.prepareStatement(query);
					stm1.executeUpdate();

					con.close();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSupprimerDoc.setForeground(Color.RED);
		btnSupprimerDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSupprimerDoc.setBounds(305, 37, 204, 62);
		frame.getContentPane().add(btnSupprimerDoc);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setForeground(new Color(192, 192, 192));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(20, 109, 1206, 639);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Recherche :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(555, 3, 103, 37);
		panel.add(lblNewLabel);

		textRecherche = new JTextField();
		textRecherche.setBounds(702, 10, 292, 28);
		panel.add(textRecherche);
		textRecherche.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 48, 732, 581);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		prenom = new JTextField();
		prenom.setBounds(277, 48, 140, 28);
		panel.add(prenom);
		prenom.setColumns(10);

		dateDeces = new JTextField();
		dateDeces.setColumns(10);
		dateDeces.setBounds(277, 86, 140, 28);
		panel.add(dateDeces);

		dateNaissance = new JTextField();
		dateNaissance.setColumns(10);
		dateNaissance.setBounds(127, 86, 140, 28);
		panel.add(dateNaissance);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(127, 48, 140, 28);
		panel.add(nom);

		JLabel lblNewLabel_1 = new JLabel("Auteur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 58, 103, 43);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Document");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 145, 96, 43);
		panel.add(lblNewLabel_2);

		sousTitre = new JTextField();
		sousTitre.setColumns(10);
		sousTitre.setBounds(127, 183, 290, 28);
		panel.add(sousTitre);

		titre = new JTextField();
		titre.setColumns(10);
		titre.setBounds(127, 145, 290, 28);
		panel.add(titre);

		codeReference = new JTextField();
		codeReference.setColumns(10);
		codeReference.setBounds(127, 259, 290, 28);
		panel.add(codeReference);

		dateEdition = new JTextField();
		dateEdition.setColumns(10);
		dateEdition.setBounds(127, 221, 290, 28);
		panel.add(dateEdition);

		typeDocument = new JTextField();
		typeDocument.setColumns(10);
		typeDocument.setBounds(127, 297, 290, 28);
		panel.add(typeDocument);

		lblNewLabel_3 = new JLabel("Editeur");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(10, 370, 96, 37);
		panel.add(lblNewLabel_3);

		nomEditeur = new JTextField();
		nomEditeur.setColumns(10);
		nomEditeur.setBounds(127, 370, 290, 28);
		panel.add(nomEditeur);

		prenomEditeur = new JTextField();
		prenomEditeur.setColumns(10);
		prenomEditeur.setBounds(127, 408, 290, 28);
		panel.add(prenomEditeur);

		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(127, 446, 290, 28);
		panel.add(adresse);

		siteWeb = new JTextField();
		siteWeb.setColumns(10);
		siteWeb.setBounds(127, 484, 290, 28);
		panel.add(siteWeb);

		telephone = new JTextField();
		telephone.setColumns(10);
		telephone.setBounds(127, 522, 290, 28);
		panel.add(telephone);

		lblNewLabel_4 = new JLabel("Theme");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 586, 103, 43);
		panel.add(lblNewLabel_4);

		theme = new JTextField();
		theme.setColumns(10);
		theme.setBounds(127, 598, 290, 28);
		panel.add(theme);

		btnNewButton = new JButton("Afficher *\r\n");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:sqlserver://DESKTOP-RRKJRL7\\SQLEXPRESS; databaseName=Pgi";
				String user = "sa";
				String mdp = "1234";

				try {
					Connection con = DriverManager.getConnection(url, user, mdp);
					String sql = "SELECT * FROM [Pgi].[dbo].[Documents]";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						table.setModel(DbUtils.resultSetToTableModel(rs));
					}

					con.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(556, 37, 204, 62);
		frame.getContentPane().add(btnNewButton);
	}
}