package testS;

import connexion.AccesJDBC;
import graphique.Authentification;

public class MainS {

	static String chaineconnexionJDBC = "jdbc:sqlserver://LAPTOP-EBF20DRT\\SQLEXPRESS;" + "database=Pgi;" + "user=sa;"
			+ "password=sita;";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccesJDBC.initialiser(chaineconnexionJDBC);
		Authentification.main(null);

	}

}