package application.modele;

public class Heros extends Personnage{

	private Objet objetPorté;

	private Inventaire inventaire;
	
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, terrain);
		this.inventaire = new Inventaire();
		
	}	
	
	public void ekipHero(Objet itemEquipe) {
		this.objetPorté = itemEquipe;
	}
	
	
}