package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Classe collectant les donées pertinentes sur les matchs qui ont lieu lors d'une semaine
 * @author Mat
 *
 */
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
	
	/**
	 * 
	 * @return la liste des identifiants des matchs en rapport avec leur numero
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public HashMap<String,Integer> getID_Numero() throws BiffException, IOException{
		HashMap<String,Integer> l=new HashMap<String,Integer>();
		CollecteurMatchs collecteur=new CollecteurMatchs();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		int k=1;
		for(int j=1;j<sheet.getRows();j++){			
			String key=sheet.getCell(6,j).getContents();
			if(!key.isEmpty()){
				l.put(key,k);
				k++;
			}
		}

		collecteur.getWorkbook().close(); 
		return l;		
	}
	
	
	public static void main(String[] args) throws BiffException, IOException {
		CollecteurMatchs c=new CollecteurMatchs();
		System.out.println(c.getID_Numero());
		System.out.println("Nb de macths "+c.getID_Numero().size());
	}
}
