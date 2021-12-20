package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JPasswordField;

public class Authentification {

	
	protected static final Object Gerant = null;
	public JFrame frame;
	private JTextField usernamefield;
	
	Connection cnx = null ;
	PreparedStatement prepared = null ;
	ResultSet resultat = null ;
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
		cnx = Connexionsql.ConnexionDB();

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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kadir\\eclipse-gestion\\BibliothequeGestion2-main\\images\\bibliotheque.png"));
		lblNewLabel_1.setBounds(10, 58, 52, 116);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(218, 112, 214));
		panel_1.setBounds(72, 73, 60, 20);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 0, 60, 20);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(218, 112, 214));
		panel_2.setBounds(72, 117, 60, 20);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(0, 0, 60, 20);
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
				
					
			String sql = "select loginconnexion ,  motdepasse , statut from Personnes";
			try {
				
				prepared = cnx.prepareStatement(sql);
				resultat = prepared.executeQuery();
			int i =0 ;
			
			if (username.equals("") || password.equals(""))
			{
				JOptionPane.showInternalMessageDialog(null, "Remplissez les champs vides !");
			}else 
			{
				while(resultat.next())
				{
					String username1 = resultat.getString("loginconnexion");
					String password1 = resultat.getString("motdepasse");
					String statut1 = resultat.getString("statut");
					if(username1.equals(username) && password1.equals(password))
					{
						JOptionPane.showMessageDialog(null, "Connexion Reussite");
						
						if (statut1.equals("Gerant")|| statut1.equals("Adherant"));
						
						Menu window = new Menu(statut1);
						window.frameMenu.setVisible(true);
						
						}
						
						i=1;
					}
					
				}
					
					if (i== 0)
						JOptionPane.showMessageDialog(null, "Connexion Echouée");
				} 
			
			 
				
			
				
				
			catch (SQLException e1) {
				
				e1.printStackTrace();
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
		passwordField.setBounds(148, 117, 112, 20);
		panel.add(passwordField);
		frame.setBounds(100, 100, 313, 350);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
