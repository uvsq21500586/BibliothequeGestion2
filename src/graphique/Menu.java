package graphique;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Menu {

	public String statut = "adherant";

	public JFrame frameMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	public Menu(String statut) {
		this.statut = statut;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMenu = new JFrame();
		frameMenu.getContentPane().setBackground(new Color(127, 255, 212));
		frameMenu.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(121, 10, 121, 23);
		frameMenu.getContentPane().add(lblNewLabel);

		JButton buttonCatalogue = new JButton("Catalogue");

		buttonCatalogue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Catalogue cat = new Catalogue();
				cat.frameCatalogue.setVisible(true);
			}
		});
		buttonCatalogue.setBounds(10, 59, 150, 21);
		frameMenu.getContentPane().add(buttonCatalogue);
		ImageIcon image = new ImageIcon((new ImageIcon("images/catalogue.png")).getImage()
				.getScaledInstance(buttonCatalogue.getHeight(), buttonCatalogue.getHeight(), Image.SCALE_DEFAULT));
		buttonCatalogue.setIcon(image);

		JButton buttonMessages = new JButton("Messages");
		buttonMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Messagerie me = new Messagerie();
				me.frameMessagerie.setVisible(true);

			}
		});
		buttonMessages.setBounds(10, 152, 150, 21);
		frameMenu.getContentPane().add(buttonMessages);
		image = new ImageIcon((new ImageIcon("images/messagerie.png")).getImage()
				.getScaledInstance(buttonMessages.getHeight(), buttonMessages.getHeight(), Image.SCALE_DEFAULT));
		buttonMessages.setIcon(image);
		JButton buttonStatistiques = new JButton("Statistiques");
		buttonStatistiques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistiques Se = new Statistiques();
				Se.frmStatistiques.setVisible(true);
			}
		});
		buttonStatistiques.setBounds(10, 90, 150, 21);
		frameMenu.getContentPane().add(buttonStatistiques);
		image = new ImageIcon((new ImageIcon("images/statistique.png")).getImage().getScaledInstance(
				buttonStatistiques.getHeight(), buttonStatistiques.getHeight(), Image.SCALE_DEFAULT));
		buttonStatistiques.setIcon(image);

		JButton buttonEmprunts = new JButton("Emprunts");

		buttonEmprunts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (statut.equals("adherant")) {
					AdhérantEmprunt adherentEmprunt = new AdhérantEmprunt();
					adherentEmprunt.frmGestionemprunt.setVisible(true);
				} else {
					Emprunt emprunt = new Emprunt();
					emprunt.GESTON_EMPRUNTS.setVisible(true);
				}
			}
		});

		buttonEmprunts.setBounds(10, 121, 150, 21);
		frameMenu.getContentPane().add(buttonEmprunts);

		JButton buttonDeconnexion = new JButton("Déconnexion");
		buttonDeconnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameMenu.dispose();
				Authentification.main(null);
			}
		});
		buttonDeconnexion.setMargin(new Insets(2, 5, 2, 5));
		buttonDeconnexion.setBounds(276, 232, 150, 21);
		frameMenu.getContentPane().add(buttonDeconnexion);
		image = new ImageIcon((new ImageIcon("images/deconnexion.png")).getImage()
				.getScaledInstance(buttonDeconnexion.getHeight(), buttonDeconnexion.getHeight(), Image.SCALE_DEFAULT));
		buttonDeconnexion.setIcon(image);

		JPanel panelGerant = new JPanel();
		panelGerant.setBorder(
				new TitledBorder(null, "Gérant uniquement", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGerant.setBackground(new Color(102, 205, 170));
		panelGerant.setBounds(211, 47, 215, 100);
		frameMenu.getContentPane().add(panelGerant);
		panelGerant.setLayout(null);
		if (statut.equals("adherant")) {
			panelGerant.setVisible(false);
		}
		JButton buttonGestionLogins = new JButton("Gestion logins");
		buttonGestionLogins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gérant fenetreGerant = new Gérant();
				fenetreGerant.frmGestions.setVisible(true);
			}
		});
		buttonGestionLogins.setBounds(20, 22, 185, 21);
		panelGerant.add(buttonGestionLogins);

		JButton buttonGestionDocuments = new JButton("Gestion des documents");
		buttonGestionDocuments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjoutDoc fenetreGerant = new AjoutDoc();
				fenetreGerant.frame.setVisible(true);
			}
		});
		buttonGestionDocuments.setBounds(20, 62, 185, 21);
		panelGerant.add(buttonGestionDocuments);
		frameMenu.setTitle("Menu");
		frameMenu.setBounds(100, 100, 450, 300);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
