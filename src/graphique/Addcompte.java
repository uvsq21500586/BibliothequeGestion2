package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Addcompte {

	public JFrame frmInscription;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		frmInscription.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInscription.getContentPane().setLayout(null);

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

		JLabel lblAdresse = new JLabel("E-Mail");
		lblAdresse.setBounds(0, 0, 100, 30);
		panel_3.add(lblAdresse);
		lblAdresse.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdresse.setFont(new Font("Calibri", Font.BOLD, 14));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(10, 171, 100, 30);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNumeroDeTel = new JLabel("Numero de Tel");
		lblNumeroDeTel.setBounds(0, 0, 100, 30);
		panel_4.add(lblNumeroDeTel);
		lblNumeroDeTel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeTel.setFont(new Font("Calibri", Font.BOLD, 14));

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

		textField = new JTextField();
		textField.setBounds(120, 67, 124, 30);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 102, 124, 30);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 137, 124, 30);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(120, 171, 124, 30);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(404, 85, 124, 30);
		panel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(404, 147, 124, 30);
		panel.add(textField_5);

		JButton btnNewButton = new JButton("Confirmer les informations");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\check_ok_accept_apply_1582.png"));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton.setBounds(136, 226, 334, 42);
		panel.add(btnNewButton);

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
