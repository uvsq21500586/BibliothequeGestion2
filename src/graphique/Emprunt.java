package graphique;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Emprunt {

	public JFrame GESTON_EMPRUNTS;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprunt window = new Emprunt();
					window.GESTON_EMPRUNTS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Emprunt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GESTON_EMPRUNTS = new JFrame();
		GESTON_EMPRUNTS.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		GESTON_EMPRUNTS.setTitle("                                                           GESTON_EMPRUNTS");
		GESTON_EMPRUNTS.setBounds(100, 100, 768, 367);
		GESTON_EMPRUNTS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GESTON_EMPRUNTS.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Emprunt des documents");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(49, 11, 288, 43);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("IdAbonn\u00E9");
		lblNewLabel_1.setBounds(81, 85, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Document");
		lblNewLabel_1_1.setBounds(81, 145, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1_1);

		JLabel lblRetourDesDocuments = new JLabel("Retour des documents");
		lblRetourDesDocuments.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblRetourDesDocuments.setBounds(416, 11, 288, 43);
		GESTON_EMPRUNTS.getContentPane().add(lblRetourDesDocuments);

		JLabel lblNewLabel_1_2 = new JLabel("IdAbonn\u00E9 ");
		lblNewLabel_1_2.setBounds(434, 85, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("Document");
		lblNewLabel_1_1_1.setBounds(434, 133, 70, 14);
		GESTON_EMPRUNTS.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(121, 170, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.setBounds(512, 170, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_1);

		textField = new JTextField();
		textField.setBounds(135, 82, 97, 23);
		GESTON_EMPRUNTS.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(504, 82, 97, 23);
		GESTON_EMPRUNTS.getContentPane().add(textField_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(135, 141, 111, 22);
		GESTON_EMPRUNTS.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(490, 129, 111, 22);
		GESTON_EMPRUNTS.getContentPane().add(comboBox_1);

		JPanel panel = new JPanel();
		panel.setBounds(59, 65, 308, 187);
		GESTON_EMPRUNTS.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(416, 65, 308, 187);
		GESTON_EMPRUNTS.getContentPane().add(panel_1);

		JButton btnNewButton_2 = new JButton("Requetes");
		btnNewButton_2.setBounds(135, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("Documents");
		btnNewButton_2_1.setBounds(342, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1);

		JButton btnNewButton_2_1_1 = new JButton("Abonn\u00E9s");
		btnNewButton_2_1_1.setBounds(553, 294, 89, 23);
		GESTON_EMPRUNTS.getContentPane().add(btnNewButton_2_1_1);
	}
}
