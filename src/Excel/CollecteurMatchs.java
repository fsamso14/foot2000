package Excel;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import Representation.Arbitre;
import Representation.ArbitreDisponibilite;
import Representation.CategorieArbitre;
import Representation.Club;
import Representation.ListeCategorieArbitre;
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
	public	static String adresseFichier = "C:\\Users\\Mat\\Desktop\\FakeTest\\Matchs.xls";


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
			case "U19R":
				idcat=ListeCategorieMatch.U19R;
				break;
			case "U18A":
				idcat=ListeCategorieMatch.U18A;
				break;
			case "U18B":
				idcat=ListeCategorieMatch.U18B;
				break;
			case "U16":
				idcat=ListeCategorieMatch.U16;
				break;
			case "U15":
				idcat=ListeCategorieMatch.U15;
				break;
			default:
				idcat=0;
			}

			if(idcat!=0){
				Club receveur=clubs.get(idClubReceveur);
				Club visiteur=clubs.get(idClubVisiteur);
				Match match=new Match(numero,receveur,visiteur,idcat);

				String horaire=sheet.getCell(14,j).getContents();
				String jour=sheet.getCell(15,j).getContents();
				int creneau;
				if(jour.contains("Samedi")){

					switch(horaire){
					case "14H":
						creneau=Match.SAMEDI_14;
						break;
					case "16H":
						creneau=Match.SAMEDI_16;
						break;
					case "18H":
						creneau=Match.SAMEDI_18;
						break;
					case "20H":
						creneau=Match.SAMEDI_20;
						break;
					default:
						creneau=Match.AUTRE_CRENEAU;
					}
					if(jour.contains("Dimanche")){
						
						switch(horaire){
						case "10H30":
							creneau=Match.DIMANCHE_10_30;
							break;
						case "13H":
							creneau=Match.DIMANCHE_13;
							break;
						case "15H":
							creneau=Match.DIMANCHE_15;
							break;
						default:
							creneau=Match.AUTRE_CRENEAU;
						}
					}
					match.setCreneau(creneau);
					matchs.put(k, match);
					k++;
				}			
			}
		}
			collecteur.getWorkbook().close();

			return matchs;
		}
		
	


	public static void main(String[] args) throws Exception {
		CollecteurMatchs c = new CollecteurMatchs();
		System.out.println(c.getData().get(3).getCreneau());
	}
}
