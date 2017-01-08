package foot2000;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

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
	
	// Variables à prédire par Choco
	private IntVar[][] variables;
	
	// Le modèle qui contient les variables
	private Model model;
	
	/**
	 * Le Constructeur de la classe Contraintes
	 * @param nbArbitres
	 * @param nbMatchs
	 */
	public Contraintes(int nbArbitres,int nbMatchs){
		this.nbArbitres = nbArbitres;
		this.nbMatchs = nbMatchs;
		// Création du modèle sous Choco
		this.model = new Model("One day problem");
		// Création des variables et initialisation
		this.variables = model.intVarMatrix( nbMatchs, 3, 0, nbArbitres);
	}
	

}
