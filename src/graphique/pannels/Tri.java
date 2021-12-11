package graphique.pannels;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Tri extends JPanel {

	private int id;
	private String trichoisi;
	static private int hauteur = 50;
	static private int hauteur2 = 55;
	private JButton buttonSupprimer;
	private JComboBox<String> ordre;

	public Tri(int id, String trichoisi) {
		super();
		this.id = id;
		this.trichoisi = trichoisi;
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
