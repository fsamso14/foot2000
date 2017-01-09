package Excel;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


/**
 * Cette classe récupère les données d'un fichier xls et les retourne dans un nouveau fichier xls qu'elle créée (!!! pas xlsx !!!)
 * @author Mat
 *
 */
public class EcrireFichierExcel {

	public static void main(String[] args) {
		WritableWorkbook workbook1 = null;
		try {
			/* On créé un nouveau worbook et on l'ouvre en écriture */
			workbook1 = Workbook.createWorkbook(new File("C:\\Users\\Mat\\Desktop\\exemple2.xls"));

			/* On créé une nouvelle feuille (test en position 0) et on l'ouvre en écriture */
			WritableSheet sheet = workbook1.createSheet("test", 0); 

			/* Creation d'un champ au format texte */
			String[] titreColonnes= {"Arbitre","ID","Grade","Match"};
			for(int i=0;i<4;i++){
				Label label = new Label(i, 0, titreColonnes[i]);// Colonne puis Ligne
				sheet.addCell(label);
			}


			// Extraire les valeurs du fichier Excel
			try {
				Workbook workbook2 = Workbook.getWorkbook(new File("C:\\Users\\Mat\\Desktop\\exemple.xls"));
				Sheet sheet2 = workbook2.getSheet(0);
				for(int i=0;i<3;i++){
					for(int j=1;j<4;j++){
						// les ajouter dans la nouvelle feuille Excel
						Cell a1 = sheet2.getCell(i,j); 
						Label label = new Label(i,j,a1.getContents());
						sheet.addCell(label);
					}
				}
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



			/* On ecrit le classeur */
			workbook1.write(); 

		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (RowsExceededException e) {
			e.printStackTrace();
		}
		catch (WriteException e) {
			e.printStackTrace();
		}
		finally {
			if(workbook1!=null){
				/* On ferme le worbook pour libérer la mémoire */
				try {
					workbook1.close();
				} 
				catch (WriteException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}

	}

}