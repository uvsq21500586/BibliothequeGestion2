package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class AjoutDoc {

	public JFrame frame;
	private JTextField txtAuteur;
	private JTextField txtTitre;
	private JTextField txtAnnee;
	private JTextField txtTypeDoc;
	private JTextField txtGenre;
	private JTextField txtEdition;
	private JTextField txtClassification;
	private JTextField textRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutDoc window = new AjoutDoc();
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
	public AjoutDoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 1158, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnAjouterDoc = new JButton("Ajouter un document");
		btnAjouterDoc.setForeground(Color.GREEN);
		btnAjouterDoc.setBackground(Color.LIGHT_GRAY);
		btnAjouterDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAjouterDoc.setBounds(61, 37, 204, 62);
		frame.getContentPane().add(btnAjouterDoc);

		JButton btnSupprimerDoc = new JButton("Supprimer un document");
		btnSupprimerDoc.setForeground(Color.RED);
		btnSupprimerDoc.setBackground(Color.LIGHT_GRAY);
		btnSupprimerDoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSupprimerDoc.setBounds(305, 37, 204, 62);
		frame.getContentPane().add(btnSupprimerDoc);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setForeground(new Color(192, 192, 192));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(20, 109, 877, 559);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtAuteur = new JTextField();
		txtAuteur.setToolTipText("");
		txtAuteur.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtAuteur.setBackground(new Color(211, 211, 211));
		txtAuteur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAuteur.setBounds(10, 48, 150, 52);
		txtAuteur.setText("Auteur");
		panel.add(txtAuteur);
		txtAuteur.setColumns(15);

		JList list = new JList();
		list.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), null));
		list.setBounds(234, 48, 633, 503);
		panel.add(list);

		txtTitre = new JTextField();
		txtTitre.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtTitre.setBackground(new Color(211, 211, 211));
		txtTitre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTitre.setBounds(10, 110, 150, 52);
		txtTitre.setText("Titre");
		txtTitre.setColumns(15);
		panel.add(txtTitre);

		txtAnnee = new JTextField();
		txtAnnee.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtAnnee.setBackground(new Color(211, 211, 211));
		txtAnnee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAnnee.setBounds(10, 172, 150, 52);
		txtAnnee.setText("Ann\u00E9e de publication");
		txtAnnee.setColumns(15);
		panel.add(txtAnnee);

		txtEdition = new JTextField();
		txtEdition.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtEdition.setBackground(new Color(211, 211, 211));
		txtEdition.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEdition.setBounds(10, 234, 150, 52);
		txtEdition.setText("Editeur");
		txtEdition.setColumns(15);
		panel.add(txtEdition);

		txtGenre = new JTextField();
		txtGenre.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtGenre.setBackground(new Color(211, 211, 211));
		txtGenre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGenre.setBounds(10, 295, 150, 52);
		txtGenre.setText("Genre");
		txtGenre.setColumns(15);
		panel.add(txtGenre);

		txtTypeDoc = new JTextField();
		txtTypeDoc.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtTypeDoc.setBackground(new Color(211, 211, 211));
		txtTypeDoc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTypeDoc.setBounds(10, 357, 150, 52);
		txtTypeDoc.setText("Type de document");
		txtTypeDoc.setColumns(15);
		panel.add(txtTypeDoc);

		txtClassification = new JTextField();
		txtClassification.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		txtClassification.setBackground(new Color(211, 211, 211));
		txtClassification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClassification.setBounds(10, 423, 150, 52);
		txtClassification.setText("Classification");
		txtClassification.setColumns(15);
		panel.add(txtClassification);

		JLabel lblNewLabel = new JLabel("Recherche :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(394, 3, 103, 37);
		panel.add(lblNewLabel);

		textRecherche = new JTextField();
		textRecherche.setBounds(492, 10, 292, 28);
		panel.add(textRecherche);
		textRecherche.setColumns(10);
	}
}
