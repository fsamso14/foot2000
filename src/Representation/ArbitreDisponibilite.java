package Representation;

import java.util.HashMap;

public class ArbitreDisponibilite {

	private ArbitreWithHashMap arbitres;
	HashMap<Integer, Boolean> dispo;

	public ArbitreDisponibilite(ArbitreWithHashMap arbitres) {
		this.arbitres = arbitres;
		for (Integer arbitreID : this.arbitres.getAllArbitreID()) {
			HashMap<Integer, Boolean> dispo = new HashMap<Integer, Boolean>();
			dispo.put(arbitreID, true);
		}
	}

	/**
	 * Retourne un arbitre à partir d'un ID donné
	 * 
	 * @param arbitreID
	 * @return
	 */
	public Arbitre getArbitre(int arbitreID) {
		return this.arbitres.getArbitre(arbitreID);
	}

	/**
	 * Retourne la disponibilité d'un arbitre à partir de la donnée de son ID
	 * 
	 * @param arbitreID
	 * @return
	 */
	public boolean getDispo(int arbitreID) {
		return this.dispo.get(arbitreID);
	}

	/**
	 * Modifie la disponibilité d'un arbitre à partir de la donnée de son ID
	 * 
	 * @param arbitreID
	 */
	public void setDispo(int arbitreID) {
		boolean avant = this.dispo.get(arbitreID);
		this.dispo.replace(arbitreID, !avant);
	}
}
