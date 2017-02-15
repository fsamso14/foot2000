package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import Representation.Arbitre;
import Representation.ArbitreDisponibilite;
import Representation.CategorieArbitre;
import Representation.Club;
import Representation.ListeCategorieMatch;
import Representation.Match;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

/**
 * Classe collectant les donées pertinentes sur les matchs 
 * qui ont lieu lors d'un week-end
 * @author Mat
 *
 */
public class CollecteurMatchs implements Collecteur{

	Workbook workbook;
	static String adresseFichier = "C:\\Users\\Fab\\Desktop\\FakeTest\\Matchs.xls";


	/*+ "Projet Logiciel Désignations CDA EMN\\Annexes\\"
			+ "Exemple 1er week-end de compétition 2014-2015.xls";*/

	public CollecteurMatchs() throws BiffException, IOException{
		WorkbookSettings ws = new WorkbookSettings();
		ws.setSuppressWarnings(true);
		this.workbook =Workbook.getWorkbook(new File(adresseFichier),ws);
	}


	public Workbook getWorkbook(){
		return workbook;		
	}
	public void setWorkbook(Workbook w){
		this.workbook=w;
	}


	@Override
	public String getAdresseFichier() {
		// TODO Auto-generated method stub
		return adresseFichier;
	}


	@Override
	public void setAdresseFichier(String adresseFichierMatch) {
		// TODO Auto-generated method stub
		this.adresseFichier = adresseFichierMatch;
	}



	public HashMap<Integer, Match> getData() throws Exception {
		HashMap<Integer, Match> matchs = new HashMap<Integer, Match>();
		CollecteurMatchs collecteur = new CollecteurMatchs();
		CollecteurClubs c= new CollecteurClubs();


		Sheet sheet = collecteur.getWorkbook().getSheet(0);

		HashMap<String,Club> clubs=c.getData();


		int k = 1;
		for (int j = 1; j < sheet.getRows(); j++) {			
			String numero = sheet.getCell(6,j).getContents();			
			String idClubReceveur=sheet.getCell(8,j).getContents();
			String idClubVisiteur=sheet.getCell(11,j).getContents();
			String cat=sheet.getCell(1,j).getContents();
			
			int idcat;
			switch (cat){
			
			case "D1":
				idcat=ListeCategorieMatch.D1;
				break;
			case "D2":
				idcat=ListeCategorieMatch.D2;
				break;
			case "D3":
				idcat=ListeCategorieMatch.D3;
				break;			
			case "AA1":
				idcat=ListeCategorieMatch.AAD1;
				break;
			case "AA2":
				idcat=ListeCategorieMatch.AAD2;
				break;
			default:
				idcat=0;
			}
			Club receveur=clubs.get(idClubReceveur);
			Club visiteur=clubs.get(idClubVisiteur);
			Match match=new Match(numero,receveur,visiteur,idcat);
			matchs.put(k, match);
			k++;
		}

		collecteur.getWorkbook().close();

		return matchs;
	}
	
	public static void main(String[] args) throws Exception {
		CollecteurMatchs c= new CollecteurMatchs();
		System.out.println(c.getData().size());
		System.out.println(c.getData().get(1).getReceveuse().getId());
		System.out.println(c.getData().get(4).getVisiteuse().getId());
		System.out.println(c.getData().get(8).getCategorie());
	}

}
