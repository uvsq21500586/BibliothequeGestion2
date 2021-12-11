package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import graphique.Catalogue;
import net.proteanit.sql.DbUtils;

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

	public static void afficherDocument(String query) {
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				Catalogue.tableDocuments.setModel(DbUtils.resultSetToTableModel(rs));
				Catalogue.tableDocumentsVide = false;
			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				Catalogue.tableDocuments.setModel(model);
				Catalogue.tableDocumentsVide = true;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}

	}

}
