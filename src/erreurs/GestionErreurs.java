package erreurs;

import javax.swing.JOptionPane;

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
		if (dateString.length() != 8)
			return false;
		if (!(Character.isDigit(dateString.charAt(0)) || Character.isDigit(dateString.charAt(1))
				|| Character.isDigit(dateString.charAt(3)) || Character.isDigit(dateString.charAt(4))
				|| Character.isDigit(dateString.charAt(6)) || Character.isDigit(dateString.charAt(7))))
			return false;
		if (dateString.charAt(2) != '/' || dateString.charAt(5) != '/')
			return false;
		return true;
	}

}
