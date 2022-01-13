package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

public class Messagerie {

	public static int idpersonne;

	public JFrame frameMessagerie;
	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;

	private JTable Tablelistemessages;
	private JTextField txtmessage;
	private JTextField txttitre;
	private JTextField txtdate;
	private JTextField txtidexpediteur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messagerie window = new Messagerie();
					window.frameMessagerie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Messagerie() {
		initialize();
		Affichage();
	}

	public Messagerie(int id) {
		idpersonne = id;
		initialize();
		Affichage();
	}

	private void Affichage() {
		// TODO Auto-generated method stub

		String sql = "select titre , idExpediteur , idDestinataire ,estLue from Message where idDestinataire = "
				+ idpersonne;
		AccesJDBC.AfficherTableMessages(sql, Tablelistemessages);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMessagerie = new JFrame();
		frameMessagerie.getContentPane().setBackground(new Color(224, 255, 255));
		frameMessagerie.setTitle("Messagerie");
		frameMessagerie.setBounds(100, 100, 812, 450);
		frameMessagerie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// cnx = Connexionsql.ConnexionDB();
		frameMessagerie.getContentPane().setLayout(null);

		JButton buttonNouveauMessage = new JButton("Nouveau message");
		buttonNouveauMessage.setBounds(72, 10, 175, 27);
		buttonNouveauMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sqlidgerant = "select id from Personnes where statut = 'Gerant'";
				int idgerant = Integer.parseInt(AccesJDBC.trouverNom(sqlidgerant));
				NouveauMessage window = new NouveauMessage(idpersonne, idgerant);
				window.frame.setVisible(true);

			}
		});
		frameMessagerie.getContentPane().add(buttonNouveauMessage);

		JButton buttonSupprimerMessage = new JButton("Supprimer message");
		buttonSupprimerMessage.setBounds(309, 10, 175, 27);
		buttonSupprimerMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ligne = Tablelistemessages.getSelectedRow();
				String titre = Tablelistemessages.getModel().getValueAt(ligne, 0).toString();
				String sql = "delete from Message where titre ='" + titre + "'";
				AccesJDBC.Edition(sql);
				/*
				 * try { prepared = cnx.prepareStatement(sql); prepared.execute();
				 */

				JOptionPane.showMessageDialog(null, "Un compte est supprimé avec succès ");
				Affichage();
				/*
				 * } catch (SQLException e1) { // TODO Auto-generated catch block
				 * e1.printStackTrace(); }
				 */

			}
		});
		frameMessagerie.getContentPane().add(buttonSupprimerMessage);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMessagerie.dispose();
			}
		});
		buttonRetour.setBounds(524, 9, 175, 27);
		frameMessagerie.getContentPane().add(buttonRetour);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 47, 371, 357);
		frameMessagerie.getContentPane().add(scrollPane);

		Tablelistemessages = new JTable();
		Tablelistemessages.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int ligne = Tablelistemessages.getSelectedRow();
				String titre = Tablelistemessages.getModel().getValueAt(ligne, 0).toString();

				String sql = " Select  contenu  from Message where titre = '" + titre + "'";
				String sql1 = " Select  titre  from Message where titre = '" + titre + "'";
				String sql2 = " Select  dateEnvoi  from Message where titre = '" + titre + "'";
				String sql3 = " Select  idExpediteur  from Message where titre = '" + titre + "'";
				String afficher = AccesJDBC.trouverNom(sql);
				String aff = AccesJDBC.trouverNom(sql1);
				String affi = AccesJDBC.trouverNom(sql2);
				String affic = AccesJDBC.trouverNom(sql3);

				txtmessage.setText(afficher);
				txttitre.setText(aff);
				txtdate.setText(affi);
				txtidexpediteur.setText(affic);

			}
		});
		scrollPane.setViewportView(Tablelistemessages);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(401, 48, 395, 356);
		frameMessagerie.getContentPane().add(scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titre");
		lblNewLabel.setBounds(10, 35, 68, 21);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 67, 68, 21);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDate);

		JLabel lblExpediteur = new JLabel("Expediteur");
		lblExpediteur.setBounds(10, 99, 68, 21);
		lblExpediteur.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblExpediteur);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(20, 159, 363, 184);
		panel.add(scrollPane_2);

		txtmessage = new JTextField();
		txtmessage.setHorizontalAlignment(SwingConstants.LEFT);
		// txtmessage.setVerticalAlignment(SwingConstants.TOP);

		scrollPane_2.setViewportView(txtmessage);
		txtmessage.setColumns(10);

		txttitre = new JTextField();
		txttitre.setBounds(92, 35, 291, 20);
		panel.add(txttitre);
		txttitre.setColumns(10);

		txtdate = new JTextField();
		txtdate.setBounds(92, 67, 291, 20);
		txtdate.setColumns(10);
		panel.add(txtdate);

		txtidexpediteur = new JTextField();
		txtidexpediteur.setBounds(92, 99, 291, 20);
		txtidexpediteur.setColumns(10);
		panel.add(txtidexpediteur);

		JLabel lblNewLabel_1 = new JLabel("Contenu de Message");
		lblNewLabel_1.setBounds(32, 131, 212, 20);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);

	}

}
