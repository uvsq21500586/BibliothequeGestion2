package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Addcompte {

	public JFrame frmInscription;
	private JTextField nomtxtfield;
	private JTextField prenomtxtfield;
	private JTextField statuttxtfield;
	private JTextField usernametxtfield;
	private JTextField passwordtxtfield;

	Connection cnx = null ;
	PreparedStatement prepared = null ;
	ResultSet resultat = null ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addcompte window = new Addcompte();
					window.frmInscription.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addcompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInscription = new JFrame();
		frmInscription.setTitle("Inscription");
		frmInscription.getContentPane().setForeground(new Color(218, 112, 214));
		frmInscription.setBounds(100, 100, 600, 358);
		frmInscription.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);
		cnx = Connexionsql.ConnexionDB();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 564, 371);
		frmInscription.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 67, 100, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(0, 0, 100, 30);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 102, 100, 30);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(0, 0, 100, 30);
		panel_2.add(lblPrnom);
		lblPrnom.setBackground(Color.LIGHT_GRAY);
		lblPrnom.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrnom.setFont(new Font("Calibri", Font.BOLD, 14));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(10, 137, 100, 30);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblAdresse = new JLabel("Statut");
		lblAdresse.setBounds(0, 0, 100, 30);
		panel_3.add(lblAdresse);
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresse.setFont(new Font("Calibri", Font.BOLD, 14));

		JLabel lblNewLabel_2 = new JLabel("Inscrivez Vous sur PGI Biblio ");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 544, 36);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(184, 137, 100, 30);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(294, 85, 100, 30);
		panel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(0, 0, 100, 30);
		panel_5.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Calibri", Font.BOLD, 14));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(296, 147, 100, 30);
		panel.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(0, 0, 100, 30);
		panel_6.add(lblPassword);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));

		nomtxtfield = new JTextField();
		nomtxtfield.setBounds(120, 67, 124, 30);
		panel.add(nomtxtfield);
		nomtxtfield.setColumns(10);

		prenomtxtfield = new JTextField();
		prenomtxtfield.setColumns(10);
		prenomtxtfield.setBounds(120, 102, 124, 30);
		panel.add(prenomtxtfield);

		statuttxtfield = new JTextField();
		statuttxtfield.setColumns(10);
		statuttxtfield.setBounds(120, 137, 124, 30);
		panel.add(statuttxtfield);

		usernametxtfield = new JTextField();
		usernametxtfield.setColumns(10);
		usernametxtfield.setBounds(404, 85, 124, 30);
		panel.add(usernametxtfield);

		passwordtxtfield = new JTextField();
		passwordtxtfield.setColumns(10);
		passwordtxtfield.setBounds(404, 147, 124, 30);
		panel.add(passwordtxtfield);

		JButton btnajouter = new JButton("Confirmer les informations");
		btnajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
String sql = "insert into Personnes ( nom , prenom , loginconnexion , motdepasse , statut ) values ( ? , ? , ? , ? , ? )" ;
				
				try {
					prepared = cnx.prepareStatement(sql);
					prepared.setString(1, nomtxtfield.getText().toString());
					prepared.setString(2, prenomtxtfield.getText().toString());
					prepared.setString(3, usernametxtfield.getText().toString());
					prepared.setString(4, passwordtxtfield.getText().toString());
					prepared.setString(5, statuttxtfield.getText().toString());
					prepared.execute();
					
					JOptionPane.showMessageDialog(null, "Inscription effectuée avec succès");
					
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
			}
		});
		btnajouter.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\check_ok_accept_apply_1582.png"));
		btnajouter.setFont(new Font("Calibri", Font.BOLD, 20));
		btnajouter.setBounds(136, 226, 334, 42);
		panel.add(btnajouter);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\library_icon_149727(1).png"));
		lblNewLabel_3.setBounds(10, 11, 48, 45);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\library_icon_149727(1).png"));
		lblNewLabel_3_1.setBounds(506, 11, 48, 45);
		panel.add(lblNewLabel_3_1);
	}
}
