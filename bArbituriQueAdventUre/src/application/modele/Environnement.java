package application.modele;

import java.io.IOException;
import java.util.ArrayList;

public class Environnement {

	private ArrayList<Personnage> listePersonnage;
	private Terrain terrain;
	private Heros hero;

	public Environnement() {
		this.listePersonnage = new ArrayList<Personnage>();
		hero = new Heros(160, 200);
		try {
			terrain = new Terrain();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public Heros getHeros() {
//		for (Personnage p: listePersonnage) {
//			if (p instanceof Heros) {
//				return (Heros) p;
//			}
//		}
//		return null;
//	}

	public void addPersonnage(Personnage p) {
		this.listePersonnage.add(p);
	}


	public Terrain getTerrain() {
		return terrain;
	}


	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	
	public Heros getHero() {
		return this.hero;
	}
	

}