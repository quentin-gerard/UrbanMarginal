package modele;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JLabel;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

/**
 * Gestion du jeu côté serveur
 *
 */
public class JeuServeur extends Jeu implements Global {

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	/**
	 * Collection de joueurs
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>() ;
	
	/**
	 * Constructeur
	 */
	public JeuServeur(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {
		this.lesJoueurs.put(connection, new Joueur(this));
	}

	@Override
	public void reception(Connection connection, Object info) {
		String[] message = ((String)info).split("~");
		switch (message[0]) {
		case "pseudo" :
			this.controle.evenementJeuServeur(AJOUTPANELMURS, connection);
			String pseudo = message[1];
			Integer numPerso = Integer.parseInt(message[2]);
			this.lesJoueurs.get(connection).initPerso(pseudo, numPerso, this.lesJoueurs.values(), this.lesMurs);
		}
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers tous les clients
	 * fais appel plusieurs fois à l'envoi de la classe Jeu
	 */
	public void envoi() {
	}
	
	public void ajoutJLabelJeuArene(JLabel jLabel) {
		this.controle.evenementJeuServeur(AJOUTJLABELJEU, jLabel);
	}
	
	public void envoiJeuATous() {
		for(Connection connection : this.lesJoueurs.keySet()) {
			   this.controle.evenementJeuServeur(MODIFPANELJEU, connection);
			}
	}

	/**
	 * Génération des murs
	 */
	public void constructionMurs() {
		for (int i = 0; i < NBMURS; i++) {
			this.lesMurs.add(new Mur());
			this.controle.evenementJeuServeur(AJOUTMUR, lesMurs.get(lesMurs.size()-1).getJLabel());
		}
		
	}
	
}
