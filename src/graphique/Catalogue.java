package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import graphique.pannels.Filtre;
import net.proteanit.sql.DbUtils;

public class Catalogue {

	public JFrame frameCatalogue;
	private static JTable tableDocuments;
	private JButton buttonAjoutFiltre;
	private JButton buttonRetour;
	private JPanel panelFiltres;
	private JPanel panelTri;
	private JButton buttonAjoutTri;
	private JButton buttonEmprunter;
	private JButton buttonModifier;
	public int nbfiltres;
	public ArrayList<Filtre> listeFiltres;
	public static boolean tableDocumentsVide = true;

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
				Menu.main(null);
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
						choixfiltres, "Titre").toString();
				System.out.println(filtrechoisi);
				Filtre filtre = new Filtre(catalogue, panelFiltres, listeFiltres.size(), filtrechoisi);
				listeFiltres.add(filtre);
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
		buttonAjoutTri.setBounds(15, 21, 150, 21);
		panelTri.add(buttonAjoutTri);

		buttonEmprunter = new JButton("Emprunter");
		buttonEmprunter.setBounds(266, 263, 120, 21);
		frameCatalogue.getContentPane().add(buttonEmprunter);

		buttonModifier = new JButton("Modifier");
		buttonModifier.setBounds(136, 263, 120, 21);
		frameCatalogue.getContentPane().add(buttonModifier);
		image = new ImageIcon((new ImageIcon("images/modifier.png")).getImage()
				.getScaledInstance(buttonModifier.getHeight(), buttonModifier.getHeight(), Image.SCALE_DEFAULT));
		buttonModifier.setIcon(image);

		frameCatalogue.setTitle("Catalogue");
		frameCatalogue.setBounds(100, 100, 700, 331);
		frameCatalogue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		afficherDocuments();
	}

	public static void afficherDocuments() {
		String connectionstring = "jdbc:sqlserver://LAPTOP-DO4863GA\\SQLEXPRESS;" + "databaseName=Pgi;"
				+ "user=sa;password=sa";
		Connection con = null;
		try {
			con = DriverManager.getConnection(connectionstring);
			System.out.println("Connection reussie");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Statement stm = null;
		try {
			stm = con.createStatement();
			System.out.println("Statement reussi");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String query = "select * from Documents";
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				tableDocuments.setModel(DbUtils.resultSetToTableModel(rs));
				tableDocumentsVide = false;
			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				tableDocuments.setModel(model);
				tableDocumentsVide = true;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}
	}
}
