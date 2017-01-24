package Contraintes;

import Representation.*;
import foot2000.Modele;

public class ContrainteSurDistance implements Contrainte{

	@Override
	public void ajout_contrainte(Modele mod) {
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		for(int i = 0; i < nbMatchs ; i++){
			for ( int j = 0 ; j < nbArbitres ; j++){
				if(Club.distances.get(journee.getArbitre(j).getClub().getId()).get(journee.getMatch(i).getReceveuse().getClub().getId()) > journee.getArbitre(j).getCategorie().getKilometrage()){
					mod.getModele().arithm(mod.getVars()[i][0],"!=",journee.getArbitre(j).getArbitreID()).post();
					mod.getModele().arithm(mod.getVars()[i][1],"!=",journee.getArbitre(j).getArbitreID()).post();
					mod.getModele().arithm(mod.getVars()[i][2],"!=",journee.getArbitre(j).getArbitreID()).post();
				}
			}
		}
	}
}
