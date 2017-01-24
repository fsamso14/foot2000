package Representation;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class ArbitreDisponibilite {
	public static final int SAMEDI_MATIN =0;
	public static final int SAMEDI_APRES_MIDI=1;
	public static final int DIMANCHE_MATIN=2;
	public static final int DIMANCHE_APRES_MIDI=3;
	public boolean[] dispos;
	
	public ArbitreDisponibilite(boolean samediMatin,boolean samediApresMidi, boolean dimancheMatin, boolean dimancheApresMidi){
		this.dispos= new boolean [4];
		this.dispos[0] = samediMatin;
		this.dispos[1] = samediApresMidi;
		this.dispos[2] = dimancheMatin;
		this.dispos[3] = dimancheApresMidi;
	}
	public ArbitreDisponibilite(){
		this.dispos = new boolean [4];
		for (int i =0; i < 4 ; i ++){
			dispos[i] = true;
		}
	}
	
	public boolean disponible(int jour){
		return dispos[jour];
	}
	
	public void setDispo(boolean dispo, int jour){
		this.dispos[jour] = dispo;
	}
}
