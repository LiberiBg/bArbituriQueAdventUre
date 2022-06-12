package application.modele;

import javafx.beans.property.IntegerProperty;

public class Heros extends Personnage{

	private Objet objetPorté;

	private Inventaire inventaire;
	
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, terrain, 100);
		this.inventaire = new Inventaire();
	}	
	
	public void ekipHero(Objet itemEquipe) {
		this.objetPorté = itemEquipe;
	}

	public Objet getObjetPorté() {
		return objetPorté;
	}
	
	
	
}