package Representation;
public class CategorieArbitre {

	private String nomCategorie;
	private int kilometrage;
	private int grade;
	private boolean assistant;

	public CategorieArbitre(String nomCategorie, int kilometrage, int grade,boolean assistant) {
		this.nomCategorie = nomCategorie;
		this.kilometrage = kilometrage;
		this.grade = grade;
		this.assistant= assistant;
	}
	public CategorieArbitre(String nomCategorie, int kilometrage, int grade) {
		this.nomCategorie = nomCategorie;
		this.kilometrage = kilometrage;
		this.grade = grade;
		this.assistant = false;
	}
	public int getGrade(){
		return this.grade;
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
	public boolean isAssistant(){
		return assistant;
	}
}
