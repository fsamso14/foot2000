package foot2000;

import org.chocosolver.solver.Model;

import org.chocosolver.solver.variables.IntVar;

import Representation.Representation;

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
	private Representation rpz;
	// Le modèle qui contient les variables
	private Model model;
	
	/**
	 * Le Constructeur de la classe Contraintes
	 * @param nbArbitres
	 * @param nbMatchs
	 */
	public Modele(Representation rpz){
		this.rpz=rpz;
		this.nbArbitres = rpz.getNbArbitres();
		this.nbMatchs = rpz.getNbMatchs();
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

	
	/**
	 * @return La representation des matchs et des arbitres
	 */
	public Representation getRepresentation(){
		return this.rpz;
	} 
	
	/**
	 * 
	 * @return Les variables sous forme de liste
	 */
	
	public IntVar[] getVarsAsArray(){
		IntVar[] aRet = new IntVar[rpz.getNbArbitres()*3];
		int k =0;
		for(int i = 0 ; i < rpz.getNbArbitres(); i ++){
			for(int j = 0 ; j < 3; j++){
				aRet[k] =  this.getVars()[i][j];
				k++;
			}
		}
		return aRet;
	}

}
