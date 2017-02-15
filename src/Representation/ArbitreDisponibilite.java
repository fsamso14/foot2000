
package Representation;

public class ArbitreDisponibilite {

	public static final int SAMEDI_14H = 0;
	public static final int SAMEDI_16H = 1;
	public static final int SAMEDI_18H = 2;
	public static final int SAMEDI_20H = 3;
	public static final int DIMANCHE_10H = 4;
	public static final int DIMANCHE_13H = 5;
	public static final int DIMANCHE_15H = 6;
	public boolean[] dispos;

	public ArbitreDisponibilite(boolean samedi14h, boolean samedi16h,
			boolean samedi18h, boolean samedi20h, boolean dimanche10h,
			boolean dimanche13h, boolean dimanche15h) {
		this.dispos = new boolean[7];
		this.dispos[0] = samedi14h;
		this.dispos[1] = samedi16h;
		this.dispos[2] = samedi18h;
		this.dispos[3] = samedi20h;
		this.dispos[4] = dimanche10h;
		this.dispos[5] = dimanche13h;
		this.dispos[6] = dimanche15h;
	}

	public ArbitreDisponibilite() {
		this.dispos = new boolean[7];
		for (int i = 0; i < this.dispos.length; i++) {
			dispos[i] = true;
		}
	}

	public boolean disponible(int jour) {
		return dispos[jour];
	}

	public void setDispo(boolean dispo, int jour) {
		this.dispos[jour] = dispo;
	}

}