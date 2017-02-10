package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Representation.Arbitre;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class CollecteurGroupements implements Collecteur{

	Workbook workbook;
	String adresseFichier = "C:\\Users\\Mat\\Desktop\\FakeTest\\Liste des groupements.xls";

	//String adresseFichierArbitre = "/Users/thaianthantrong/Documents/A3/Projet d'Option/Projet Logiciel DeÌ�signations CDA EMN/Annexes/Exemple Fichier Arbitres 2015 2016_2015 09 08.xlsx";

	public CollecteurGroupements() throws BiffException, IOException {
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
	
	
	public HashMap<String, ArrayList<String>>getData() throws BiffException, IOException{
		HashMap<String, ArrayList<String>> groupement = new HashMap<String, ArrayList<String>>();
		CollecteurGroupements collecteur = new CollecteurGroupements();
		
		Sheet sheet = collecteur.getWorkbook().getSheet(1);
		String groupID=sheet.getCell(0,2).getContents();
		ArrayList<String> clubsID= new ArrayList<String>();
		clubsID.add(sheet.getCell(2,2).getContents());
		
		for(int i=2;i<sheet.getRows();i++){		
			String groupIDtemp=sheet.getCell(0,i).getContents();
			
			
			if(groupIDtemp.isEmpty()){
				clubsID.add(sheet.getCell(2,i).getContents());				
			}
			else{				
				groupement.put(groupID, clubsID);
				groupID=sheet.getCell(0,i).getContents();
				clubsID= new ArrayList<String>();
				clubsID.add(sheet.getCell(2,i).getContents());
			}
			
		}
		
		collecteur.getWorkbook().close();
		return groupement;		
	}
	
	
	public static void main(String[] args) throws BiffException, IOException {
		CollecteurGroupements c=new CollecteurGroupements();
		//System.out.println(c.getData().size());
		System.out.println(c.getData().get("581193"));
		
	}

}
