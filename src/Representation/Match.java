package Representation;

public class Match {
	
	private Equipe receveuse;
	private Equipe visiteuse;
<<<<<<< HEAD
=======
	private Ville ville;
>>>>>>> refs/heads/contraintes_fabian2
	private int categorie;
<<<<<<< HEAD
	
	public Match(Equipe receveuse, Equipe visiteuse, int categorie ){
=======
	private Creneau creneau;
	
	public Ville getVille(){
		return this.ville;
	}
	
	public Creneau getCreneau(){
		return this.creneau;
	}
	public Match(Equipe receveuse, Equipe visiteuse,
			int categorie) throws Exception {
		if (receveuse.equals(visiteuse)) {
			throw new Exception("Erreur dans la construction du Match !");
		}
		this.id_match = UUID.randomUUID().toString();
>>>>>>> refs/heads/contraintes_fabian2
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
<<<<<<< HEAD

=======
	
	public String getID(){
		return this.id_match;
	}

	public Equipe getReceveuse() {
		return this.receveuse;
	}

	public Equipe getVisiteuse() {
		return this.visiteuse;
	}
>>>>>>> refs/heads/contraintes_fabian2
}
