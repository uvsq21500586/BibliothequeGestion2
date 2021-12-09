package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesJDBC {
	public static Connection con;
	public static Statement stm;
	/*
	 * cryptage String cryptedPassword = "";
	 * 
	 * try { cryptedPassword = Crypteur.encrypt(passwordString,
	 * Crypteur.createSecretKey(passwordField.getPassword())); } catch
	 * (UnsupportedEncodingException | GeneralSecurityException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); }
	 */

	public static void initialiser(String chaineConnexion) {
		con = null;
		try {
			con = DriverManager.getConnection(chaineConnexion);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		stm = null;
		try {
			stm = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
