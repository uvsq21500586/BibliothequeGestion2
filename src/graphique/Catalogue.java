package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import connexion.AccesJDBC;
import erreurs.GestionErreurs;
import graphique.pannels.Filtre;
import graphique.pannels.Tri;

public class Catalogue {

	public String statut = "adherant";

	public JFrame frameCatalogue;
	public static JTable tableDocuments;
	private JButton buttonAjoutFiltre;
	private JButton buttonRetour;
	private JPanel panelFiltres;
	private JPanel panelTri;
	private JButton buttonAjoutTri;
	private JButton buttonEmprunter;
	private JButton buttonModifier;
	public int nbfiltres;
	public static ArrayList<Filtre> listeFiltres;
	public static ArrayList<Tri> listetris;
	public static boolean tableDocumentsVide = true;
	private static JCheckBox checkBoxSousTitre;
	private static JCheckBox checkBoxTypeDocument;
	private static JCheckBox checkBoxTitre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Catalogue window = new Catalogue();
					window.frameCatalogue.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Catalogue() {
		nbfiltres = 0;
		listeFiltres = new ArrayList<Filtre>();
		listetris = new ArrayList<Tri>();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCatalogue = new JFrame();
		frameCatalogue.getContentPane().setBackground(new Color(135, 206, 250));
		frameCatalogue.getContentPane().setLayout(null);

		JLabel labelListeDocuments = new JLabel("Liste des documents");
		labelListeDocuments.setBounds(400, 10, 259, 13);
		frameCatalogue.getContentPane().add(labelListeDocuments);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 33, 259, 251);
		frameCatalogue.getContentPane().add(scrollPane);

		tableDocuments = new JTable();

		scrollPane.setViewportView(tableDocuments);

