package Contraintes;

import java.io.IOException;
import java.util.HashMap;

import Representation.*;
import foot2000.Modele;
import jxl.read.biff.BiffException;

public class ContrainteSurDistance implements Contrainte{

	public ContrainteSurDistance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajout_contrainte(Modele mod) {
		Representation journee = mod.getRepresentation();
		int nbMatchs = journee.getNbMatchs();
		int nbArbitres = journee.getNbArbitres();
		HashMap<String, HashMap<String, Double>> dist;
		try {
			dist = journee.distances();
			for(int i = 1; i < nbMatchs +1 ; i++){
				for ( int j = 1 ; j < nbArbitres +1; j++){
					if(dist.get(journee.getArbitre(j).getClub().getId())
							.get(journee.getMatch(i).getReceveuse().getId()) > journee.getArbitre(j).getCategorie().getKilometrage()){
						mod.getModele().arithm(mod.getVars()[i-1][0],"!=",journee.getArbitre(j).getArbitreID()).post();
						mod.getModele().arithm(mod.getVars()[i-1][1],"!=",journee.getArbitre(j).getArbitreID()).post();
						mod.getModele().arithm(mod.getVars()[i-1][2],"!=",journee.getArbitre(j).getArbitreID()).post();
					}
				}
			}
		} catch (BiffException | IOException e) {
			System.out.println("Probleme de distances !");
			e.printStackTrace();
		}

	}
}