package graphique;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NouveauMessage {

	public JFrame frame;
	private JTextField textFieldSujetMsg;
	private JTextField textFieldMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NouveauMessage window = new NouveauMessage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NouveauMessage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 876, 695);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Sujet");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(60, 186, 78, 30);
		frame.getContentPane().add(lblNewLabel_1);

		textFieldSujetMsg = new JTextField();
		textFieldSujetMsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSujetMsg.setBounds(227, 188, 535, 30);
		frame.getContentPane().add(textFieldSujetMsg);
		textFieldSujetMsg.setColumns(10);

		JButton btnSendMsg = new JButton("ENVOYER");
		btnSendMsg.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSendMsg.setBounds(60, 582, 144, 53);
		frame.getContentPane().add(btnSendMsg);

		JButton btnCancelMsg = new JButton("ANNULER");
		btnCancelMsg.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancelMsg.setBounds(634, 580, 144, 57);
		frame.getContentPane().add(btnCancelMsg);

		JLabel lblNewLabel = new JLabel("Message");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(358, 244, 119, 24);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel(
				"Une remarque, une suggestion ? N'h\u00E9sitez pas \u00E0 nous \u00E9crire ! ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(130, 0, 632, 69);
		frame.getContentPane().add(lblNewLabel_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 280, 716, 265);
		frame.getContentPane().add(scrollPane);

		JTextArea textAreaMsg = new JTextArea();
		scrollPane.setViewportView(textAreaMsg);
		textAreaMsg.setLineWrap(true);
		textAreaMsg.setWrapStyleWord(true);
		textAreaMsg.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		JLabel lblNewLabel_3 = new JLabel("Destinataire");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(60, 127, 131, 30);
		frame.getContentPane().add(lblNewLabel_3);

		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMail.setBounds(227, 127, 535, 30);
		frame.getContentPane().add(textFieldMail);
		textFieldMail.setColumns(10);
	}
}
