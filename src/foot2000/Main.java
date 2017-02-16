package foot2000;

import java.util.ArrayList;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.search.limits.TimeCounter;
import org.chocosolver.solver.variables.IntVar;

import Contraintes.ContrainteAllDiffs;
import Contraintes.ContrainteSurDisponibilite;
import Contraintes.ContrainteSurDistance;
import Contraintes.ContrainteSurGrade;
import Contraintes.ContrainteSurGroupements;
import Contraintes.ObjectiveFunction;
import Representation.Club;
import Representation.Match;
import Representation.Representation;

public class Main {
	public static Modele run() throws Exception {

		Modele mod = new Modele(new Representation());
		ContrainteAllDiffs c1 = new ContrainteAllDiffs();
		ContrainteSurDistance c2 = new ContrainteSurDistance();
		ContrainteSurGrade c3 = new ContrainteSurGrade();
		ContrainteSurGroupements c4 = new ContrainteSurGroupements();
		ContrainteSurDisponibilite c5 = new ContrainteSurDisponibilite();
		ObjectiveFunction obj = new ObjectiveFunction();
		c1.ajout_contrainte(mod);
		c2.ajout_contrainte(mod);
		c3.ajout_contrainte(mod);
		c4.ajout_contrainte(mod);
		c5.ajout_contrainte(mod);
		obj.ajout_contrainte(mod);
		// System.out.println(mod.getModele().getSolver().solve());
		mod.getModele()
				.getSolver()
				.findOptimalSolution(mod.getNombreZeros(), Model.MINIMIZE,
						new TimeCounter(mod.getModele(), (long) 300000000000.0));
		// mod.getModele().getSolver().findAllSolutions();
		// mod.getModele().getSolver().showStatistics();
		finalInstantiation(mod);
		ecritureResultat(mod);
		for (int i = 1 ; i < mod.getRepresentation().getNbMatchs()+1;i++) {
			System.out.println("################## Match n°"+i+" #############################");
			System.out.println(mod.getRepresentation().getMatch(i));
			if(mod.getRepresentation().getMatch(i).getArbitres()[0]!=null){
				System.out.println("Distances : "+Club.distances.get(mod.getRepresentation().getMatch(i).getReceveuse().getId())
													.get(mod.getRepresentation().getMatch(i).getArbitres()[0].getClub().getId()));
			}
		}
		return mod;
	}

	public static void ecritureResultat(Modele mod) {
		Representation rep = mod.getRepresentation();
		ArrayList<Integer> forbiddens = new ArrayList<Integer>();
		for (int i = 1; i < rep.getNbMatchs() + 1; i++) {
			Match m = rep.getMatch(i);
			for (int j = 0; j < 3; j++) {
				IntVar var = mod.getVars()[i - 1][j];
				if (var.isInstantiated()) {
					if (var.getValue() == 0) {
						m.setArbitre(null, j);
					} else {
						m.setArbitre(rep.getArbitre(var.getValue()), j);
					}
				} else {
					try {
						var.instantiateTo(0, null);
					} catch (ContradictionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					m.setArbitre(null, j);
				}
			}
		}

	}

	public static void finalInstantiation(Modele mod) {
		Representation rep = mod.getRepresentation();
		ArrayList<Integer> forbiddens = new ArrayList<Integer>();
		for (int i = 1; i < rep.getNbMatchs() + 1; i++) {
			for (int j = 0; j < 3; j++) {
				IntVar var = mod.getVars()[i - 1][j];
				if (var.isInstantiated()) {
				} else {
					try {
						int value = 0;
						boolean instantiate = false;
						while (value < Integer.MAX_VALUE && !instantiate) {
							if (!forbiddens.contains(var.nextValue(value))) {
								var.instantiateTo(var.nextValue(value), null);
								forbiddens.add(var.getValue());
								instantiate = true;
							} else {
								value = var.nextValue(value);
							}
						}
					} catch (ContradictionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
>>>>>>> branch 'master' of https://github.com/fsamso14/foot2000
