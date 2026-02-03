package controleur;

import vue.EntreeJeu;
import vue.Arene;
import vue.ChoixJoueur;
import outils.connexion.ServeurSocket;
import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.AsyncResponse;
import outils.connexion.Connection;
import outils.connexion.ClientSocket;

public class Controle implements AsyncResponse {
	
	private Arene frmArene;
	private EntreeJeu frmEntreeJeu ;
	private ChoixJoueur frmChoixJoueur;
	private static final int PORT = 6666;
	private Jeu leJeu;
	
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this);
		this.frmEntreeJeu.setVisible(true);
	}

	/**
	 * Méthode d'entrée dans l'application
	 * @param args non utilisé
	 */
	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Méthode d'envoi
	 */
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}
	
	public void evenementEntreeJeu(String info) {
		if (info == "serveur") {
			new ServeurSocket(this, PORT);
			this.leJeu = new JeuServeur(this);
			frmArene = new Arene();
			frmArene.setVisible(true);
			frmEntreeJeu.dispose();
		}
		else {
			new ClientSocket(this, info, PORT);
		}
	}
	
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		frmChoixJoueur.dispose();
		frmArene.setVisible(true);
		((JeuClient)this.leJeu).envoi("pseudo" + "~" + pseudo + "~" + numPerso);
	}

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		// TODO Auto-generated method stub
		String order = ordre;
		switch(order) {
		case "connexion":
			if(!(this.leJeu instanceof JeuServeur)) {
				frmEntreeJeu.dispose();
				frmArene = new Arene();
				frmChoixJoueur = new ChoixJoueur(this);
				frmChoixJoueur.setVisible(true);
				this.leJeu = new JeuClient(this);
				leJeu.connexion(connection);
			}
			else {
				leJeu.connexion(connection);
			}
			break;
		case "reception":
			this.leJeu.reception(connection, info);
			break;
		case "deconnexion":
			break;
		}
		
	}

}
