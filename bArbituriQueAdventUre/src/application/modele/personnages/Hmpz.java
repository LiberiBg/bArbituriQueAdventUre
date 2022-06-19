package application.modele.personnages;

import application.modele.Terrain;

public class Hmpz extends Personnage {

	boolean b;
	
	public Hmpz(int x, int y, Terrain terrain) {
		super(x, y, terrain, 500);
	}

	public void hmpzMouvements(Heros hero) {
		if (this.getX() - hero.getX() > 0)
			this.augmenterVitesseGauche(1);
		else
			this.augmenterVitesseDroite(1);
	}

	
	
}
