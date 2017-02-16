package Contraintes;

import Representation.Representation;
import foot2000.Modele;

public class ContrainteSurGroupements implements Contrainte{

	public ContrainteSurGroupements() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajout_contrainte(Modele mod) {
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		for(int i = 1; i < nbMatchs +1; i++){
			for ( int j = 1 ; j < nbArbitres+1 ; j++){
				if(journee.getMatch(i).getReceveuse().getGroupement().equals(journee.getArbitre(j).getClub().getGroupement())
						|| journee.getMatch(i).getVisiteuse().getGroupement().equals(journee.getArbitre(j).getClub().getGroupement())){
					if(journee.getArbitre(j).getClub().getGroupement().equals("0")){
						if(journee.getMatch(i).getReceveuse().getId().equals(journee.getArbitre(j).getClub().getId())
								|| journee.getMatch(i).getVisiteuse().getId().equals(journee.getArbitre(j).getClub().getId())){
							mod.getModele().arithm(mod.getVars()[i-1][0],"!=",journee.getArbitre(j).getArbitreID()).post();
							mod.getModele().arithm(mod.getVars()[i-1][1],"!=",journee.getArbitre(j).getArbitreID()).post();
							mod.getModele().arithm(mod.getVars()[i-1][2],"!=",journee.getArbitre(j).getArbitreID()).post();
						}
					}
					else{
						mod.getModele().arithm(mod.getVars()[i-1][0],"!=",journee.getArbitre(j).getArbitreID()).post();
						mod.getModele().arithm(mod.getVars()[i-1][1],"!=",journee.getArbitre(j).getArbitreID()).post();
						mod.getModele().arithm(mod.getVars()[i-1][2],"!=",journee.getArbitre(j).getArbitreID()).post();
					}	
				}
			}
		}
	}
}
