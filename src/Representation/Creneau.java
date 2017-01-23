<<<<<<< HEAD
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
=======
package Representation;

public class Creneau {
	public static final int VENDREDI = 1;
	public static final int SAMEDI = 2;
	public static final int DIMANCHE = 3;
	
	public int jour;
	public int debut;
	public int fin;
}
>>>>>>> refs/heads/contraintes_fabian2
