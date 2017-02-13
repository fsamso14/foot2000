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
		for(int i = 0; i < nbMatchs ; i++){
			for ( int j = 0 ; j < nbArbitres ; j++){
				if(true);
			}
		}
	}
}
