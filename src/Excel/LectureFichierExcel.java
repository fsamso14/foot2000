package Excel;

import java.io.File;

import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * Cette classe lit les �l�ments contenus dans un fichier xls  (!!! pas xlsx !!!)
 * @author Mat
 *
 */
public class LectureFichierExcel {


	public static void main(String[] args) throws BiffException, IOException {
		/*Workbook workbook = null;
		try {
			/* R�cup�ration du classeur Excel (en lecture) (!!!format xls !!!) */
			/*workbook = Workbook.getWorkbook(new File("C:\\Users\\Mat\\Desktop\\Foot2000"
					+ "\\Projet Logiciel D�signations CDA EMN\\Annexes"
					+ "\\Exemple Fichier Arbitres 2015 2016_2015 09 08.xls"));

			/* Un fichier excel est compos� de plusieurs feuilles, on y acc�de de la mani�re suivante*/
			/*Sheet sheet = workbook.getSheet(0);


			System.out.println("Donn�es du fichier Excel :");
			for(int i=0;i<sheet.getColumns();i++){
				for(int j=1;j<sheet.getRows();j++){
					Cell contenu=sheet.getCell(i,j);
					System.out.println(contenu.getContents());
				}
			}
			
			/*System.out.println("Nb colonnes :"+sheet.getColumns());
			System.out.println("Nb lignes :"+sheet.getRows());*/
			

		/*} 
		catch (BiffException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			if(workbook!=null){
				/* On ferme le worbook pour lib�rer la m�moire */
			/*	workbook.close(); 
			}*/
			
			CollecteurArbitre c= new CollecteurArbitre();
			
			System.out.println(c.getID_ArbitreCat("D2"));
		}
		
		
	
	

}

