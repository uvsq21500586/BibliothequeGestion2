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

}
