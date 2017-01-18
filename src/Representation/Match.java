package Representation;

//import java.util.UUID;

public class Match {

	private int id_match;
	private Equipe receveuse;
	private Equipe visiteuse;

	// private ArbitreCentral arbitreCentral;
	// private ArbitreAssistant arbitreAssistant1;
	// private ArbitreAssistant arbitreAssistant2;

	private int categorie;

	public Match(Equipe receveuse, Equipe visiteuse,
			ArbitreCentral arbitreCentral, ArbitreAssistant arbitreAssistant1,
			ArbitreAssistant arbitreAssistant2, int categorie) throws Exception {
		if (receveuse.equals(visiteuse)
				|| arbitreCentral.equals(arbitreAssistant1)
				|| arbitreCentral.equals(arbitreAssistant2)
				|| arbitreAssistant1.equals(arbitreAssistant2)) {
			throw new Exception("Erreur dans la construction du Match !");
		}
		this.receveuse = receveuse;
		this.visiteuse = visiteuse;
		this.categorie = categorie;
	}

	public int getCategorie() {
		return this.categorie;
	}

	public int getID() {
		return this.id_match;
	}

	public Equipe getReceveuse() {
		return this.receveuse;
	}

	public Equipe getVisiteuse() {
		return this.visiteuse;
	}

	/*public ArbitreCentral getArbitreCentral() {
		return this.arbitreCentral;
	}

	public ArbitreAssistant getArbitreAssistant1() {
		return this.arbitreAssistant1;
	}

	public ArbitreAssistant getArbitreAssistant2() {
		return this.arbitreAssistant2;
	}*/

}
