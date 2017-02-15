package Representation;

import java.util.HashMap;

public class Club {
	public static HashMap<String,HashMap<String,Double>> distances;
	public String id;
	public String groupement;
	public String latitude;
	public String longitude;
	
	//public String nom;
	
	
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public Club(String id, String groupement, String latitude,String longitude){
		this.id=id;
		this.latitude=latitude;
		this.longitude=longitude;
		//this.nom=nom;
		this.groupement=groupement;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGroupement() {
		return groupement;
	}
	public void setGroupement(String groupement) {
		this.groupement = groupement;
	}
	
	
	
	
}
