package Test;

import Representation.Arbitre;
import Representation.Equipe;
import Representation.ListeCategorieArbitre;
import Representation.ListeCategorieMatch;
import Representation.Match;
import Representation.Ville;

public class Test {

	public static void main(String[] args) {
		Arbitre[] arbitres = new Arbitre[3];
		arbitres[0] = new Arbitre(ListeCategorieArbitre.D1, 1, "Nantes", "John",
				"Smith", "adresse", new Ville("Nantes"));
		arbitres[1] = new Arbitre(ListeCategorieArbitre.D2, 2, "Carquefou", "Will",
				"Smith", "adresse", new Ville("Carquefou"));
		arbitres[3] = new Arbitre(ListeCategorieArbitre.D3, 3, "Orvault", "Bill",
				"Smith", "adresse", new Ville("Orvault"));

		Equipe[] equipes = new Equipe[4];
		equipes[0] = new Equipe("Equipe0",ListeCategorieMatch.DSD);
		equipes[1] = new Equipe("Equipe1",ListeCategorieMatch.D1);
		equipes[2] = new Equipe("Equipe2",ListeCategorieMatch.D1);
		equipes[3] = new Equipe("Equipe3",ListeCategorieMatch.D1);
		
		Match[] matchs = new Match[5];
		matchs[0] = new Match(0, equipes[0], equipes[1], ListeCategorieMatch.D1);
		matchs[1] = new Match(1, equipes[0], equipes[2], ListeCategorieMatch.DSD);
		matchs[2] = new Match(2, equipes[1], equipes[2], ListeCategorieMatch.D1);
		matchs[3] = new Match(3, equipes[1], equipes[3], ListeCategorieMatch.D1);
		matchs[4] = new Match(4, equipes[2], equipes[3], ListeCategorieMatch.D1);
	}

}
