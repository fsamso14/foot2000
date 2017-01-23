package Contraintes;

import foot2000.Modele;

public class ContrainteAllDiffs implements Contrainte{

	@Override
	public void ajout_contrainte(Modele mod) {
		mod.getModele().allDifferentExcept0(mod.getVarsAsArray());
		
	}

}
