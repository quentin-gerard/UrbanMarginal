package vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import vue.Arene;
import controleur.Controle;

public class EntreeJeu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIp;
	private ChoixJoueur frmChoixJoueur;
	private Arene frmArene;
	private Controle controle;

	/**
	 * Create the frame.
	 */
	public EntreeJeu(Controle controle) {
		setTitle("UrbanMarginal");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 159);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Start a server :");
		lblNewLabel.setBounds(10, 11, 111, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connect an existing server :");
		lblNewLabel_1.setBounds(10, 38, 147, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP server :");
		lblNewLabel_2.setBounds(10, 63, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart_clic();
			}
		});
		btnStart.setBounds(187, 7, 89, 23);
		contentPane.add(btnStart);
		
		txtIp = new JTextField();
		txtIp.setText("127.0.0.1");
		txtIp.setBounds(65, 60, 111, 20);
		contentPane.add(txtIp);
		txtIp.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConnect_clic();
			}
		});
		btnConnect.setBounds(187, 59, 89, 23);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit_clic();
			}
		});
		btnExit.setBounds(187, 93, 89, 23);
		contentPane.add(btnExit);
		this.controle = controle;

	}
	
	/*
	 * clic sur bouton btnStart
	 */
	private void btnStart_clic() {
		this.controle.evenementEntreeJeu("serveur");
	}
	
	/*
	 * Clic sur bouton btnConnect
	 */
	private void btnConnect_clic() {
		this.controle.evenementEntreeJeu(txtIp.getText().toString());
	}
	
	/* 
	 * Clic sur bouton btnExit
	 */
	private void btnExit_clic() {
		System.exit(0);
	}

}
