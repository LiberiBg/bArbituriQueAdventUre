package application.modele.personnages;

import application.modele.Terrain;

public abstract class Pnj extends Personnage {

	public Pnj(int x, int y, Terrain terrain) {
		super(x, y, terrain, 1000);
	}

	
}