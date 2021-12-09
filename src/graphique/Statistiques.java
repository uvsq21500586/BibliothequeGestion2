package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Statistiques {

	public JFrame frmStatistiques;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistiques window = new Statistiques();
					window.frmStatistiques.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Statistiques() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStatistiques = new JFrame();
		frmStatistiques.getContentPane().setBackground(new Color(0, 0, 128));
		frmStatistiques.setTitle("Statistiques");
		frmStatistiques.setBounds(100, 100, 650, 300);
		frmStatistiques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistiques.getContentPane().setLayout(null);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.setBounds(40, 232, 160, 21);
		frmStatistiques.getContentPane().add(buttonRetour);
		ImageIcon image = new ImageIcon((new ImageIcon("images/retour.png")).getImage()
				.getScaledInstance(buttonRetour.getHeight(), buttonRetour.getHeight(), Image.SCALE_DEFAULT));
		buttonRetour.setIcon(image);

		JLabel labelTypesDocument = new JLabel("Type de document");
		labelTypesDocument.setForeground(new Color(255, 255, 255));
		labelTypesDocument.setBounds(10, 10, 114, 21);
		frmStatistiques.getContentPane().add(labelTypesDocument);

		JButton buttonAfficher = new JButton("Afficher");
		buttonAfficher.setBounds(40, 190, 160, 21);
		frmStatistiques.getContentPane().add(buttonAfficher);
		image = new ImageIcon((new ImageIcon("images/histogrammes.png")).getImage()
				.getScaledInstance(buttonAfficher.getHeight(), buttonAfficher.getHeight(), Image.SCALE_DEFAULT));
		buttonAfficher.setIcon(image);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(118, 10, 114, 21);
		frmStatistiques.getContentPane().add(comboBox);

		JPanel panelGraphe = new JPanel();
		panelGraphe.setBackground(new Color(0, 0, 255));
		panelGraphe.setForeground(new Color(0, 0, 0));
		panelGraphe.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Graphique",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelGraphe.setBounds(240, 10, 370, 243);
		frmStatistiques.getContentPane().add(panelGraphe);

		JRadioButton radioButtonNbDocuments = new JRadioButton("Nombre de documents");
		radioButtonNbDocuments.setSelected(true);
		radioButtonNbDocuments.setBackground(new Color(106, 90, 205));
		radioButtonNbDocuments.setForeground(new Color(255, 255, 255));
		radioButtonNbDocuments.setBounds(21, 47, 179, 21);
		frmStatistiques.getContentPane().add(radioButtonNbDocuments);

		JRadioButton radioButtonNbEmprunts = new JRadioButton("Nombre d'emprunts");
		radioButtonNbEmprunts.setBackground(new Color(106, 90, 205));
		radioButtonNbEmprunts.setForeground(new Color(255, 255, 255));
		radioButtonNbEmprunts.setBounds(21, 79, 179, 21);
		frmStatistiques.getContentPane().add(radioButtonNbEmprunts);
	}
}
