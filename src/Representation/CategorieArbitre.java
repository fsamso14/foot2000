package Representation;
public class CategorieArbitre {

	private String nomCategorie;
	private int kilometrage;
	private int grade;

	public CategorieArbitre(String nomCategorie, int kilometrage) {
		this.nomCategorie = nomCategorie;
		this.kilometrage = kilometrage;
	}
	
	public int getGrade(){
		return grade;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public int getKilometrage() {
		return this.kilometrage;
	}

	public void setNomCategorie(String n) {
		this.nomCategorie = n;
	}

	public void setKilometrage(int k) {
		this.kilometrage = k;
	}
}
