package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Gérant {

	public JFrame frmGestions;

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
		frmGestions.setBounds(100, 100, 629, 345);
		frmGestions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestions.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		panel.setBounds(0, 0, 603, 295);
		frmGestions.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("G\u00E9rant Uniquement");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_2.setBounds(10, 11, 583, 30);
		panel.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Afficher");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kadir\\OneDrive\\Bureau\\view_show_icon_124811.png"));
		btnNewButton.setBounds(20, 242, 123, 45);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\cog_icon_125002.png"));
		btnNewButton_1.setBounds(167, 242, 123, 45);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setIcon(new ImageIcon(
				"C:\\Users\\kadir\\Downloads\\delete_delete_deleteusers_delete_male_user_maleclient_2348.png"));
		btnNewButton_2.setBounds(316, 242, 123, 45);
		panel.add(btnNewButton_2);

		JButton btnEnvoyerUnMessage = new JButton("Envoyer");
		btnEnvoyerUnMessage.setIcon(new ImageIcon(
				"C:\\Users\\kadir\\Downloads\\1904660-email-envelope-letter-mail-message-post-send_122510.png"));
		btnEnvoyerUnMessage.setBounds(470, 242, 123, 45);
		panel.add(btnEnvoyerUnMessage);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 74, 572, 157);
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("Liste des Adh\u00E9rents abonn\u00E9s");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 49, 583, 23);
		panel.add(lblNewLabel);
	}
}
