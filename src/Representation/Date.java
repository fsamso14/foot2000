package Representation;


/**
 * Date pour une année donnée
 * @author thaianthantrong
 *
 */
public class Date {
	
	private int jour;
	private int mois;
	
	public Date(int jour, int mois){
		this.jour = jour;
		this.mois = mois;
	}
	
	public int getJour(){
		return this.jour;
	}
	
	public int getMois(){
		return this.mois;
	}
	
	/**
	 * retourne la date la plus récente
	 * @param d1
	 * @param d2
	 */
	public Date compareTo(Date d1, Date d2){
		Date date;
		if(d1.getMois() > d2.getMois()){
			date = d1;
		}
		else{
			if(d1.getMois() < d2.getMois()){
				date = d2;
			}
			else{
				//(d1.getMois() == d2.getMois()){
					if(d1.getJour() > d2.getJour()){
						date = d1;
					}
					else{
						if(d1.getJour() < d2.getJour()){
							date = d2;
						}
						else{
							date = d1; //par défaut
						}
					}
					
			}
		}
			return date;
	}
	
	public String toString(){
		return this.jour + "/" + this.mois;
	}

}
