package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import Representation.Club;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class CollecteurClubs implements Collecteur{

	
	Workbook workbook;
	public	static String adresseFichier = "C:\\Users\\Mat\\Desktop\\Final Final\\Clubs.xls";
			
			/*"C:\\Users\\Mat\\Desktop\\Projets\\Foot2000"
			+ "\\Projet Logiciel Désignations CDA EMN\\Annexes"
			+ "\\DistancesClubs.xls";*/

	//String adresseFichierArbitre = "/Users/thaianthantrong/Documents/A3/Projet d'Option/Projet Logiciel DeÌ�signations CDA EMN/Annexes/Exemple Fichier Arbitres 2015 2016_2015 09 08.xlsx";

	public CollecteurClubs() throws BiffException, IOException {
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

	
	


	
	
	
	
	public HashMap<String,Club> getData() throws BiffException, IOException {
		HashMap<String,Club> clubs=new  HashMap<String,Club>();
		CollecteurClubs collecteur = new CollecteurClubs();
		Sheet sheet1 = collecteur.getWorkbook().getSheet(0);
		
		CollecteurGroupements c=new CollecteurGroupements();
		HashMap<String, ArrayList<String>> groupements=c.getData();
		Set<String> cle=groupements.keySet();
		
		
		
		for(int i=1;i<sheet1.getRows();i++){
			ArrayList<String> dataClub=new ArrayList<String>();
			String clubID=sheet1.getCell(0,i).getContents();
			//String nom=sheet1.getCell(1,i).getContents();
			String groupementID="0";
			
			for(String s : cle ){
				if(groupements.get(s).contains(clubID)){
					groupementID=s;
				}
			}
			
			String lat=sheet1.getCell(5, i).getContents().replaceAll(",", ".");
			
			String longi=sheet1.getCell(6, i).getContents().replaceAll(",", ".");
			
			Club club=new Club(clubID,groupementID,lat,longi);
			clubs.put(clubID, club);
		}
		
		
		collecteur.getWorkbook().close();
		return clubs;
	}
	
	public double getDistance(Club club1,Club club2){
		String lat1=club1.getLatitude();
		double lat11=Double.parseDouble(lat1);
		String long1=club1.getLongitude();
		double long11=Double.parseDouble(long1);
		
		String lat2=club2.getLatitude();
		double lat22=Double.parseDouble(lat2);
		String long2=club2.getLongitude();
		double long22=Double.parseDouble(long2);
		
		double distance=6378137*Math.acos(Math.sin(lat11*(Math.PI/180))*Math.sin(lat22*(Math.PI/180))
				+Math.cos(lat11*(Math.PI/180))*Math.cos(lat22*(Math.PI/180))*Math.cos((long22-(long11))*(Math.PI/180)));
		return (distance+0.15*distance)*Math.pow(10,-3);		
	}
	
	
	public HashMap<String,HashMap<String,Double>> distances() throws BiffException, IOException{
		HashMap<String,HashMap<String,Double>> mat=new HashMap<String,HashMap<String,Double>>();
		CollecteurClubs collecteur = new CollecteurClubs();
		HashMap<String,Club> dist=collecteur.getData();
		for(String s:dist.keySet()){
			//System.out.println(s);
			HashMap<String,Double> d=new HashMap<String,Double>();
			for(String u:dist.keySet()){
				
				if(s.contains(u)){
					d.put(u,0.0);
					
				}
				else{
					d.put(u,collecteur.getDistance(dist.get(s), dist.get(u)));
				}
				mat.put(s,d);
			}
		}
		collecteur.getWorkbook().close();
		return mat;		
	}
	
	public static void main(String[] args) throws BiffException, IOException {
		CollecteurClubs c = new CollecteurClubs();
		
		System.out.println(c.getDistance(c.getData().get("500041"),c.getData().get("501904")));
		System.out.println(c.distances().get("500041").get("502022"));
	}

}
