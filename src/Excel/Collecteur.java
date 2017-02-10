package Excel;

import java.io.IOException;
import java.util.HashMap;

import Representation.Arbitre;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public interface Collecteur<T> {
	
	public Workbook getWorkbook();

	public void setWorkbook(Workbook w);

	public String getAdresseFichier();

	public void setAdresseFichier(String adresseFichier);
	
	//public HashMap<T,T> getData() throws BiffException, IOException;

}
