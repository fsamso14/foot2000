package Contraintes;

import Representation.Representation;
import foot2000.Modele;

public class ContrainteSurDisponibilite implements Contrainte{

	public ContrainteSurDisponibilite() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajout_contrainte(Modele mod) {
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		for(int i = 1; i < nbMatchs+1 ; i++){
			for ( int j = 1 ; j < nbArbitres +1; j++){
				if(journee.getMatch(i).getCreneau()!=0){
					if(!journee.getArbitre(j).getDispo(journee.getMatch(i).getCreneau() - 1)){
						mod.getModele().arithm(mod.getVars()[i-1][0], "!=",j);
						mod.getModele().arithm(mod.getVars()[i-1][1], "!=",j);
						mod.getModele().arithm(mod.getVars()[i-1][2], "!=",j);
					}
				}
			}
		}
		
	}

}
