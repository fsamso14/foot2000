package foot2000;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

/**
 * @author Fab
 * La Classe des contraintes recense l'ensemble des contraintes existantes
 */
public class Contraintes {
	// Le nombre d'Arbitres pour d�terminer le domaine de valeurs des variables
	private int nbArbitres;
	
	// Le nombre de matchs pour l'indexage des variables
	private int nbMatchs;
	
	// Les constantes qui correspondent � la position de l'arbitre
	public final static int ARBITRE_CENTRAL =0;
	public final static int ARBITRE_TOUCHE1 =1;
	public final static int ARBITRE_TOUCHE2 =2;
	
	// Variables � pr�dire par Choco
	private IntVar[][] variables;
	
	// Le mod�le qui contient les variables
	private Model model;
	
	/**
	 * Le Constructeur de la classe Contraintes
	 * @param nbArbitres
	 * @param nbMatchs
	 */
	public Contraintes(int nbArbitres,int nbMatchs){
		this.nbArbitres = nbArbitres;
		this.nbMatchs = nbMatchs;
		// Cr�ation du mod�le sous Choco
		this.model = new Model("One day problem");
		// Cr�ation des variables et initialisation
		this.variables = model.intVarMatrix( nbMatchs, 3, 0, nbArbitres);
	}
	

}
