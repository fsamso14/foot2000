package Representation;
import java.util.UUID;

public class Match {

	private String id_match;
	private Equipe receveuse;
	private Equipe visiteuse;
	private Ville ville;
	private int categorie;
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
		this.receveuse = receveuse;
		this.visiteuse = visiteuse;
		this.categorie = categorie;
	}
	
	public int getCategorie(){
		return this.categorie;
	}
	
	public String getID(){
		return this.id_match;
	}

	public Equipe getReceveuse() {
		return this.receveuse;
	}

	public Equipe getVisiteuse() {
		return this.visiteuse;
	}
}
