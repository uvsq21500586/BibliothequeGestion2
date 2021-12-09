package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Authentification {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kadir\\Downloads\\library_icon_149727(1).png"));
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

		textField = new JTextField();
		textField.setBounds(148, 73, 119, 20);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(148, 117, 119, 20);
		panel.add(textField_1);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(72, 61, 139));
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(143, 151, 120, 30);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JButton btnNewButton = new JButton("Se connecter");
		btnNewButton.setBounds(0, 0, 120, 30);
		panel_3.add(btnNewButton);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(165, 42, 42));
		panel_4.setBounds(131, 262, 136, 27);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton_1 = new JButton("Cr\u00E9er un compte");
		btnNewButton_1.setBounds(0, 0, 136, 27);
		panel_4.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));

		JButton btnNewButton_1_1 = new JButton("Notre Catalogue");
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(21, 198, 136, 27);
		panel.add(btnNewButton_1_1);
		frame.setBounds(100, 100, 313, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
