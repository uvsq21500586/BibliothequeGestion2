package graphique;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdhérantEmprunt {

	public JFrame frmGestionemprunt;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdhérantEmprunt window = new AdhérantEmprunt();
					window.frmGestionemprunt.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdhérantEmprunt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionemprunt = new JFrame();
		frmGestionemprunt.setTitle("GESTION_EMPRUNT");
		frmGestionemprunt.setBounds(100, 100, 702, 349);
		frmGestionemprunt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionemprunt.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 44, 286, 209);
		frmGestionemprunt.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(10, 25, 46, 14);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(48, 22, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("V\u00E9rifier ");
		lblNewLabel_2.setBounds(10, 74, 46, 14);
		panel.add(lblNewLabel_2);

		table = new JTable();
		table.setBounds(50, 112, 226, 97);
		panel.add(table);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(48, 70, 97, 22);
		panel.add(comboBox_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(397, 44, 279, 209);
		frmGestionemprunt.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Rechercher");
		lblNewLabel_3.setBounds(10, 86, 55, 14);
		panel_1.add(lblNewLabel_3);

		textField_2 = new JTextField();
		textField_2.setBounds(75, 39, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		table_1 = new JTable();
		table_1.setBounds(43, 111, 226, 97);
		panel_1.add(table_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 82, 97, 22);
		panel_1.add(comboBox);

		JLabel lblNewLabel_4 = new JLabel("Nom");
		lblNewLabel_4.setBounds(10, 42, 46, 14);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("Documents disponibles ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(39, 11, 227, 22);
		frmGestionemprunt.getContentPane().add(lblNewLabel);

		JLabel lblDocumentsEmprunts = new JLabel("Documents emprunt\u00E9s");
		lblDocumentsEmprunts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDocumentsEmprunts.setBounds(417, 11, 227, 22);
		frmGestionemprunt.getContentPane().add(lblDocumentsEmprunts);

		JButton btnNewButton = new JButton("Abonn\u00E9 ");
		btnNewButton.setBounds(89, 276, 89, 23);
		frmGestionemprunt.getContentPane().add(btnNewButton);

		JButton btnEmprunt = new JButton("Emprunt");
		btnEmprunt.setBounds(296, 276, 89, 23);
		frmGestionemprunt.getContentPane().add(btnEmprunt);

		JButton btnNewButton_1_1 = new JButton("Document");
		btnNewButton_1_1.setBounds(477, 276, 89, 23);
		frmGestionemprunt.getContentPane().add(btnNewButton_1_1);
	}
}
