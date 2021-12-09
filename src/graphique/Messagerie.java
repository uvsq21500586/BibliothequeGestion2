package graphique;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Messagerie {

	public JFrame frameMessagerie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messagerie window = new Messagerie();
					window.frameMessagerie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Messagerie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMessagerie = new JFrame();
		frameMessagerie.getContentPane().setBackground(new Color(224, 255, 255));
		frameMessagerie.setTitle("Messagerie");
		frameMessagerie.setBounds(100, 100, 650, 450);
		frameMessagerie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMessagerie.getContentPane().setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(255, 47, 371, 356);
		frameMessagerie.getContentPane().add(scrollPane_1);

		JTextPane textPaneMessage = new JTextPane();
		scrollPane_1.setViewportView(textPaneMessage);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 230, 356);
		frameMessagerie.getContentPane().add(scrollPane);

		JList listMessages = new JList();
		scrollPane.setViewportView(listMessages);

		JButton buttonNouveauMessage = new JButton("Nouveau message");
		buttonNouveauMessage.setBounds(10, 10, 175, 27);
		frameMessagerie.getContentPane().add(buttonNouveauMessage);

		JButton buttonSupprimerMessage = new JButton("Supprimer message");
		buttonSupprimerMessage.setBounds(195, 10, 175, 27);
		frameMessagerie.getContentPane().add(buttonSupprimerMessage);

		JButton buttonRetour = new JButton("Retour");
		buttonRetour.setBounds(380, 10, 175, 27);
		frameMessagerie.getContentPane().add(buttonRetour);
	}
}
