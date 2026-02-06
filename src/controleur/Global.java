package controleur;

/**
 * Constantes globales
 */
public interface Global {
	/**
	 * N° du port d'écoute du serveur
	 */
	int PORT = 6666;
	/**
	 * Nombre de personnages différents
	 */
	int MAXPERSO = 3;
	/**
	 * Caractère de séparation dans un chemin de fichiers
	 */
	String CHEMINSEPARATOR = "/";
	/**
	 * Chemin du dossier des images de fonds
	 */
	String CHEMINFONDS = "fonds"+CHEMINSEPARATOR;
	/**
	 * Chemin du dossier des images des personnages
	 */
	String CHEMINPERSONNAGES = "personnages"+CHEMINSEPARATOR;
	/**
	 * Chemin de l'image de fond de la vue ChoixJoueur
	 */
	String FONDCHOIX = CHEMINFONDS+"fondchoix.jpg";
	/**
	 * Chemin de l'image de fond de la vue Arene
	 */
	String FONDARENE = CHEMINFONDS+"fondarene.jpg";
	/**
	 * Extension des fichiers des images des personnages
	 */
	String EXTFICHIERPERSO = ".gif";
	/**
	 * Début du nom des images des personnages
	 */
	String PERSO = "perso";
	/**
	 * état marche du personnage
	 */
	String MARCHE = "marche";
	/**
	 * état touché du personnage
	 */
	String TOUCHE = "touche";
	/**
	 * état mort du personnage
	 */
	String MORT = "mort";
	/**
	 * Caractère de séparation dans les chaines transférées
	 */
	String STRINGSEPARE = "~";
	/**
	 * Type de jeu "serveur"
	 */
	String SERVEUR = "serveur";
	/**
	 * Message "connexion" envoyé par la classe Connection
	 */
	String CLIENT = "client";
	String CONNEXION = "connexion";
	/**
	 * Message "réception" envoyé par la classe Connection
	 */
	String RECEPTION = "reception";
	/**
	 * Message "déconnexion" envoyé par la classe Connection
	 */
	String DECONNEXION = "deconnexion";
	/**
	 * Message "pseudo" envoyé pour la création d'un joueur
	 */
	String PSEUDO = "pseudo";
	/**
	 * vie de départ pour tous les joueurs
	 */
	int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	int PERTE = 2 ; 
	
	int HAUTEURARENE = 600;
	int LARGEURARENE = 800;
	int HAUTEURMUR = 35;
	int LARGEURMUR = 34;

	String CHEMINMURS = "murs"+CHEMINSEPARATOR;
	String MUR = CHEMINMURS+"mur.gif";
	
	int NBMURS = 20;
	
	String AJOUTMUR = "ajout mur";
	String AJOUTPANELMURS = "ajout panel murs";
	
	int HAUTEURPERSO = 44;
	int LARGEURPERSO = 39;
	int HAUTEURMESSAGE = 8;
	int MARGEMESSAGE = 10;
	
	int GAUCHE = 0;
	int DROITE = 1;
	int DEPLACEMENT = 10;
	int NBETAPESMARCHE = 4;
	/**
	 * nombre d'étapes (d'images) pour donner l'impression d'être touché
	 */
	int NBETAPESTOUCHE = 2;
	/**
	 * nombre d'étapes (d'images) pour donner l'impresson de mourir
	 */
	int NBETAPESMORT = 2;
	
	String AJOUTJLABELJEU = "ajout jlabel jeu";
	String MODIFPANELJEU = "modif jpanel jeu";
	
	String TCHAT = "tchat";
	String AJOUTPHRASE = "ajout phrase";
	String MODIFTCHAT = "modif tchat";
	
	String ACTION = "action";
	
	String CHEMINBOULES = "boules"+CHEMINSEPARATOR;
	String BOULE = CHEMINBOULES+"boule.gif";
	int LARGEURBOULE = 17;
	int HAUTEURBOULE = 17;
	
	String CHEMINSONS = "sons"+CHEMINSEPARATOR;
	String SONWELCOME = CHEMINSONS+"welcome.wav";
	String SONPRECEDENT = CHEMINSONS+"precedent.wav";
	String SONSUIVANT = CHEMINSONS+"suivant.wav";
	String SONGO = CHEMINSONS+"go.wav";
	
	String SONFIGHT = CHEMINSONS+"fight.wav";
	String SONHURT = CHEMINSONS+"hurt.wav";
	String SONDEATH = CHEMINSONS+"death.wav";
	String[] SON = {SONFIGHT, SONHURT, SONDEATH} ;
	
	int FIGHT = 0;
	int HURT = 1;
	int DEATH = 2;
	
	String JOUESON = "joue son";

}