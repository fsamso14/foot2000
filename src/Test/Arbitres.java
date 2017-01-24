package Test;

import java.io.IOException;
import java.util.HashMap;

import jxl.read.biff.BiffException;
import Excel.CollecteurArbitre;

/**
 * Liste des arbitres
 * @author thaianthantrong
 *
 */
public class Arbitres {

	private HashMap<String, Integer> nLicenceID ;
	private HashMap<String, String> nomLicence;
	private HashMap<Integer, String> categorie;
	
	public Arbitres() throws BiffException, IOException{
		CollecteurArbitre collecteur = new CollecteurArbitre();
		this.nLicenceID = collecteur.listLicence_ID();
		this.nomLicence = collecteur.getNomArbitre_License(); 
		
		
		//RECUPERATION CATEGORIE ET CLUB
	}
	
	
	public HashMap<String, Integer> getNLicenceID(){
		return this.nLicenceID;
	}
	
	public HashMap<String, String> getNomLicence(){
		return this.nomLicence;
	}
	
	public HashMap<Integer, String> getCategorie(){
		return this.categorie;
	}


}
