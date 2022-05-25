package application.modele;

import java.io.IOException;
import java.util.ArrayList;

public class Environnement {

	private ArrayList<Personnage> listePersonnage;
	private Terrain terrain;
	private Inventaire inventaire ;

	public Environnement() {
		this.listePersonnage = new ArrayList<Personnage>();
		try {
			terrain = new Terrain();
			inventaire = new Inventaire();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	

}