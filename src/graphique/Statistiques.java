package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import connexion.AccesJDBC;

public class Statistiques {

	public JFrame frmStatistiques;
	private JComboBox<String> comboBoxTypedocument;
	private ChartFrame chartFrm;

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
		frmStatistiques.setBounds(100, 100, 290, 300);
		frmStatistiques.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStatistiques.getContentPane().setLayout(null);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStatistiques.dispose();
			}
		});
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

		comboBoxTypedocument = new JComboBox<String>();
		comboBoxTypedocument.setBounds(118, 10, 114, 21);
		frmStatistiques.getContentPane().add(comboBoxTypedocument);
		comboBoxTypedocument.addItem("Livre");
		comboBoxTypedocument.addItem("Dictionnaire");
		comboBoxTypedocument.addItem("Revue");
		comboBoxTypedocument.addItem("Video");
		comboBoxTypedocument.addItem("Audio");
		comboBoxTypedocument.addItem("Bd");
		comboBoxTypedocument.addItem("Volume");
		comboBoxTypedocument.addItem("Journal");
		chartFrm = new ChartFrame("stat4", null);

		/*
		 * panelGraphe.add(chartFrm); chartFrm.setBounds(5, 5, panelGraphe.getWidth() -
		 * 10, panelGraphe.getHeight() - 10);
		 */

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

		radioButtonNbDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonNbEmprunts.setSelected(false);
			}
		});
		radioButtonNbEmprunts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radioButtonNbDocuments.setSelected(false);
			}
		});
		buttonAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherHistogramme();
			}
		});
	}

	public int[] recherchethemes() {
		String query = "select id from Themes where id in (\r\n"
				+ "select idTheme from DocumentTheme where idDocument in (\r\n"
				+ "select id from Documents where typedocument = '" + comboBoxTypedocument.getSelectedItem() + "'))";
		return AccesJDBC.rechercheTheme(query);
	}

	public void afficherHistogramme() {
		int[] tabIdThemes = recherchethemes();
		if (tabIdThemes != null) {
			int[] tabResultats = new int[tabIdThemes.length];
			for (int i = 0; i < tabIdThemes.length; i++) {
				String query = "select count(*) from DocumentTheme where idTheme = " + tabIdThemes[i]
						+ " and idDocument in (" + "select id from Documents where typedocument = '"
						+ comboBoxTypedocument.getSelectedItem() + "')";
				System.out.println("requete count: " + query);

				tabResultats[i] = AccesJDBC.compter(query);
			}
			System.out.println();

			// construction des histogrammes
			DefaultCategoryDataset dcd = new DefaultCategoryDataset();
			for (int i = 0; i < tabIdThemes.length; i++) {
				String query = "select nom from Themes where id = " + tabIdThemes[i];
				dcd.setValue(tabResultats[i], "nb docs", AccesJDBC.trouverNom(query));
			}
			JFreeChart jchart = ChartFactory.createBarChart(comboBoxTypedocument.getSelectedItem().toString(), "thèmes",
					"nombre", dcd);
			chartFrm = new ChartFrame("stat4", jchart);
			chartFrm.setVisible(true);
			chartFrm.setSize(500, 400);

		} else {
			System.out.println("tableau de themes vide");

		}
	}
}
