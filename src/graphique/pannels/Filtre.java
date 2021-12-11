package graphique.pannels;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import graphique.Catalogue;

@SuppressWarnings("serial")
public class Filtre extends JPanel {

	private int id;
	private String filtrechoisi;
	static private int hauteur = 50;
	static private int hauteur2 = 55;
	private JButton buttonSupprimer;
	private JTextArea champ;
	private Catalogue catalogue;
	private JComboBox<String> listechoix;

	public Filtre(Catalogue catalogue, JPanel panelFiltres, int id, String filtrechoisi) {
		// TODO Auto-generated constructor stub
		this.setCatalogue(catalogue);
		this.id = id;
		this.filtrechoisi = filtrechoisi;
		panelFiltres.add(this);
		setLayout(null);
		placerPanel();
		setBackground(new Color(90, 128, 216));
		setBorder(new TitledBorder(null, filtrechoisi, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ajoutComposants();
		placerComposants();
		ImageIcon image = new ImageIcon((new ImageIcon("images/annuler.png")).getImage()
				.getScaledInstance(buttonSupprimer.getHeight(), buttonSupprimer.getHeight(), Image.SCALE_DEFAULT));
		buttonSupprimer.setIcon(image);
		Filtre filtre = this;
		buttonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelFiltres.remove(filtre);
				Catalogue.listeFiltres.remove(id);

				for (int i = id; i < Catalogue.listeFiltres.size(); i++) {
					Filtre filtredecale = Catalogue.listeFiltres.get(i);
					filtredecale.setId(i);
					filtredecale.placerPanel();
				}
				panelFiltres.revalidate();
				panelFiltres.repaint();
				Catalogue.afficherDocuments();
			}
		});
	}

	public void placerPanel() {
		setBounds(10, 50 + hauteur2 * id, 160, hauteur);
	}

	public void ajoutComposants() {
		buttonSupprimer = new JButton();
		add(buttonSupprimer);
		switch (filtrechoisi) {
		case "titre":
			champ = new JTextArea();
			add(champ);
			champ.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {

				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					Catalogue.afficherDocuments();
				}

			});
			break;
		case "soustitre":
			champ = new JTextArea();
			add(champ);
			champ.addKeyListener(new KeyListener() {

				@Override
				public void keyPressed(KeyEvent e) {

				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					Catalogue.afficherDocuments();
				}

			});
			break;
		case "typedocument":
			listechoix = new JComboBox<String>();
			add(listechoix);
			listechoix.addItem("Livre");
			listechoix.addItem("Dictionnaire");
			listechoix.addItem("Revue");
			listechoix.addItem("Video");
			listechoix.addItem("Audio");
			listechoix.addItem("Bd");
			listechoix.addItem("Volume");
			listechoix.addItem("Journal");
			listechoix.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Catalogue.afficherDocuments();
				}
			});
			break;
		}

	}

	public void placerComposants() {
		buttonSupprimer.setBounds(135, 15, 20, 20);
		switch (filtrechoisi) {
		case "titre":
			champ.setBounds(15, 15, 100, 20);
			break;
		case "soustitre":
			champ.setBounds(15, 15, 100, 20);
			break;
		case "typedocument":
			listechoix.setBounds(15, 15, 100, 20);
			break;
		}
	}

	public String valeur() {
		switch (filtrechoisi) {
		case "titre":
			return "like '" + champ.getText() + "%'";
		case "soustitre":
			return "like '" + champ.getText() + "%'";
		case "typedocument":
			return "= '" + listechoix.getSelectedItem().toString() + "'";
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getHauteur() {
		return hauteur;
	}

	public static void setHauteur(int hauteur) {
		Filtre.hauteur = hauteur;
	}

	public static int getHauteur2() {
		return hauteur2;
	}

	public static void setHauteur2(int hauteur2) {
		Filtre.hauteur2 = hauteur2;
	}

	public JButton getButtonSupprimer() {
		return buttonSupprimer;
	}

	public void setButtonSupprimer(JButton buttonSupprimer) {
		this.buttonSupprimer = buttonSupprimer;
	}

	public JTextArea getChamp() {
		return champ;
	}

	public void setChamp(JTextArea champ) {
		this.champ = champ;
	}

	public String getFiltrechoisi() {
		return filtrechoisi;
	}

	public void setFiltrechoisi(String filtrechoisi) {
		this.filtrechoisi = filtrechoisi;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public JComboBox<String> getListechoix() {
		return listechoix;
	}

	public void setListechoix(JComboBox<String> listechoix) {
		this.listechoix = listechoix;
	}

}
