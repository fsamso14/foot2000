package Representation;

import java.util.HashMap;
import java.util.Set;

public class ArbitreIndisponibilite {

	HashMap<Integer, String> dispo;

	public ArbitreIndisponibilite() {
		this.dispo = new HashMap<Integer, String>();
	}

	public void addArbitre(int arbitreID, Date debut, Date fin) {
		this.dispo.put(arbitreID, debut.toString() + " | " + fin.toString()); // CLASSE Date A CREER
	}

	public Set<Integer> getIndispo() {
		return this.dispo.keySet();
	}

	/**
	 * Verifie si un arbitre est indisponible
	 * 
	 * @return true si l'arbitre est absent, false sinon
	 */
	public boolean checkArbitre(int arbitreID) {
		return this.getIndispo().contains(arbitreID);
	}

}
