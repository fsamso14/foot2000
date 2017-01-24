package Excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Classe collectant les donnï¿½es pertinentes dans les fichiers Excel appropriï¿½s
 * afin de rï¿½soudre le problï¿½me
 * 
 * @author Mat
 *
 */

public class CollecteurArbitre {

	Workbook workbook;
	// String adresseFichierArbitre="C:\\Users\\Mat\\Desktop\\Projets\\Foot2000"
	// + "\\Projet Logiciel Dï¿½signations CDA EMN\\Annexes"
	// + "\\Exemple Fichier Arbitres 2015 2016_2015 09 08.xls";

	String adresseFichierArbitre = "/Users/thaianthantrong/Documents/A3/Projet d'Option/Projet Logiciel DeÌ�signations CDA EMN/Annexes/Exemple Fichier Arbitres 2015 2016_2015 09 08.xlsx";

	public CollecteurArbitre() throws BiffException, IOException {
		this.workbook = Workbook.getWorkbook(new File(adresseFichierArbitre));
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook w) {
		this.workbook = w;
	}

	public String getAdresseFichierArbitre() {
		return adresseFichierArbitre;
	}

	public void setAdresseFichierArbitre(String adresseFichierArbitre) {
		this.adresseFichierArbitre = adresseFichierArbitre;
	}

	/**
	 * 
	 * @return liste des correspondances entre les numï¿½ros de licence et les ID
	 *         des arbitres
	 * @throws BiffException
	 * @throws IOException
	 */

	public HashMap<String, Integer> listLicence_ID() throws BiffException,
			IOException {
		HashMap<String, Integer> l = new HashMap<String, Integer>();
		CollecteurArbitre collecteur = new CollecteurArbitre();

		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		int k = 1;
		for (int j = 1; j < sheet.getRows(); j++) {
			String key = sheet.getCell(2, j).getContents();
			if (!key.isEmpty()) {
				l.put(key, k);
				k++;
			}
		}

		collecteur.getWorkbook().close();
		return l;
	}

	/**
	 * 
	 * 
	 * @return Dictionnaire des arbitres et de leur numï¿½ro de licence
	 * @throws BiffException
	 * @throws IOException
	 */
	public HashMap<String, String> getNomArbitre_License()
			throws BiffException, IOException {
		HashMap<String, String> arbitreID = new HashMap<String, String>();
		CollecteurArbitre collecteur = new CollecteurArbitre();

		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		for (int i = 6; i < 7; i++) {
			for (int j = 1; j < sheet.getRows(); j++) {
				Cell noms = sheet.getCell(6, j);
				Cell prenoms = sheet.getCell(7, j);
				String key = noms.getContents() + " " + prenoms.getContents();
				String value = sheet.getCell(2, j).getContents();
				arbitreID.put(key, value);
			}
		}
		collecteur.getWorkbook().close();
		return arbitreID;
	}

	/**
	 * @param cat
	 *            ï¿½gorie de l'arbitre D1, D2 ...
	 * @return liste des identifiants des arbitres de la catï¿½gorie souhaitï¿½e
	 * @throws BiffException
	 * @throws IOException
	 */
	public ArrayList<String> getID_ArbitreCat(String cat) throws BiffException,
			IOException {
		ArrayList<String> arbitreCat = new ArrayList<String>();
		CollecteurArbitre collecteur = new CollecteurArbitre();
		Sheet sheet = collecteur.getWorkbook().getSheet(0);
		for (int i = 1; i < sheet.getRows(); i++) {
			Cell catego = sheet.getCell(1, i);
			String categorie = catego.getContents();
			if (categorie.equals(cat)) {
				arbitreCat.add(sheet.getCell(6, i).getContents());
			}
		}
		collecteur.getWorkbook().close();
		return arbitreCat;
	}
	
	

	public static void main(String[] args) throws BiffException, IOException {

		CollecteurArbitre c = new CollecteurArbitre();
		System.out.println();
		System.out.println(c.getID_ArbitreCat("D2"));

		// System.out.println("Nb d'arbitres "+c.listID().size());

	}

}
