package vue;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import vue.Arene;
import controleur.Controle;
import controleur.Global;
import outils.son.Son;

import javax.swing.SwingConstants;

public class ChoixJoueur extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPseudo;
	private JLabel lblPersonnage;
	private Arene frmArene;
	private Controle controle;
	private int numPerso = 1;
	private static int maxPerso = 3;
	private Son welcome;
	private Son precedent;
	private Son suivant;
	private Son go;
	

	/**
	 * Affiche perso
	 */
	private void affichePerso() {
		String chemin = "personnages/perso"+numPerso+"marche1d1.gif";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblPersonnage.setIcon(new ImageIcon(resource));
	}
	
	/**
	 * Create the frame.
	 */
	public ChoixJoueur(Controle controle) {
		setTitle("Choice");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPersonnage = new JLabel("");
		lblPersonnage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonnage.setBounds(137, 115, 128, 119);
		contentPane.add(lblPersonnage);
		
		textPseudo = new JTextField();
		textPseudo.setBounds(137, 245, 128, 20);
		contentPane.add(textPseudo);
		textPseudo.setColumns(10);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPrecedent_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblPrecedent.setBounds(61, 144, 34, 47);
		contentPane.add(lblPrecedent);
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblSuivant.setBounds(301, 144, 34, 47);
		contentPane.add(lblSuivant);
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				sourisDoigt();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				sourisNormale();
			}
		});
		lblGo.setBounds(308, 193, 70, 72);
		contentPane.add(lblGo);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		contentPane.add(lblFond);
		String chemin = "fonds/fondchoix.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		
		this.controle = controle;
		affichePerso();
		
		suivant = new Son(getClass().getClassLoader().getResource(SONSUIVANT));
		precedent = new Son(getClass().getClassLoader().getResource(SONPRECEDENT));
		go = new Son(getClass().getClassLoader().getResource(SONGO));
		welcome = new Son(getClass().getClassLoader().getResource(SONWELCOME));
		welcome.play();
	}
	
	/*
	 * Clic sur label lblPrecedent
	 */
	private void lblPrecedent_clic() {
		precedent.play();
		if (numPerso > 1) {
			numPerso -= 1;
		}
		else {
			numPerso = maxPerso;
		}
		affichePerso();
		
	}
	
	/*
	 * Clic sur label lblSuivant
	 */
	private void lblSuivant_clic() {
		suivant.play();
		if (numPerso < maxPerso) {
			numPerso += 1;
		}
		else {
			numPerso = 1;
		}
		affichePerso();
	}
	
	/*
	 * Clic sur label lblGo
	 */
	private void lblGo_clic() {
		go.play();
		if (textPseudo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "La saisie du pseudo est obligatoire");
		}
		else {
			this.controle.evenementChoixJoueur(textPseudo.getText(), numPerso);
		}
	}
	
	/*
	 * Changement en curseur normal
	 */
	private void sourisNormale() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	/*
	 * Changement en curseur doigt
	 */
	private void sourisDoigt() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
