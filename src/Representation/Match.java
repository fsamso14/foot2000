package Representation;

public class Match {
	
	private Equipe receveuse;
	private Equipe visiteuse;
	private int categorie;
	
	public Match(Equipe receveuse, Equipe visiteuse, int categorie ){
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
