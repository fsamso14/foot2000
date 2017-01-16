package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Collecteur {
	
	Workbook workbook;
	
	public Collecteur() throws BiffException, IOException{
		this.workbook =Workbook.getWorkbook(new File("C:\\Users\\Mat\\Desktop\\Projets\\Foot2000"
				+ "\\Projet Logiciel Désignations CDA EMN\\Annexes"
				+ "\\Exemple Fichier Arbitres 2015 2016_2015 09 08.xls"));;
		
	}
	
	public Workbook getWorkbook(){
		return workbook;		
	}
	
	public HashMap<String,Integer> getArbitreID() throws BiffException, IOException{
		HashMap<String,Integer> arbitreID=new HashMap<String,Integer>();
		Collecteur collecteur=new Collecteur();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		for(int i=6;i<7;i++){
			for(int j=1;j<sheet.getRows();j++){
				Cell noms=sheet.getCell(6,j);
				Cell prenoms=sheet.getCell(7,j);
				String key=noms.getContents()+" "+prenoms.getContents();
				
				arbitreID.put(key, j);
			}
		}
		collecteur.getWorkbook().close(); 
		return arbitreID;
	}
	
	
	
	public static void main(String[] args) throws BiffException, IOException {
		Collecteur c=new Collecteur();
		System.out.println(c.getArbitreID());
		//System.out.println("Nb d'arbitres "+c.getArbitreID().size());
		
	}

}
