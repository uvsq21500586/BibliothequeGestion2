package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import connexion.AccesJDBC;

public class Authentification {

	protected static final Object Gerant = null;
	public JFrame frame;
	private JTextField usernamefield;

	Connection cnx = null;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification window = new Authentification();
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
	public Authentification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.getContentPane().setLayout(null);
		// cnx = Connexionsql.ConnexionDB();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(218, 112, 214));
		panel.setBounds(0, 0, 297, 311);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BIENVENUE SUR PGI BIBLIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 277, 41);
		panel.add(lblNewLabel);

		JLabel biblioimg = new JLabel("");
		biblioimg.setIcon(new ImageIcon("images/bibliotheque.png"));
		biblioimg.setBounds(10, 172, 52, 116);
		panel.add(biblioimg);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(218, 112, 214));
		panel_1.setBounds(38, 73, 100, 20);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Identifiant");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 0, 100, 20);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(218, 112, 214));
		panel_2.setBounds(38, 117, 100, 20);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Mot de Passe");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(0, 0, 100, 20);
		panel_2.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);

		usernamefield = new JTextField();
		usernamefield.setBounds(148, 73, 119, 20);
		panel.add(usernamefield);
		usernamefield.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(72, 61, 139));
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(143, 151, 120, 30);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton signin = new JButton("Se connecter");
		signin.setBounds(0, 0, 120, 30);
		panel_3.add(signin);
		signin.setFont(new Font("Calibri", Font.BOLD, 15));
		signin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String username = usernamefield.getText().toString();
				String password = passwordField.getText().toString();

				String sql = "select count (*) from Personnes where loginconnexion = '" + username
						+ "' and motdepasse = '" + password + "'";

				int acces = AccesJDBC.compter(sql);

				if (acces == 0) {
					JOptionPane.showMessageDialog(null, "Connexion Echouée");
				} else {
					JOptionPane.showMessageDialog(null, "Connexion Reussite");
					sql = "select statut from Personnes where loginconnexion = '" + username + "' and motdepasse = '"
							+ password + "'";
					String statutlogin = AccesJDBC.trouverNom(sql);
					sql = "select id from Personnes where loginconnexion = '" + username + "' and motdepasse = '"
							+ password + "'";
					int idlogin = Integer.parseInt(AccesJDBC.trouverNom(sql));
					Menu window = new Menu(statutlogin, idlogin);
					window.frameMenu.setVisible(true);
					frame.dispose();

				}

			}

		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(165, 42, 42));
		panel_4.setBounds(131, 262, 136, 27);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JButton createaccount = new JButton("Cr\u00E9er un compte");
		createaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Addcompte objet = new Addcompte();
				objet.frmInscription.setVisible(true);

			}

		});
		createaccount.setBounds(0, 0, 136, 27);
		panel_4.add(createaccount);
		createaccount.setFont(new Font("Calibri", Font.BOLD, 14));

		passwordField = new JPasswordField();
		passwordField.setBounds(148, 117, 119, 20);
		panel.add(passwordField);
		frame.setBounds(100, 100, 313, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
