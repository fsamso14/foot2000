package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Representation.Arbitre;
import Representation.ArbitreDisponibilite;
import Representation.CategorieArbitre;
import Representation.Club;
import Representation.ListeCategorieArbitre;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 * Classe collectant les donnees pertinentes dans les fichiers Excel 
 * correspondant aux Arbitres
 * 
 * @author Mat
 *
 */

public class CollecteurArbitres implements Collecteur{

	Workbook workbook;

public	static String adresseFichier = "C:\\Users\\Fab\\Desktop\\FakeTest\\Arbitres.xls";


	/*"C:\\Users\\Mat\\Desktop\\Projets\\Foot2000"
			+ "\\Projet Logiciel Désignations CDA EMN\\Annexes"
			+ "\\Exemple Fichier Arbitres 2015 2016_2015 09 08.xls";*/

	//String adresseFichierArbitre = "/Users/thaianthantrong/Documents/A3/Projet d'Option/Projet Logiciel DeÌ�signations CDA EMN/Annexes/Exemple Fichier Arbitres 2015 2016_2015 09 08.xlsx";

	public CollecteurArbitres() throws BiffException, IOException {
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
	/**
	 * 
	 * 
	 * @return HashMap contenant les id des arbitres et l'object arbitre qui y est associé
	 * @throws BiffException
	 * @throws IOException
	 */


	public HashMap<Integer, Arbitre> getData() throws BiffException, IOException {
		HashMap<Integer, Arbitre> arbitres = new HashMap<Integer, Arbitre>();
		CollecteurArbitres collecteur = new CollecteurArbitres();
		CollecteurClubs c= new CollecteurClubs();
		CollecteurDisponibilitesArbitre col=new CollecteurDisponibilitesArbitre();
		
		Sheet sheet = collecteur.getWorkbook().getSheet(0);

		HashMap<String,Club> clubs=c.getData();
		HashMap<String,ArbitreDisponibilite> dispos=col.getData();

		int k = 1;
		for (int j = 1; j < sheet.getRows(); j++) {			
			String licence = sheet.getCell(2,j).getContents();			

			Club club=clubs.get(sheet.getCell(3,j).getContents());
			String nom= sheet.getCell(6,j).getContents();			
			String prenom= sheet.getCell(7,j).getContents();

			if (!licence.isEmpty()) {
				String categorie = sheet.getCell(1,j).getContents();				
				CategorieArbitre cat=null;


				switch (categorie){
				case "D1":
					cat= ListeCategorieArbitre.D1;
					break;
				case "D2":
					cat= ListeCategorieArbitre.D2;
					break;
				case "D3":
					cat= ListeCategorieArbitre.D3;
					break;			
				case "D4":
					cat= ListeCategorieArbitre.D4;
					break;
				case "AA1":
					cat= ListeCategorieArbitre.AA1;
					break;
				case "AA2":
					cat= ListeCategorieArbitre.AA2;
					break;
				case "U19R":
					cat= ListeCategorieArbitre.U19R;
					break;
				case "U18A":
					cat= ListeCategorieArbitre.U18A;
					break;
				case "U18B":
					cat= ListeCategorieArbitre.U18B;
					break;
				case "U16":
					cat= ListeCategorieArbitre.U16;
					break;
				case "U15":
					cat= ListeCategorieArbitre.U15;
					break;
				default:

				}
				Arbitre arbitre;
				if(dispos.containsKey(licence)){
					 arbitre=new Arbitre(cat,k,licence,nom,prenom,club,dispos.get(licence));
				}
				else{
					ArbitreDisponibilite ad=new ArbitreDisponibilite(true,true,true,true,true,true,true);
					 arbitre=new Arbitre(cat,k,licence,nom,prenom,club,ad);
				}
				
				arbitres.put(k, arbitre);
				k++;
			}
		}

		collecteur.getWorkbook().close();

		return arbitres;
	}

	public static void main(String[] args) throws BiffException, IOException {

		CollecteurArbitres c = new CollecteurArbitres();
		CollecteurClubs clubs = new CollecteurClubs();
		System.out.println(c.getData().size());

		//System.out.println(c.getData().get(6).getCategorie().getNomCategorie());
		
		// System.out.println("Nb d'arbitres "+c.listID().size());

	}


}
