package Representation;

public interface IArbitre {
	
	//GETTER
	CategorieArbitre getCategorie();
	int getArbitreID();
	String getClub();
	String getNom();
	String getPrenom();
	String getAdresse();
	
	//SETTER
	void setCategorie(CategorieArbitre c);
	void setArbitreID(int i);
	void setClub(String c);
	void setNom(String n);
	void setPrenom(String p);
	void setAdresse(String a);
	
}
