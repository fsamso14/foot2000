package Excel;

import java.io.File;

import java.io.IOException;
import java.util.Calendar;

import Representation.Representation;
import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * Classe permettant de créer le fichier Excel résultat
 * 
 * @author Mat
 *
 */
public class Createur {

	public static String adresseFichier;
	public static WritableWorkbook workbook;
	public Representation r;

	// String adresseFichier;

	public Createur(String adresseFichier, Representation r) throws IOException {
		this.workbook = Workbook.createWorkbook(new File(adresseFichier));
		this.r = r;
	}

	public void ecritureFichierExcel() throws BiffException, IOException,
			RowsExceededException, WriteException, IndexOutOfBoundsException {

		CollecteurMatchs c = new CollecteurMatchs();
		/*
		 * adresseFichier = "Attribution_Arbitre_Matchs" +
		 * (Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) + "_" +
		 * (Calendar.getInstance().get(Calendar.MONTH)) + ".xls";
		 */

		workbook = Workbook.createWorkbook(new File(adresseFichier));

		WritableSheet sheet = workbook.createSheet("TEST", 0);

		for (int i = 0; i < c.getWorkbook().getSheet(0).getColumns(); i++) {

			for (int j = 0; j < c.getWorkbook().getSheet(0).getRows(); j++) {

				Cell a = c.getWorkbook().getSheet(0).getCell(i, j);
				Label aJout = new Label(i, j, a.getContents());
				sheet.addCell(aJout);

			}
		}

		for (int i = 1; i < c.getWorkbook().getSheet(0).getRows(); i++) {

			String numMatch = workbook.getSheet(0).getCell(6, i).getContents();
			for (int j = 1; j < r.getNbMatchs() + 1; j++) {
				if (r.getMatch(j).getNumMatch().contains(numMatch)) {
					try {
						Label ac = new Label(25, i,
								r.getMatch(i).getArbitres()[0].getNom()+" "
										+ r.getMatch(i).getArbitres()[0].getPrenom());
						sheet.addCell(ac);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						Label aa1 = new Label(26, i,
								r.getMatch(i).getArbitres()[1].getNom()+" "
										+ r.getMatch(i).getArbitres()[1].getPrenom());
						sheet.addCell(aa1);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					try {
						Label aa2 = new Label(27, i,
								r.getMatch(i).getArbitres()[2].getNom()+" "
										+ r.getMatch(i).getArbitres()[2].getPrenom());
						sheet.addCell(aa2);
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}

		}

		workbook.write();
		if (workbook != null) {
			workbook.close();
		}
	}

	public static void main(String[] args) throws RowsExceededException,
			BiffException, WriteException, IndexOutOfBoundsException,
			IOException {
		// ecritureFichierExcel();

	}

}
