package foot2000;

/**
 * @author Fab
 * La Classe des contraintes recense l'ensemble des contraintes existantes
 */
public class Contraintes {
	// Le nombre d'Arbitres pour déterminer le domaine de valeurs des variables
	private int nbArbitres;
	
	// Le nombre de matchs pour l'indexage des variables
	private int nbMatchs;
	
	// Les constantes qui correspondent à la position de l'arbitre
	public final static int ARBITRE_CENTRAL =0;
	public final static int ARBITRE_TOUCHE1 =1;
	public final static int ARBITRE_TOUCHE2 =2;
	
	/**
	 * Le Constructeur de la classe Contraintes
	 * @param nbArbitres
	 * @param nbMatchs
	 */
	public Contraintes(int nbArbitres,int nbMatchs){
		this.nbArbitres = nbArbitres;
		this.nbMatchs = nbMatchs;
	}
	

}
