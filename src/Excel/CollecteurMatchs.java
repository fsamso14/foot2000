package Excel;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CollecteurMatchs {
	
	Workbook workbook;
	String adresseFichierArbitre = "C:\\Users\\Mat\\Desktop\\Projets\\Foot2000\\"
			+ "Projet Logiciel Désignations CDA EMN\\Annexes\\"
			+ "Exemple 1er week-end de compétition 2014-2015.xls";

	public CollecteurMatchs() throws BiffException, IOException{
		this.workbook =Workbook.getWorkbook(new File(adresseFichierArbitre));
		//this.workbook=Workbook.getWorkbook(new File(adresseFichierArbitre));

	}


	public Workbook getWorkbook(){
		return workbook;		
	}
	public void setWorkbook(Workbook w){
		this.workbook=w;
	}
	public String getAdresseFichierArbitre() {
		return adresseFichierArbitre;
	}
	public void setAdresseFichierArbitre(String adresseFichierArbitre) {
		this.adresseFichierArbitre = adresseFichierArbitre;
	}

}
