package application.modele;

import java.io.IOException;
import application.modele.personnages.Batman;
import application.modele.personnages.Heros;
import application.modele.personnages.Hmpz;
import application.modele.personnages.Personnage;

public class Environnement {
	
	private Terrain terrain;
	private Inventaire inventaire ;
	private Heros hero;
	private Batman batman;
	private Hmpz hmpz;

	public Environnement() {
		try {
			terrain = new Terrain();
			inventaire = new Inventaire();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hero = new Heros(60, 40, terrain);
		batman = new Batman(150, 150, terrain);
		hmpz = new Hmpz(500, 50, terrain);
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public Heros getHero() {
		return this.hero;
	}

	public Batman getBatman() {
		return this.batman;
	}

	public void mort(Personnage p) {
		p = null;
	}

	public Hmpz getHmpz() {
		return this.hmpz;
	}

}