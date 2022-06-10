package application.modele;

public class Parametres {

	private final static String cheminTerrain = "src/application/ressource/SecondeMap.csv";
	private final static int nbrColonnes = 60;
	private final static int nbrLignes = 34;
	public static String getCheminTerrain() {
		return cheminTerrain;
	}
	public static int getNbrcolonnes() {
		return nbrColonnes;
	}
	public static int getNbrlignes() {
		return nbrLignes;
	}
}
