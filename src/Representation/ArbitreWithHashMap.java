package Representation;

import java.util.HashMap;
import java.util.Set;

/**
 * Création de HashMap d'arbitres, avec possibilité de trouver un arbitre avec
 * la donnée seule de son identifiant
 * 
 * @author thaianthantrong
 *
 */
public class ArbitreWithHashMap {

	HashMap<Integer, Arbitre> map = new HashMap<Integer, Arbitre>();

	public ArbitreWithHashMap(Arbitre[] arbitres) {
		for (Arbitre arbitre : arbitres) {
			map = new HashMap<Integer, Arbitre>();
			map.put(arbitre.getArbitreID(), arbitre);
		}
	}

	/**
	 * Retourne l'arbitre ayant pour ID key
	 * @param key
	 * @return
	 */
	public Arbitre getArbitre(int key) {
		return this.map.get(key);
	}
	
	/**
	 * Retourne la liste d'arbitreID
	 * @return
	 */
	public Set<Integer> getAllArbitreID(){
		return this.map.keySet();
	}

}
