package application.modele;

public class Parametres {
	
	private final static String cheminTerrain = "src/application/ressource/SecondeMap.csv";
	private final static String cheminSpriteHero = "application/ressource/Sprite.png";
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

	public static String getCheminspritehero() {
		return cheminSpriteHero;
	}
}
