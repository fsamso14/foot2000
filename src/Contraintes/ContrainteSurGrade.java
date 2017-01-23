package Contraintes;

import foot2000.Modele;

public class ContrainteSurGrade implements Contrainte{

	public void ajout_contrainte(Modele mod) {
<<<<<<< HEAD
		// TODO Auto-generated method stub
=======
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		for(int i = 0; i < nbMatchs ; i++){
			for ( int j = 0 ; j < nbArbitres ; j++){
				if(journee.getMatch(i).getCategorie() > journee.getArbitre(j).getCategorie().getGrade()){
					mod.getModele().arithm(mod.getVars()[i][0],"!=",journee.getArbitre(j).getArbitreID()).post();				
				}
				if(journee.getMatch(i).getCategorie() -1 > journee.getArbitre(j).getCategorie().getGrade()){
					mod.getModele().arithm(mod.getVars()[i][1],"!=",journee.getArbitre(j).getArbitreID()).post();
					mod.getModele().arithm(mod.getVars()[i][2],"!=",journee.getArbitre(j).getArbitreID()).post();
				}
			}
		}
>>>>>>> refs/heads/contraintes_fabian2
		
	}

}
