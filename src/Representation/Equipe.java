package Representation;

public class Equipe {

	private String nomEquipe;
	private int categorieEquipe;
	private Club club;
	
	public Equipe(String nomEquipe, int categorieEquipe, Club club){
		this.nomEquipe = nomEquipe;
		this.categorieEquipe = categorieEquipe;
		this.club=club;
	}

	public String getNomEquipe() {
		return nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	public int getCategorieEquipe() {
		return categorieEquipe;
	}

	public void setCategorieEquipe(int categorieEquipe) {
		this.categorieEquipe = categorieEquipe;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
}
