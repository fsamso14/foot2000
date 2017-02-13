package Contraintes;

import org.chocosolver.solver.Model;

import foot2000.Modele;

public class ObjectiveFunction implements Contrainte{

	public ObjectiveFunction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajout_contrainte(Modele mod) {
		mod.getModele().count(0, mod.getVarsAsArray(),mod.getNombreZeros()).post();;
		mod.getModele().setObjective(Model.MINIMIZE, mod.getNombreZeros());
		
	}

}
