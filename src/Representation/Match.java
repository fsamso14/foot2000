package Representation;

import java.util.UUID;

public class Match {
	
	public static final int SAMEDI_14 = 1;
	public static final int SAMEDI_16 = 2;
	public static final int SAMEDI_18 = 3;
	public static final int SAMEDI_20 = 4;
	public static final int DIMANCHE_10_30 = 5;
	public static final int DIMANCHE_13 = 6;
	public static final int DIMANCHE_15 = 7;
	public static final int AUTRE_CRENEAU = 0;
	
	private int creneau;
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

	public int getCreneau() {
		return creneau;
	}

	public void setCreneau(int creneau) {
		this.creneau = creneau;
	}
	
}