		buttonRetour = new JButton("Retour");
		buttonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameCatalogue.dispose();
				// Menu.main(null);
			}
		});
		buttonRetour.setBounds(10, 263, 120, 21);
		frameCatalogue.getContentPane().add(buttonRetour);
		ImageIcon image = new ImageIcon((new ImageIcon("images/retour.png")).getImage()
				.getScaledInstance(buttonRetour.getHeight(), buttonRetour.getHeight(), Image.SCALE_DEFAULT));
		buttonRetour.setIcon(image);

		panelFiltres = new JPanel();
		panelFiltres.setBackground(new Color(100, 149, 237));
		panelFiltres.setBorder(new TitledBorder(null, "Filtres", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelFiltres.setBounds(10, 10, 180, 243);
		frameCatalogue.getContentPane().add(panelFiltres);
		panelFiltres.setLayout(null);

		buttonAjoutFiltre = new JButton("Ajouter un filtre");
		Catalogue catalogue = this;
		buttonAjoutFiltre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * JOptionPane.showMessageDialog(frameCatalogue,
				 * "Choisissez un filtre à ajouter:", "Choix filtre",
				 * JOptionPane.QUESTION_MESSAGE);
				 */
				String[] choixfiltres = { "titre", "soustitre", "typedocument" };
				String filtrechoisi = JOptionPane.showInputDialog(frameCatalogue, "Choisissez un filtre à ajouter:",
						"Choix filtre", JOptionPane.QUESTION_MESSAGE, null,
						// les possibilités
						choixfiltres, "titre").toString();
				System.out.println(filtrechoisi);
				Filtre filtre = new Filtre(catalogue, panelFiltres, listeFiltres.size(), filtrechoisi);
				listeFiltres.add(filtre);
				afficherDocuments();
			}
		});
		buttonAjoutFiltre.setBounds(15, 22, 150, 21);
		panelFiltres.add(buttonAjoutFiltre);

		panelTri = new JPanel();
		panelTri.setBackground(new Color(100, 149, 237));
		panelTri.setBorder(new TitledBorder(null, "Tris", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTri.setBounds(200, 10, 180, 243);
		frameCatalogue.getContentPane().add(panelTri);
		panelTri.setLayout(null);

		buttonAjoutTri = new JButton("Ajouter un tri");
		buttonAjoutTri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choixtris = { "titre", "soustitre", "typedocument" };
				String trichoisi = JOptionPane.showInputDialog(frameCatalogue, "Choisissez un tri à ajouter:",
						"Choix tri", JOptionPane.QUESTION_MESSAGE, null,
						// les possibilités
						choixtris, "titre").toString();
				System.out.println(trichoisi);
				if (!GestionErreurs.erreurTri(catalogue, trichoisi)) {
					Tri tri = new Tri(catalogue, panelTri, listetris.size(), trichoisi);
					listetris.add(tri);
					afficherDocuments();
				}

			}
		});
		buttonAjoutTri.setBounds(15, 21, 150, 21);
		panelTri.add(buttonAjoutTri);

		buttonEmprunter = new JButton("Emprunter");
		buttonEmprunter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdhérantEmprunt AdhérantEmprunt = new AdhérantEmprunt();
				AdhérantEmprunt.frmGestionemprunt.setVisible(true);
			}
		});
		buttonEmprunter.setBounds(266, 263, 120, 21);
		buttonEmprunter.setEnabled(false);
		frameCatalogue.getContentPane().add(buttonEmprunter);

		buttonModifier = new JButton("Modifier");
		buttonModifier.setBounds(136, 263, 120, 21);
		if (statut.equals("adherant")) {
			buttonModifier.setVisible(false);
		}
		frameCatalogue.getContentPane().add(buttonModifier);
		image = new ImageIcon((new ImageIcon("images/modifier.png")).getImage()
				.getScaledInstance(buttonModifier.getHeight(), buttonModifier.getHeight(), Image.SCALE_DEFAULT));
		buttonModifier.setIcon(image);

		JPanel panelColonnesAffichees = new JPanel();
		panelColonnesAffichees.setBackground(new Color(123, 104, 238));
		panelColonnesAffichees.setBorder(
				new TitledBorder(null, "Colonnes affich\u00E9es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelColonnesAffichees.setBounds(669, 10, 157, 274);
		frameCatalogue.getContentPane().add(panelColonnesAffichees);
		panelColonnesAffichees.setLayout(null);

		checkBoxTitre = new JCheckBox("Titre");
		checkBoxTitre.setSelected(true);
		checkBoxTitre.setBounds(6, 19, 145, 21);
		panelColonnesAffichees.add(checkBoxTitre);
		checkBoxTitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDocuments();
			}
		});

		checkBoxSousTitre = new JCheckBox("Sous-titre");
		checkBoxSousTitre.setSelected(true);
		checkBoxSousTitre.setBounds(6, 54, 145, 21);
		panelColonnesAffichees.add(checkBoxSousTitre);
		checkBoxSousTitre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDocuments();
			}
		});

		checkBoxTypeDocument = new JCheckBox("Type de document");
		checkBoxTypeDocument.setSelected(true);
		checkBoxTypeDocument.setBounds(6, 89, 145, 21);
		panelColonnesAffichees.add(checkBoxTypeDocument);
		checkBoxTypeDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				afficherDocuments();
			}
		});

		frameCatalogue.setTitle("Catalogue");
		frameCatalogue.setBounds(100, 100, 850, 331);
		frameCatalogue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tableDocuments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (statut.equals("adherant")) {
					buttonEmprunter.setEnabled(true);
				}
			}
		});

		afficherDocuments();
	}

	public static void afficherDocuments() {
		/*
		 * String connectionstring = "jdbc:sqlserver://LAPTOP-DO4863GA\\SQLEXPRESS;" +
		 * "databaseName=Pgi;" + "user=sa;password=sa"; Connection con = null; try { con
		 * = DriverManager.getConnection(connectionstring);
		 * System.out.println("Connection reussie"); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 * 
		 * Statement stm = null; try { stm = con.createStatement();
		 * System.out.println("Statement reussi"); } catch (SQLException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 */

		String query = "select id";
		if (checkBoxTitre.isSelected()) {
			query = query + ", titre";
		}
		if (checkBoxSousTitre.isSelected()) {
			query = query + ", soustitre";
		}
		if (checkBoxTypeDocument.isSelected()) {
			query = query + ", typedocument";
		}

		query = query + " from Documents";
		if (listeFiltres.size() > 0) {
			// filtres
			query = query + " where ";
			for (int i = 0; i < listeFiltres.size(); i++) {
				Filtre f = listeFiltres.get(i);
				query = query + f.getFiltrechoisi() + " " + f.valeur();
				if (i < listeFiltres.size() - 1) {
					query = query + " and ";
				}
			}
		}
		if (listetris.size() > 0) {
			query = query + " order by ";
			for (int i = 0; i < listetris.size(); i++) {
				Tri t = listetris.get(i);
				query = query + t.getTrichoisi();
				if (i < listetris.size() - 1) {
					query = query + ", ";
				}
			}
		}
		System.out.println("query= " + query);
		AccesJDBC.afficherDocument(query);
	}
}
