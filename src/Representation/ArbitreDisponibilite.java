package Representation;

import java.util.HashMap;

public class ArbitreDisponibilite {
	
	private ArbitreWithHashMap arbitres;
	//private boolean dispo;
	HashMap<Integer, Boolean> dispo  ;
	
	public ArbitreDisponibilite(ArbitreWithHashMap arbitres){
		this.arbitres = arbitres;
		for(Integer arbitreID : this.arbitres.getAllArbitreID()){
			HashMap<Integer, Boolean> dispo  = new HashMap<Integer, Boolean>();
			dispo.put(arbitreID, true);
		}
	}
	
	public Arbitre getArbitre(int arbitreID){
		return this.arbitres.getArbitre(arbitreID);
	}
	
	public boolean getDispo(int arbitreID){
		return this.dispo.get(arbitreID);
	}
	
	public void setDispo(int arbitreID){
		boolean avant = this.dispo.get(arbitreID);
		this.dispo.replace(arbitreID,!avant);
	}

}
