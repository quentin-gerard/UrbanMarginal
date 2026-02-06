package vue;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Global;
import outils.son.Son;
import controleur.Controle;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arene extends JFrame implements Global {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSaisie;
	private JPanel jpnJeu;
	private JPanel jpnMurs;
	private JTextArea textChat = new JTextArea();
	private Controle controle;
	/**
	 * booléen pour savoir si c'est l'arène du client ou du serveur
	 */
	private boolean client;
	private Son[] lesSons = new Son[SON.length];
	
	private void contentPane_KeyPressed(KeyEvent e) {
		int touche = -1;
		int keyPressed = e.getKeyCode();
		switch(keyPressed) {
		case KeyEvent.VK_UP :
		case KeyEvent.VK_DOWN :
		case KeyEvent.VK_LEFT :
		case KeyEvent.VK_RIGHT :
		case KeyEvent.VK_SPACE :
			touche = e.getKeyCode();
			break;
		}
		if (touche != -1) {
			this.controle.evenementArene(touche);
		}
	}
	
	/**
	 * Joue le son correspondant au numéro reçu
	 * @param numSon numéro du son (0 : fight, 1 : hurt; 2 : death)
	 */
	public void joueSon(Integer numSon) {
		this.lesSons[numSon].play();
	}

	/**
	 * Create the frame.
	 */
	public Arene(Controle controle, String typeJeu) {
		this.client = typeJeu.equals(CLIENT);
		setTitle("Arena");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800, 600 + 25 + 140));
		this.pack();
		contentPane = new JPanel();
		if(this.client) {
			contentPane.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					contentPane_KeyPressed(e);
				}
			});
		}
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
		
		if(this.client) {
			textSaisie = new JTextField();
			textSaisie.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					txtSaisie_KeyPressed(e);
				}
			});
			textSaisie.setBounds(0, 600, 800, 25);
			contentPane.add(textSaisie);
			textSaisie.setColumns(10);
		}
		
		JScrollPane jspChat = new JScrollPane();
		if (this.client) {
			jspChat.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					contentPane_KeyPressed(e);
				}
			});
		}
		jspChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jspChat.setBounds(0, 625, 800, 140);
		contentPane.add(jspChat);
		
		textChat = new JTextArea();
		textChat.setEditable(false);
		jspChat.setViewportView(textChat);
		
		if(client) {
				for (int k=0 ; k<SON.length ; k++) {
					lesSons[k] = new Son(getClass().getClassLoader().getResource(SON[k])) ;
				}
		}
		
		this.controle = controle;
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
		this.contentPane.requestFocus();
	}
	
	public void ajoutJLabelJeu(JLabel unJLabel) {
		this.jpnJeu.add(unJLabel);
		this.jpnJeu.repaint();
	}
	
	// getter sur textChat
	public String getTextChat() {
		return textChat.getText();
	}
	
	// setter sur textChat
	public void setTextChat(String textChat) {
		this.textChat.setText(textChat);
		this.textChat.setCaretPosition(this.textChat.getDocument().getLength());
	}
	
	// ajouter text au tchat sans supprimer le contenu
	public void ajoutTchat(String phrase) {
		this.textChat.setText(this.textChat.getText() + phrase + "\r\n");
		this.textChat.setCaretPosition(this.textChat.getDocument().getLength());
	}
	
	public void txtSaisie_KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(!this.textSaisie.getText().equals("")) {
				this.controle.evenementArene(this.textSaisie.getText());
				this.textSaisie.setText("");
			}
			this.contentPane.requestFocus();
		}
	}
}
