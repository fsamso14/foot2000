package Representation;

public interface IArbitre {
	
	//GETTER
	int getCategorie();
	String getArbitreID();
	String getClub();
	String getNom();
	String getPrenom();
	String getAdresse();
	
	//SETTER
	void setCategorie(int c);
	void setArbitreID(String i);
	void setClub(String c);
	void setNom(String n);
	void setPrenom(String p);
	void setAdresse(String a);
	
}
