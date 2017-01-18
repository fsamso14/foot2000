package Excel;

import java.io.File;
import java.io.IOException;

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
 * @author Mat
 *
 */
public class Createur {
	
	static WritableWorkbook workbook;
	//String adresseFichier;
	
	public Createur(String adresseFichier) throws IOException{
		this.workbook= Workbook.createWorkbook(new File(adresseFichier));
	}
	
	public static void ecritureFichierExcel() throws BiffException, IOException, RowsExceededException, WriteException, IndexOutOfBoundsException{
		CollecteurMatchs c=new CollecteurMatchs();
		
		workbook=Workbook.createWorkbook(new File("C:\\Users\\Mat\\Desktop\\"
				+ "TEST_Exemple 1er week-end de compétition 2014-2015.xls"));
		
		WritableSheet sheet = workbook.createSheet("TEST", 0); 
		
		for(int i=0;i<c.getWorkbook().getSheet(0).getColumns();i++){
			
			for(int j=0;j<c.getWorkbook().getSheet(0).getRows();j++){
				
				Cell a=c.getWorkbook().getSheet(0).getCell(i,j);
				Label aJout=new Label(i,j,a.getContents());
				sheet.addCell(aJout);
			}
		}
		
		workbook.write();
		if(workbook!=null){
		workbook.close();
		}
	}
	
	public static void main(String[] args) throws RowsExceededException, BiffException, WriteException, IndexOutOfBoundsException, IOException {
		ecritureFichierExcel();
	}
	
}
