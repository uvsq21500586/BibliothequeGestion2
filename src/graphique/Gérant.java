package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import connexion.AccesJDBC;

public class Gérant {

	public JFrame frmGestions;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JTextField nomfield;
	private JTextField prenomfield;
	private JTextField loginfield;
	private JTextField statutfield;
	private JTextField passwordfield;
	private JTable Table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gérant window = new Gérant();
					window.frmGestions.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gérant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestions = new JFrame();
		frmGestions.setTitle("Gestion des comptes");
		frmGestions.setBounds(100, 100, 696, 444);
		frmGestions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestions.getContentPane().setLayout(null);
		// cnx = Connexionsql.ConnexionDB();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 0, 670, 394);
		frmGestions.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("G\u00E9rant Uniquement");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_2.setBounds(10, 0, 650, 44);
		panel.add(lblNewLabel_2);

		Panel panel_1 = new Panel();
		panel_1.setBounds(10, 50, 304, 282);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 70, 80, 25);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		Label label_1 = new Label("Nom");
		label_1.setBounds(0, 0, 80, 25);
		panel_3.add(label_1);
		label_1.setAlignment(Label.CENTER);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 110, 80, 25);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		Label label_2 = new Label("Prenom");
		label_2.setBounds(0, 0, 80, 25);
		panel_4.add(label_2);
		label_2.setAlignment(Label.CENTER);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 150, 80, 25);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		Label label_3 = new Label("Loginconnexion");
		label_3.setBounds(0, 0, 80, 25);
		panel_5.add(label_3);
		label_3.setAlignment(Label.CENTER);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 190, 80, 25);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		Label label_4 = new Label("Password");
		label_4.setBounds(0, 0, 80, 25);
		panel_6.add(label_4);
		label_4.setAlignment(Label.CENTER);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 230, 80, 25);
		panel_1.add(panel_7);
		panel_7.setLayout(null);

		Label label_5 = new Label("Statut");
		label_5.setBounds(0, 0, 80, 25);
		panel_7.add(label_5);
		label_5.setAlignment(Label.CENTER);

		nomfield = new JTextField();
		nomfield.setColumns(10);
		nomfield.setBounds(107, 75, 180, 25);
		panel_1.add(nomfield);

		prenomfield = new JTextField();
		prenomfield.setColumns(10);
		prenomfield.setBounds(107, 115, 180, 25);
		panel_1.add(prenomfield);

		loginfield = new JTextField();
		loginfield.setColumns(10);
		loginfield.setBounds(107, 155, 180, 25);
		panel_1.add(loginfield);

		passwordfield = new JTextField();
		passwordfield.setColumns(10);
		passwordfield.setBounds(107, 195, 180, 25);
		panel_1.add(passwordfield);

		statutfield = new JTextField();
		statutfield.setColumns(10);
		statutfield.setBounds(107, 235, 180, 25);
		panel_1.add(statutfield);

		JLabel lblNewLabel_1_1 = new JLabel("Les Informations des Adh\u00E9rents Abonn\u00E9es");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 11, 284, 30);
		panel_1.add(lblNewLabel_1_1);

		Panel panel_1_1 = new Panel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(320, 50, 340, 282);
		panel.add(panel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Liste des comptes");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 320, 26);
		panel_1_1.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 58, 310, 213);
		panel_1_1.add(scrollPane);

		JButton btnEnvoyerUnMessage = new JButton("Envoyer un Message");
		btnEnvoyerUnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = Table.getSelectedRow();
				if (ligne > -1) {
					String id = Table.getModel().getValueAt(ligne, 0).toString();
					NouveauMessage window = new NouveauMessage(Menu.idLogin, Integer.parseInt(id));
					window.frame.setVisible(true);
				}
			}
		});
		btnEnvoyerUnMessage.setIcon(new ImageIcon("images/messagerie.png"));
		btnEnvoyerUnMessage.setBounds(409, 338, 142, 45);
		panel.add(btnEnvoyerUnMessage);

		JButton btnmodifier = new JButton("Modifier le statut");
		btnmodifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = Table.getSelectedRow();
				if (ligne > -1) {
					String id = Table.getModel().getValueAt(ligne, 0).toString();
					if (Table.getValueAt(ligne, 5).toString().equals("Gerant")) {
						String sql = " Update Personnes set  statut = 'Adherent' where id = " + id;
						AccesJDBC.Edition(sql);
					} else {
						String sql = " Update Personnes set  statut = 'Gerant' where id = " + id;
						AccesJDBC.Edition(sql);
					}
					UpdateTable();
				}
			}
		});
		btnmodifier.setIcon(new ImageIcon("images/modifier.png"));
		btnmodifier.setBounds(143, 338, 123, 45);
		panel.add(btnmodifier);

		JButton btnsupprimer = new JButton("Supprimer");
		btnsupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ligne = Table.getSelectedRow();
				String id = Table.getModel().getValueAt(ligne, 0).toString();
				String sql = "delete from Personnes where id = " + id;
				AccesJDBC.Edition(sql);

				JOptionPane.showMessageDialog(null, "Un compte est supprimé avec succès ");
				UpdateTable();
			}
		});
		btnsupprimer.setIcon(new ImageIcon("images/supprimer.png"));
		btnsupprimer.setBounds(276, 338, 123, 45);
		panel.add(btnsupprimer);
		JButton buttonAfficher = new JButton("Afficher");
		buttonAfficher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UpdateTable();
			}
		});
		buttonAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		buttonAfficher.setIcon(new ImageIcon("images/Afficher.png"));
		buttonAfficher.setBounds(10, 338, 123, 45);
		panel.add(buttonAfficher);

		Table = new JTable();
		Table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int ligne = Table.getSelectedRow();
				String id = Table.getModel().getValueAt(ligne, 0).toString();

				String sql = " Select nom from Personnes where id = '" + id + "'";
				String sql1 = " Select prenom from Personnes where id = '" + id + "'";
				String sql2 = " Select loginconnexion from Personnes where id = '" + id + "'";
				String sql3 = " Select motdepasse from Personnes where id = '" + id + "'";
				String sql4 = " Select statut from Personnes where id = '" + id + "'";
				String Afficher = AccesJDBC.trouverNom(sql);
				nomfield.setText(Afficher);

				String p = AccesJDBC.trouverNom(sql1);
				prenomfield.setText(p);

				String l = AccesJDBC.trouverNom(sql2);
				loginfield.setText(l);

				String m = AccesJDBC.trouverNom(sql3);
				passwordfield.setText(m);

				String s = AccesJDBC.trouverNom(sql4);
				statutfield.setText(s);

			}
		});
		scrollPane.setViewportView(Table);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmGestions.dispose();
			}
		});
		buttonRetour.setBounds(561, 334, 99, 50);
		panel.add(buttonRetour);
	}

	private void UpdateTable() {
		// TODO Auto-generated method stub

		String sql = "select * from Personnes";
		AccesJDBC.AfficherTablePersonnes(sql, Table);

	}
}