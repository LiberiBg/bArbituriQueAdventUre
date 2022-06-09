package application.modele;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Environnement {

	private ArrayList<Personnage> listePersonnage;
	private Terrain terrain;
	private Inventaire inventaire ;
	
	private Heros hero;

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



	
	public Heros getHero() {
		return this.hero;
	}
	

}