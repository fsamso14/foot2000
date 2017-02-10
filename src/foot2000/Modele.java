package foot2000;

import org.chocosolver.solver.Model;

import org.chocosolver.solver.variables.IntVar;

import Representation.Representation;

/**
 * @author Fab
 * La Classe du mod�le � partir duquel appeler les contraintes
 */
public class Modele {
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
	private Representation rpz;
	// Le mod�le qui contient les variables
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
		// Cr�ation du mod�le sous Choco
		this.model = new Model("One day problem");
		// Cr�ation des variables et initialisation
		this.variables = model.intVarMatrix( nbMatchs, 3, 0, nbArbitres);
	}	
	
	/**
	 * @return Le model li� au probl�me
	 */
	public Model getModele(){
		return this.model;
	}
	
	/**
	 * @return Les contraintes du probl�me
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
