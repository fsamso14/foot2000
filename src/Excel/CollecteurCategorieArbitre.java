package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class CollecteurCategorieArbitre implements Collecteur{

	
	Workbook workbook;
	String adresseFichier = "C:\\Users\\Mat\\Desktop\\FakeTest\\Arbitres.xls";
			
			/*"C:\\Users\\Mat\\Desktop\\Projets\\Foot2000"
			+ "\\Projet Logiciel Désignations CDA EMN\\Annexes"
			+ "\\Exemple Fichier Arbitres 2015 2016_2015 09 08.xls";*/

	//String adresseFichierArbitre = "/Users/thaianthantrong/Documents/A3/Projet d'Option/Projet Logiciel DeÌ�signations CDA EMN/Annexes/Exemple Fichier Arbitres 2015 2016_2015 09 08.xlsx";

	public CollecteurCategorieArbitre() throws BiffException, IOException {
		WorkbookSettings ws = new WorkbookSettings();
		ws.setSuppressWarnings(true);
		this.workbook = Workbook.getWorkbook(new File(adresseFichier),ws);
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook w) {
		this.workbook = w;
	}

	public String getAdresseFichier() {
		return adresseFichier;
	}

	public void setAdresseFichier(String adresseFichierArbitre) {
		this.adresseFichier = adresseFichierArbitre;
	}


	
	public HashMap getData() throws BiffException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
