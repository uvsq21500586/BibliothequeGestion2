package testY;

import connexion.AccesJDBC;
import graphique.NouveauMessage;

public class MainYMessage {
	static String chaineconnexionJDBC = "jdbc:sqlserver://LAPTOP-DO4863GA\\SQLEXPRESS;" + "databaseName=Pgi;"
			+ "user=sa;password=sa";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesJDBC.initialiser(chaineconnexionJDBC);
		NouveauMessage.idExpediteur = 1;
		NouveauMessage.main(null);

	}
}
