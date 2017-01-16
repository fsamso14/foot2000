package Representation;

public class ArbitreDisponibilite {
	
	private Arbitre arbitre;
	
	private boolean dispo;
	
	public ArbitreDisponibilite(Arbitre arbitre){
		this.arbitre = arbitre;
		this.dispo = true;
	}
	
	public Arbitre getArbitre(){
		return this.arbitre;
	}
	
	public boolean getDispo(){
		return this.dispo;
	}
	
	public void setDispo(){
		this.dispo = !dispo;
	}

}
