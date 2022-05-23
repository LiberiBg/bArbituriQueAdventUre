package application.modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import application.modele.Parametres;

public class Environnement {

	private ArrayList<Personnage> listePersonnage;
	private ArrayList<Integer> tabTerrain;
	private int X;
	private int Y;

	public Environnement() {
		this.listePersonnage = new ArrayList<Personnage>();
		//CREER ET CHARGER MAP();
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


}