package Representation;

import java.util.UUID;

public class Match {
	
	private Equipe receveuse;
	private Equipe visiteuse;
	private int categorie;
	private int id_match;
	
	public Match(Equipe receveuse, Equipe visiteuse,
			int categorie) throws Exception {
		if (receveuse.equals(visiteuse)) {
			throw new Exception("Erreur dans la construction du Match !");
		}
		this.receveuse = receveuse;
		this.visiteuse = visiteuse;
		this.categorie = categorie;
	}
	
	public Equipe getReceveuse(){
		return this.receveuse;
	}
	
	public Equipe getVisiteuse(){
		return this.visiteuse;
	}
	
	public int getCategorie(){
		return this.categorie;
	}
}
