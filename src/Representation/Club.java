package Representation;

import java.util.HashMap;

public class Club {
	public static HashMap<Integer,HashMap<Integer,Double>> distances;
	public int id;
	public int groupement;
	public String nom;
	public Club(int id, int groupement, String nom){
		this.id=id;
		this.nom=nom;
		this.groupement=groupement;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupement() {
		return groupement;
	}
	public void setGroupement(int groupement) {
		this.groupement = groupement;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
}
