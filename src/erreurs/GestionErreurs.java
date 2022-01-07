package erreurs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import graphique.AjoutDoc;
import graphique.Catalogue;

public class GestionErreurs {

	public static boolean erreurTri(Catalogue catalogue, String nomTri) {
		for (int i = 0; i < Catalogue.listetris.size(); i++) {
			if (Catalogue.listetris.get(i).getTrichoisi().equals(nomTri)) {
				JOptionPane.showMessageDialog(catalogue.frameCatalogue,
						"Vous ne pouvez pas ajouter 2 fois le même tri.", "Erreur tri", JOptionPane.ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	public static boolean formatDate(String dateString) {
		// vérifier que la date est écrite sous la forme dd/mm/aa
		if (dateString.length() != 8) {
			return false;
		}
		if (!(Character.isDigit(dateString.charAt(0)) || Character.isDigit(dateString.charAt(1))
				|| Character.isDigit(dateString.charAt(3)) || Character.isDigit(dateString.charAt(4))
				|| Character.isDigit(dateString.charAt(6)) || Character.isDigit(dateString.charAt(7)))) {
			return false;
		}
		if (dateString.charAt(2) != '/' || dateString.charAt(5) != '/') {
			return false;
		}
		return true;
	}

	public static boolean formatDate(String dateString, JFrame frame) {
		// vérifier que la date est écrite sous la forme dd/mm/aa
		if (dateString.length() != 8) {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!(Character.isDigit(dateString.charAt(0)) || Character.isDigit(dateString.charAt(1))
				|| Character.isDigit(dateString.charAt(3)) || Character.isDigit(dateString.charAt(4))
				|| Character.isDigit(dateString.charAt(6)) || Character.isDigit(dateString.charAt(7)))) {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (dateString.charAt(2) != '/' || dateString.charAt(5) != '/') {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean formatDate2(String dateString, JFrame frame) {
		// vérifier que la date est écrite sous la forme dd/mm/aa
		if (dateString.length() != 10) {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yyyy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (!(Character.isDigit(dateString.charAt(0)) || Character.isDigit(dateString.charAt(1))
				|| Character.isDigit(dateString.charAt(3)) || Character.isDigit(dateString.charAt(4))
				|| Character.isDigit(dateString.charAt(6)) || Character.isDigit(dateString.charAt(7))
				|| Character.isDigit(dateString.charAt(8)) || Character.isDigit(dateString.charAt(9)))) {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yyyy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (dateString.charAt(2) != '/' || dateString.charAt(5) != '/') {
			JOptionPane.showMessageDialog(frame, "La date doit être de la forme dd/mm/yyyy.", "Erreur format date",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	public static boolean titreDocument(String champtitre) {
		if (champtitre.equals("")) {

			JOptionPane.showMessageDialog(AjoutDoc.frame, "Vous devez au moins renseigner le titre.",
					"Erreur titre ajout document", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
