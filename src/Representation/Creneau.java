package Representation;

public class Creneau {
	
	private Match[] listeMatchs;
	
	private ArbitreWithHashMap listeArbitres;
	
	private Date date;
	
	public Creneau(Match[] listeMatchs,ArbitreWithHashMap listeArbitres, Date date){
		this.listeMatchs = listeMatchs;
		this.listeArbitres = listeArbitres;
		this.date = date;
	}

}
