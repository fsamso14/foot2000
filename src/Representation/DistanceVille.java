package Representation;

public class DistanceVille {
	
	//Distance entre chaque ville
	private int nbVilles;
	private int[][] distance;
	
	/*public DistanceVille(int nbVilles){
		this.nbVilles = nbVilles;
		distance = new int[nbVilles][nbVilles];
	}*/
	
	
	/*			Nantes | 	Orvault 	| 	Carquefou 		| Chapelle-sur-Erdre
	 * Nantes	0		d(Nantes, Orvault)	d(Nantes, Carq)	d(Nantes, Chapelle/Erdre)
	 * Orvault			0
	 * Carquefou					0
	 * Chapelle-sur-Erdre						0
	 */
	public DistanceVille(){
		distance = new int[4][4];
		
	}

}
