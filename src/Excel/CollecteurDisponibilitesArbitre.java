package Excel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import Representation.ArbitreDisponibilite;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class CollecteurDisponibilitesArbitre implements Collecteur {

	Workbook workbook;
	public static String adresseFichier = "C:\\Users\\Fab\\Desktop\\FakeTest\\IndisposArbitres.xls";

	public CollecteurDisponibilitesArbitre() throws BiffException, IOException {
		WorkbookSettings ws = new WorkbookSettings();
		ws.setSuppressWarnings(true);
		this.workbook = Workbook.getWorkbook(new File(adresseFichier), ws);
	}

	@Override
	public Workbook getWorkbook() {
		// TODO Auto-generated method stub
		return workbook;
	}

	@Override
	public void setWorkbook(Workbook w) {
		// TODO Auto-generated method stub
		this.workbook = w;
	}

	@Override
	public String getAdresseFichier() {
		// TODO Auto-generated method stub
		return adresseFichier;
	}

	@Override
	public void setAdresseFichier(String adresseFichierDispos) {
		// TODO Auto-generated method stub
		this.adresseFichier = adresseFichierDispos;
	}
	
	public void dataMaking(){
		
	}

	public HashMap<String, ArbitreDisponibilite> getData()
			throws BiffException, IOException {
		HashMap<String, ArbitreDisponibilite> dispos = new HashMap<String, ArbitreDisponibilite>();
		CollecteurDisponibilitesArbitre c = new CollecteurDisponibilitesArbitre();
		Sheet sheet = c.getWorkbook().getSheet(0);

		for (int i = 1; i < sheet.getRows(); i++) {

			String licence = sheet.getCell(0, i).getContents();
			boolean[] disp = new boolean[7];
			for (int j = 1; j < sheet.getColumns(); j++) {
				
				if (!sheet.getCell(j, i).getContents().isEmpty()) {
					disp[j - 1] = false;
				} else {
					disp[j - 1] = true;
				}
			}
			ArbitreDisponibilite ad = new ArbitreDisponibilite(disp[0],
					disp[1], disp[2], disp[3], disp[4], disp[5], disp[6]);
			dispos.put(licence, ad);

		}
		c.getWorkbook().close();
		return dispos;
	}
	
	public HashMap<String,ArbitreDisponibilite> disponibilite(){
		
		return null;		
	}

	public static void main(String[] args) throws BiffException, IOException {
		CollecteurDisponibilitesArbitre c = new CollecteurDisponibilitesArbitre();

		System.out.println(c.getData().size());
		System.out.println(c.getData().get("2543369222").disponible(1));
	}

}
