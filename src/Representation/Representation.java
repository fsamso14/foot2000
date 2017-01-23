package Representation;

import java.util.Date;

public class Representation {
	/** Jour de la saison */
	public int day;
	
	/** Liste des matchs à faire */
	public Match[] matchs;
	
	/** Liste des arbitres */
	public Arbitre[] arbitres;
	
	public Date samedi;
	
	public int getNbMatchs(){
		return matchs.length;
	}
	public int getNbArbitres(){
		return arbitres.length;
	}
	public Arbitre getArbitre(int i){
		return this.arbitres[i];
	}
	public Match getMatch(int i){
		return this.matchs[i];
	}
}
