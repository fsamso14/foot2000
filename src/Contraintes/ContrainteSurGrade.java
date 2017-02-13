package Contraintes;

import Representation.Representation;
import foot2000.Modele;

public class ContrainteSurGrade implements Contrainte{

	public ContrainteSurGrade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void ajout_contrainte(Modele mod) {
		// TODO Auto-generated method stub
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		for(int i = 1; i < nbMatchs+1 ; i++){
			for ( int j = 1 ; j < nbArbitres +1; j++){
				if(journee.getMatch(i).getCategorie() > journee.getArbitre(j).getCategorie().getGrade()){
					mod.getModele().arithm(mod.getVars()[i-1][0],"!=",journee.getArbitre(j).getArbitreID()).post();				
				}
				if(journee.getMatch(i).getCategorie() -1 > journee.getArbitre(j).getCategorie().getGrade()){
					mod.getModele().arithm(mod.getVars()[i-1][1],"!=",journee.getArbitre(j).getArbitreID()).post();
					mod.getModele().arithm(mod.getVars()[i-1][2],"!=",journee.getArbitre(j).getArbitreID()).post();
				}
			}
		}
		
	}

}
