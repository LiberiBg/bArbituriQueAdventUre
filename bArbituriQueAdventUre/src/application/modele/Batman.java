package application.modele;

public class Batman extends Personnage {
	
	public Batman (int x, int y, Terrain terrain) {
		super(x, y, terrain);
	}
	
	public void seDeplace () {
		double x= Math.random();
		if (x <0.5)
			this.augmenterVitesseGauche();
		else
			this.augmenterVitesseDroite();
	}
	
	
	public void attaqueHero () {
		
	}
	
	

}
