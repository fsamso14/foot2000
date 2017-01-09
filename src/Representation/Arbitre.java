package Representation;
public class Arbitre implements IArbitre {

	private CategorieArbitre categorie;
	private String arbitreID;
	private String club;
	private String nom;
	private String prenom;
	private String adresse;

	// CONSTRUCTEUR
	public Arbitre(CategorieArbitre categorie, String arbitreID, String club,
			String nom, String prenom, String adresse) {
		this.categorie = categorie;
		this.arbitreID = arbitreID;
		this.club = club;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public CategorieArbitre getCategorie() {
		// TODO Auto-generated method stub
		return this.categorie;
	}

	public String getArbitreID() {
		// TODO Auto-generated method stub
		return this.arbitreID;
	}

	public String getClub() {
		// TODO Auto-generated method stub
		return this.club;
	}

	public String getNom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	public String getPrenom() {
		// TODO Auto-generated method stub
		return this.prenom;
	}

	public String getAdresse() {
		// TODO Auto-generated method stub
		return this.adresse;
	}

	public void setCategorie(CategorieArbitre c) {
		// TODO Auto-generated method stub
		this.categorie = c;
	}

	public void setArbitreID(String i) {
		// TODO Auto-generated method stub
		this.arbitreID = i;
	}

	public void setClub(String c) {
		// TODO Auto-generated method stub
		this.club = c;
	}

	public void setNom(String n) {
		// TODO Auto-generated method stub
		this.nom = n;
	}

	public void setPrenom(String p) {
		// TODO Auto-generated method stub
		this.prenom = p;
	}

	public void setAdresse(String a) {
		// TODO Auto-generated method stub
		this.adresse = a;
	}

}
