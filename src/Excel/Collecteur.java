package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

// Filtrer ce qui appartient dans le cahier des charger

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
	
	/**
	 * 
	 * @return liste des correspondances entre les numéros de licence
	 * et les ID des arbitres
	 * @throws BiffException
	 * @throws IOException
	 */
	public HashMap<String,Integer> listID() throws BiffException, IOException{
		HashMap<String,Integer> l=new HashMap<String,Integer>();
		Collecteur collecteur=new Collecteur();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		for(int j=1;j<sheet.getRows();j++){			
			String key=sheet.getCell(2,j).getContents();
			l.put(key, j);
		}

		collecteur.getWorkbook().close(); 
		return l;
	}
	
	/**
	 * 
	 * 
	 * @return Dictionnaire des arbitres et de leur numéro de licence
	 * @throws BiffException
	 * @throws IOException
	 */
	public HashMap<String,String> getArbitreLicense() throws BiffException, IOException{
		HashMap<String,String> arbitreID=new HashMap<String,String>();
		Collecteur collecteur=new Collecteur();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		for(int i=6;i<7;i++){
			for(int j=1;j<sheet.getRows();j++){
				Cell noms=sheet.getCell(6,j);
				Cell prenoms=sheet.getCell(7,j);
				String key=noms.getContents()+" "+prenoms.getContents();	
				String value =sheet.getCell(2,j).getContents();
				arbitreID.put(key, value);
			}
		}
		collecteur.getWorkbook().close(); 
		return arbitreID;
	}
	
	/**
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public HashMap<String,int[]> getArbitreCat(String cat) throws BiffException, IOException{
		HashMap<String,int[]> arbitreCat=new HashMap<String,int[]>();
		Collecteur collecteur=new Collecteur();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		return arbitreCat;
	}


	public static void main(String[] args) throws BiffException, IOException {
		Collecteur c=new Collecteur();
		//System.out.println(c.listID());
		System.out.println("Nb d'arbitres "+c.listID().size());

	}

}
