package application.modele;

import java.io.IOException;
import java.util.ArrayList;
import application.modele.Batman;

public class Environnement {

	private ArrayList<Personnage> listePersonnage;
	private Terrain terrain;
	private Inventaire inventaire ;
	private Heros hero;
	private Batman batman;

	public Environnement() {
		this.listePersonnage = new ArrayList<Personnage>();
		try {
			terrain = new Terrain();
			inventaire = new Inventaire();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hero = new Heros(60, 40, terrain);
		batman = new Batman(150, 5, terrain);
	}


	//Récupère le Hero dans la liste de tous les personnages
	public Heros getHeros() {
		for (Personnage p: listePersonnage) {
			if (p instanceof Heros) {
				return (Heros) p;
			}
		}
		return null;
	}

	public void addPersonnage(Personnage p) {
		this.listePersonnage.add(p);
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
	

}