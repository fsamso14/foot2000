package foot2000;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

/**
 * @author Fab
 * La Classe du modèle à partir duquel appeler les contraintes
 */
public class Modele {
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
	public Modele(int nbArbitres,int nbMatchs){
		this.nbArbitres = nbArbitres;
		this.nbMatchs = nbMatchs;
		// Création du modèle sous Choco
		this.model = new Model("One day problem");
		// Création des variables et initialisation
		this.variables = model.intVarMatrix( nbMatchs, 3, 0, nbArbitres);
	}	
	
	/**
	 * @return Le model lié au problème
	 */
	public Model getModele(){
		return this.model;
	}
	
	/**
	 * @return Les contraintes du problème
	 */
	public IntVar[][] getVars(){
		return this.variables;
	}
	
	public int getNbMatchs(){
		return this.nbMatchs;
	}
	
	public int getNbArbitres(){
		return this.nbArbitres;
	}

}
