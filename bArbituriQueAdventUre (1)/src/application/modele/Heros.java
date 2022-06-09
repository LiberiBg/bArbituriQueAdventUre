package application.modele;

import javafx.beans.property.IntegerProperty;

public class Heros extends Personnage{

	//mettre un listener sur l'objet qui devient maintenant un Integerproperty pour quand le model change, la vue change
	private IntegerProperty objetPorté;

	private Inventaire inventaire;
	
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, terrain);
		this.inventaire = new Inventaire();
		
	}	
	
//	public void ekipHero(Objet itemEquipe) {
//		this.objetPorté = itemEquipe;
//	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}
	
//	public Objet objetEnMain() {
//		return this.objetPorté;
//	}
//	public Objet getObjetporté() {
//		return this.objetPorté;
//	}
}