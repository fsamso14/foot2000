package Representation;

import java.util.UUID;

public class Match {
	
	private Club receveuse;
	private Club visiteuse;
	private int categorie;
	private String numMatch;
	private Arbitre[] arbitres;
	
	public Match(String numMatch,Club receveuse, Club visiteuse,
			int categorie) throws Exception {
		if (receveuse.equals(visiteuse)) {
			throw new Exception("Erreur dans la construction du Match !");
		}
		this.arbitres = new Arbitre[3];
		this.numMatch=numMatch;
		this.receveuse = receveuse;
		this.visiteuse = visiteuse;
		this.categorie = categorie;
	}
	
	public Club getReceveuse(){
		return this.receveuse;
	}
	
	public Club getVisiteuse(){
		return this.visiteuse;
	}
	
	public int getCategorie(){
		return this.categorie;
	}

	public Arbitre[] getArbitres() {
		return arbitres;
	}

	public void setArbitres(Arbitre[] arbitres) {
		this.arbitres = arbitres;
	}
	public void setArbitre(Arbitre arbitre,int index) {
		this.arbitres[index] = arbitre;
	}
}
