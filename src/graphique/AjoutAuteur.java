package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class AjoutAuteur {

	private JFrame frame;
	private JTextField prenom;
	private JTextField nom;
	private JTextField dateNaissance;
	private JTextField dateDeces;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutAuteur window = new AjoutAuteur();
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
	public AjoutAuteur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 1009, 757);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(23, 70, 456, 297);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(76, 123, 353, 31);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(514, 70, 456, 297);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnAjoutNa = new JButton("Ajouter");
		btnAjoutNa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ajout();
			}
		});
		btnAjoutNa.setForeground(new Color(0, 100, 0));
		btnAjoutNa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAjoutNa.setBounds(528, 393, 160, 49);
		frame.getContentPane().add(btnAjoutNa);

		// visibilité du panel + edition du combobox
		panel_1.setVisible(false);
		btnAjoutNa.setVisible(false);
		comboBox.setEditable(true);

		JCheckBox checkBox = new JCheckBox("Nouvel auteur");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()) {
					panel_1.setVisible(true);
					btnAjoutNa.setVisible(true);
					comboBox.setEditable(false);
				} else {
					panel_1.setVisible(false);
					btnAjoutNa.setVisible(false);
					comboBox.setEditable(true);
				}
			}

		});
		checkBox.setBounds(10, 16, 162, 38);
		panel.add(checkBox);
		checkBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));

		JLabel lblNewLabel_5_5_1_2_2 = new JLabel("Nom :");
		lblNewLabel_5_5_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5_5_1_2_2.setBounds(10, 123, 56, 31);
		panel.add(lblNewLabel_5_5_1_2_2);

		JLabel lblNewLabel_1_1 = new JLabel("Auteur existant");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(140, 50, 188, 43);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1 = new JLabel("Nouvel Auteur");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(140, 50, 188, 43);
		panel_1.add(lblNewLabel_1);

		prenom = new JTextField();
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		prenom.setColumns(10);
		prenom.setBounds(125, 163, 298, 28);
		panel_1.add(prenom);

		JLabel lblNewLabel_5_5_1_2_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_5_5_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_5_5_1_2_1.setBounds(20, 160, 103, 31);
		panel_1.add(lblNewLabel_5_5_1_2_1);

		JLabel lblNewLabel_5_5_1_2 = new JLabel("Nom");
		lblNewLabel_5_5_1_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_5_5_1_2.setBounds(20, 120, 103, 31);
		panel_1.add(lblNewLabel_5_5_1_2);

		nom = new JTextField();
		nom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nom.setColumns(10);
		nom.setBounds(125, 125, 298, 28);
		panel_1.add(nom);

		dateNaissance = new JTextField();
		dateNaissance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dateNaissance.setColumns(10);
		dateNaissance.setBounds(123, 201, 103, 28);
		panel_1.add(dateNaissance);

		JLabel lblNewLabel_5_5_1_1 = new JLabel("N\u00E9(e) le");
		lblNewLabel_5_5_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_5_5_1_1.setBounds(20, 201, 103, 31);
		panel_1.add(lblNewLabel_5_5_1_1);

		JLabel lblNewLabel_5_5_1_1_1 = new JLabel("Dec\u00E8s");
		lblNewLabel_5_5_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
		lblNewLabel_5_5_1_1_1.setBounds(246, 199, 72, 28);
		panel_1.add(lblNewLabel_5_5_1_1_1);

		dateDeces = new JTextField();
		dateDeces.setFont(new Font("Tahoma", Font.PLAIN, 17));
		dateDeces.setColumns(10);
		dateDeces.setBounds(320, 203, 103, 28);
		panel_1.add(dateDeces);

		JLabel lblNewLabel = new JLabel("Ajout d'auteur(s)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(107, 10, 770, 38);
		frame.getContentPane().add(lblNewLabel);

		JButton btnAjoutCb = new JButton("Ajouter");
		btnAjoutCb.setForeground(new Color(0, 100, 0));
		btnAjoutCb.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAjoutCb.setBounds(34, 393, 160, 49);
		frame.getContentPane().add(btnAjoutCb);

	}

	public void ajout() {

		String sql = "If Not Exists(select * from Auteurs where (nom,prenom,dateNaissance,dateDeces)='" + nom.getText()
				+ prenom.getText() + dateNaissance.getText() + dateDeces.getText()
				+ "' insert into Auteurs (nom,prenom,dateNaissance,dateDeces)" + "values ('" + nom.getText() + "','"
				+ prenom.getText() + "','" + dateNaissance.getText().toString() + "','" + dateDeces.getText().toString()
				+ "')";

		/*
		 * if (sql ) { JOptionPane.showMessageDialog(null, "Auteurs existant",
		 * "Erreur Auteur existant" , JOptionPane.INFORMATION_MESSAGE);
		 * 
		 * nom.setText(""); prenom.setText(""); dateNaissance.setText("");
		 * dateDeces.setText("");
		 */
	}

	// AccesJDBC.ajout(sql);

	public void AjoutCB() {
		String sql = "Select nom,prenom from Auteurs";

		// AccesJDBC.ajoutTest1(sql);
		// JComboBox.addItem(rs.getString("nom","prenom"));
	}
}