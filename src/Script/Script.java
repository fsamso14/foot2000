package Script;

import org.chocosolver.solver.Model;
import org.chocosolver.solver.search.limits.TimeCounter;
import org.chocosolver.solver.variables.IntVar;

import Contraintes.ContrainteAllDiffs;
import Contraintes.ContrainteSurDistance;
import Contraintes.ContrainteSurGrade;
import Contraintes.ContrainteSurGroupements;
import Contraintes.ObjectiveFunction;
import Representation.Representation;
import foot2000.Modele;

public class Script {
	public static void main(String[] args) {
		try {
			Modele mod = new Modele(new Representation());
			ContrainteAllDiffs c1 = new ContrainteAllDiffs();
			ContrainteSurDistance c2 = new ContrainteSurDistance();
			ContrainteSurGrade c3 = new ContrainteSurGrade();
			ContrainteSurGroupements c4 = new ContrainteSurGroupements();
			ObjectiveFunction obj = new ObjectiveFunction();
			c1.ajout_contrainte(mod);
			c2.ajout_contrainte(mod);
			c3.ajout_contrainte(mod);
			c4.ajout_contrainte(mod);
			obj.ajout_contrainte(mod);
			//System.out.println(mod.getModele().getSolver().solve());
			mod.getModele().getSolver().findOptimalSolution(mod.getNombreZeros(), Model.MINIMIZE, new TimeCounter(mod.getModele(),(long) 30000000000.0));
			//mod.getModele().getSolver().findAllSolutions();
			//mod.getModele().getSolver().showStatistics();
			for(IntVar x : mod.getVarsAsArray()){
				System.out.println(x+" : "+x.getValue());
			}
			System.out.println(mod.getNombreZeros());
		} catch (Exception e) {
			System.out.println("Impossible de charger la représentation");
			e.printStackTrace();
		}
	}

}
