package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import graphique.AdhérantEmprunt;
import graphique.AjoutDoc;
import graphique.Catalogue;
import net.proteanit.sql.DbUtils;
import operations.Operation;

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

	public static void AfficherTableMessages(String query, JTable Tablelistemessages) {

		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				Tablelistemessages.setModel(DbUtils.resultSetToTableModel(rs));
			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				Tablelistemessages.setModel(model);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Neant");
		}
	}

	public static void AfficherTablePersonnes(String query, JTable Tablelistemessages) {

		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				Tablelistemessages.setModel(DbUtils.resultSetToTableModel(rs));
			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				Tablelistemessages.setModel(model);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Neant");
		}
	}

	public static void afficherAuteurs(String query, AjoutDoc Afficher) {
		// utilisé pour la fenêtre AjoutDoc
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				Afficher.tableAuteurs.setModel(DbUtils.resultSetToTableModel(rs));

			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				Afficher.tableAuteurs.setModel(model);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}

	}

	public static void afficherEditeurs(String query, AjoutDoc Afficher) {
		// utilisé pour la fenêtre AjoutDoc
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				Afficher.tableEditeurs.setModel(DbUtils.resultSetToTableModel(rs));

			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				Afficher.tableEditeurs.setModel(model);

			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}

	}

	public static void afficherEmprunt(String query) {
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				AdhérantEmprunt.table_docsempruntes.setModel(DbUtils.resultSetToTableModel(rs));
			} else {
				// tableau vide
				String tabColumn[] = new String[rsmd.getColumnCount()];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					tabColumn[i] = rsmd.getColumnName(i + 1);
				}
				DefaultTableModel model = new DefaultTableModel(tabColumn, 0);
				AdhérantEmprunt.table_docsempruntes.setModel(model);
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}

	}

	public static void afficherDetailDocument(int iddoc, JTextPane description) {
		// afficher la description d'un seul document
		JTable document = new JTable();
		JTable auteurs = new JTable();
		String query = "select * from Documents where id = " + iddoc;
		String query2 = "select * from DocumentsAuteurs where idDocument = " + iddoc;
		String texte = "";
		try {
			ResultSet rs = stm.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			document.setModel(DbUtils.resultSetToTableModel(rs));
			ResultSet rs2 = stm.executeQuery(query2);
			auteurs.setModel(DbUtils.resultSetToTableModel(rs2));
			// id
			texte = texte + "id: " + iddoc + "\n";
			// titre
			texte = texte + "titre: " + document.getValueAt(0, 1) + "\n";
			// sous titre
			if (document.getValueAt(0, 2) != null) {
				texte = texte + "sous-titre: " + document.getValueAt(0, 2) + "\n";
			}
			if (document.getValueAt(0, 7).toString().equals("true")) {
				texte = texte + "disponible: non\n";
			} else {
				texte = texte + "disponible: oui\n";
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}
		description.setText(texte);

	}

	public static void listeChoix(String query, JComboBox<String> combobox) {
		// réinitialiser la liste avant de la mettre à jour
		combobox.removeAllItems();
		try {
			ResultSet rs = stm.executeQuery(query);
			// ResultSetMetaData rsmd = rs.getMetaData();

			if (rs.next()) {
				rs = stm.executeQuery(query);
				// remplissage du combobox
				JTable table = new JTable();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				for (int i = 0; i < table.getRowCount(); i++) {
					combobox.addItem(table.getValueAt(i, 0).toString());
				}
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
		}

	}

	public static int compter(String query) {
		// fonctionne pour des requêtes qui donnent un nombre entier
		try {
			ResultSet rs = stm.executeQuery(query);
			// ResultSetMetaData rsmd = rs.getMetaData();
			JTable resultat = new JTable();
			resultat.setModel(DbUtils.resultSetToTableModel(rs));
			System.out.println("rs: " + resultat.getValueAt(0, 0));
			return Integer.parseInt(resultat.getValueAt(0, 0).toString());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
			return -1;
		}
	}

	public static boolean booleen(String query) {
		// fonctionne pour des requêtes qui donnent un booleen
		try {
			ResultSet rs = stm.executeQuery(query);
			// ResultSetMetaData rsmd = rs.getMetaData();
			JTable resultat = new JTable();
			resultat.setModel(DbUtils.resultSetToTableModel(rs));
			System.out.println("rs: " + resultat.getValueAt(0, 0));
			if (resultat.getValueAt(0, 0).toString().equals("false")) {
				return false;
			} else {
				return true;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
			return false;
		}
	}

	public static String trouverNom(String query) {
		// fonctionne pour des requêtes qui donnent un nombre entier
		try {
			ResultSet rs = stm.executeQuery(query);
			// ResultSetMetaData rsmd = rs.getMetaData();
			JTable resultat = new JTable();
			resultat.setModel(DbUtils.resultSetToTableModel(rs));
			System.out.println("rs: " + resultat.getValueAt(0, 0));
			return resultat.getValueAt(0, 0).toString();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
			return null;
		}
	}

	public static void Edition(String query) {
		// fonctionne pour des requêtes qui donnent un nombre entier
		System.out.println(query);
		try {
			stm.executeQuery(query);

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static int[] rechercheTheme(String query) {
		try {
			ResultSet rs = stm.executeQuery(query);

			if (rs.next()) {
				rs = stm.executeQuery(query);
				JTable listeIdThemes = new JTable();
				listeIdThemes.setModel(DbUtils.resultSetToTableModel(rs));

				int tabColumn[] = new int[listeIdThemes.getRowCount()];
				for (int i = 0; i < listeIdThemes.getRowCount(); i++) {
					tabColumn[i] = Integer.parseInt(listeIdThemes.getValueAt(i, 0).toString());
				}
				return tabColumn;
			} else {
				// tableau vide
				return null;
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		} catch (NullPointerException e1) {
			System.out.println("Aucun document");
			return null;
		}

	}

	public static void miseAJourEmprunts() {
		String sql = "update Emprunts set etatEmprunt = 'perime'";
		String dateString = Operation.dateFormat(new Date());
		sql = sql + " where etatEmprunt <> 'rendu' and etatEmprunt <> 'ajourne' and dateLimite < '" + dateString + "'";
		try {
			stm.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sql = "update Emprunts set etatEmprunt = 'perime'";
		sql = sql + " where etatEmprunt = 'ajourne' and dateRelance < '" + dateString + "'";
		try {
			stm.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
