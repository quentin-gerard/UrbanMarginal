package vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Global;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class Arene extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSaisie;
	private JPanel jpnJeu;
	private JPanel jpnMurs;

	/**
	 * Create the frame.
	 */
	public Arene() {
		setTitle("Arena");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800, 600 + 25 + 140));
		this.pack();
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		jpnJeu = new JPanel();
		jpnJeu.setBounds(0, 0, LARGEURARENE, HAUTEURARENE);
		jpnJeu.setOpaque(false);
		jpnJeu.setLayout(null);
		contentPane.add(jpnJeu);
		
		jpnMurs = new JPanel();
		jpnMurs.setBounds(0, 0, LARGEURARENE, HAUTEURARENE);
		jpnMurs.setOpaque(false);
		jpnMurs.setLayout(null);
		contentPane.add(jpnMurs);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 800, 600);
		contentPane.add(lblFond);
		String chemin = "fonds/fondarene.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		
		textSaisie = new JTextField();
		textSaisie.setBounds(0, 600, 800, 25);
		contentPane.add(textSaisie);
		textSaisie.setColumns(10);
		
		JScrollPane jspChat = new JScrollPane();
		jspChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, 625, 800, 140);
		contentPane.add(jspChat);
		
		JTextArea textChat = new JTextArea();
		jspChat.setViewportView(textChat);

	}
	
	public void AjoutMurs(Object mur) {
		jpnMurs.add(((JLabel)mur));
		jpnMurs.repaint();
	}
	
	public JPanel getJpnMurs() {
		return jpnMurs;
	}
	
	public void setJpnMurs(JPanel jpnMurs) {
		this.jpnMurs.add(jpnMurs);
		this.jpnMurs.repaint();
	}
	
	public JPanel getJpnJeu() {
		return jpnJeu;
	}
	
	public void setJpnJeu(JPanel jpnJeu) {
		this.jpnJeu.removeAll();
		this.jpnJeu.add(jpnJeu);
		this.jpnJeu.repaint();
	}
	
	public void ajoutJLabelJeu(JLabel unJLabel) {
		this.jpnJeu.add(unJLabel);
		this.jpnJeu.repaint();
		
	}
}
