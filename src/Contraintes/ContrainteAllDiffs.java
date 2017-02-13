package Contraintes;

import foot2000.Modele;

public class ContrainteAllDiffs implements Contrainte{
	

	public ContrainteAllDiffs() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajout_contrainte(Modele mod) {
		mod.getModele().allDifferentExcept0(mod.getVarsAsArray()).post();
		
	}

}
