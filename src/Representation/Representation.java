package Representation;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import Excel.CollecteurArbitres;
import Excel.CollecteurClubs;
import Excel.CollecteurMatchs;
import jxl.read.biff.BiffException;

public class Representation {
	/** Jour de la saison */
	public int day;
	
	/** Liste des matchs � faire */
	public Match[] matchs;
	
	/** Liste des arbitres */
	public Arbitre[] arbitres;
	
	/** Distances entre les clubs*/
	public static HashMap<String,HashMap<String,Double>> distances;
	
	public Date samedi;
	
	public Representation() throws Exception{
		CollecteurArbitres ca=new CollecteurArbitres();
		CollecteurMatchs cm= new CollecteurMatchs();
		CollecteurClubs cc=new CollecteurClubs();
		
		this.distances=cc.distances();
		
		HashMap<Integer, Arbitre> arbitreH = ca.getData();
		this.arbitres= new Arbitre[arbitreH.size()];
		for(int i=1;i<arbitreH.size()+1;i++){
			
			this.arbitres[i-1]=arbitreH.get(i);
		}
		
		
		HashMap<Integer, Match> matcH = cm.getData();
		this.matchs=new Match[matcH.size()];
		for(int i=1;i<matcH.size()+1;i++){
			this.matchs[i-1]=matcH.get(i);
		}
		
	}
	
	public int getNbMatchs(){
		return matchs.length;
	}
	public int getNbArbitres(){
		return arbitres.length;
	}
	public Arbitre getArbitre(int i){
		return this.arbitres[i-1];
	}
	public Match getMatch(int i){
		return this.matchs[i-1];
	}
	
	public HashMap<String,HashMap<String,Double>> distances() throws BiffException, IOException{
		HashMap<String,HashMap<String,Double>> distances=new HashMap<String,HashMap<String,Double>>();
		CollecteurClubs collecteur = new CollecteurClubs();
		HashMap<String,Club> dist=collecteur.getData();
		
		for(String s:dist.keySet()){
			HashMap<String,Double> d=new HashMap<String,Double>();
			for(String u:dist.keySet()){
					
				if(s.contains(u)){
					d.put(u,0.0);
					
				}
				else{
					d.put(u,collecteur.getDistance(dist.get(s), dist.get(u)));
				}
				
					distances.put(s,d);
			}
			
		}
		collecteur.getWorkbook().close();
		return distances;		
	}
	
	public Match[] getMatchs(){
		return this.matchs;
	}
	public Arbitre[] getArbitres(){
		return this.arbitres;
	}
	
	public static void main(String[] args) throws Exception {
		Representation r=new Representation();
		//System.out.println(r.getArbitre(32).getNom());
		
	}
}
