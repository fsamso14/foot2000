package Representation;

public class Arbitre {

	private CategorieArbitre categorie;

	private int arbitreID;
	private String licence;
	private String nom;
	private String prenom;

	// private String adresse;
	private Club club;
	
	private ArbitreDisponibilite disponibilites;

	// CONSTRUCTEUR
	/*
	 * public Arbitre(CategorieArbitre categorie, int arbitreID, String club,
	 * String nom, String prenom, String adresse, Ville ville) { this.categorie
	 * = categorie; this.arbitreID = arbitreID; this.club = club; this.nom =
	 * nom; this.prenom = prenom; this.adresse = adresse; this.ville = ville; }
	 */

	public Arbitre(CategorieArbitre categorie, int arbitreID, String licence, String nom, String prenom,Club club) {
		this.categorie = categorie;
		this.arbitreID = arbitreID;
		this.licence = licence;
		this.club = club;
		this.nom = nom;
		this.prenom = prenom;
		//this.ville=v;
		this.disponibilites = new ArbitreDisponibilite();
	}

	public CategorieArbitre getCategorie() {
		// TODO Auto-generated method stub
		return this.categorie;
	}

	public int getArbitreID() {
		// TODO Auto-generated method stub
		return this.arbitreID;
	}

	public Club getClub() {
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

	public String getLicence() {
		// TODO Auto-generated method stub
		return this.licence;
	}
	
	public boolean getDispo(int jour){
		return this.disponibilites.disponible(jour);
	}
	public void setDispo(boolean dispo,int jour){
		this.disponibilites.setDispo(dispo, jour);
	}

	public void setCategorie(CategorieArbitre c) {
		// TODO Auto-generated method stub
		this.categorie = c;
	}

	public void setArbitreID(int i) {
		// TODO Auto-generated method stub
		this.arbitreID = i;
	}

	public void setClub(Club c) {
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
	
}
