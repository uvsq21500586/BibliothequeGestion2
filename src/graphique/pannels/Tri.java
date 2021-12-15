package graphique.pannels;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import graphique.Catalogue;

@SuppressWarnings("serial")
public class Tri extends JPanel {

	private int id;
	private String trichoisi;
	static private int hauteur = 50;
	static private int hauteur2 = 55;
	private JButton buttonSupprimer;
	private JComboBox<String> ordre;

	public Tri(Catalogue catalogue, JPanel panelTris, int id, String trichoisi) {
		super();
		this.id = id;
		this.trichoisi = trichoisi;
		panelTris.add(this);
		setLayout(null);
		placerPanel();
		setBackground(new Color(90, 128, 216));
		setBorder(new TitledBorder(null, trichoisi, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ajoutComposants();
		placerComposants();
		ImageIcon image = new ImageIcon((new ImageIcon("images/annuler.png")).getImage()
				.getScaledInstance(buttonSupprimer.getHeight(), buttonSupprimer.getHeight(), Image.SCALE_DEFAULT));
		buttonSupprimer.setIcon(image);
		Tri tri = this;
		buttonSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTris.remove(tri);
				Catalogue.listetris.remove(tri.id);

				for (int i = id; i < Catalogue.listetris.size(); i++) {
					Tri tridecale = Catalogue.listetris.get(i);
					tridecale.setId(i);
					tridecale.placerPanel();
				}
				panelTris.revalidate();
				panelTris.repaint();
				Catalogue.afficherDocuments();
			}
		});

	}

	public void ajoutComposants() {
		buttonSupprimer = new JButton();
		add(buttonSupprimer);
	}

	public void placerComposants() {
		buttonSupprimer.setBounds(135, 15, 20, 20);
	}

	public void placerPanel() {
		setBounds(10, 50 + hauteur2 * id, 160, hauteur);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrichoisi() {
		return trichoisi;
	}

	public void setTrichoisi(String trichoisi) {
		this.trichoisi = trichoisi;
	}

	public static int getHauteur() {
		return hauteur;
	}

	public static void setHauteur(int hauteur) {
		Tri.hauteur = hauteur;
	}

	public static int getHauteur2() {
		return hauteur2;
	}

	public static void setHauteur2(int hauteur2) {
		Tri.hauteur2 = hauteur2;
	}

	public JButton getButtonSupprimer() {
		return buttonSupprimer;
	}

	public void setButtonSupprimer(JButton buttonSupprimer) {
		this.buttonSupprimer = buttonSupprimer;
	}

	public JComboBox<String> getOrdre() {
		return ordre;
	}

	public void setOrdre(JComboBox<String> ordre) {
		this.ordre = ordre;
	}

}
