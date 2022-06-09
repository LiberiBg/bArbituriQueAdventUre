package application.modele;

public class Batman extends Personnage {
	
	public Batman (int x, int y, Terrain terrain) {
		super(x, y, terrain);
	}
	
	public void seDeplace () {
		double n= Math.random();
		if (n <0.5)
			this.augmenterVitesseGauche();
		else
			this.augmenterVitesseDroite();
	}
	
	
	public void attaqueHero (int Xhero, int Yhero) {
		if (Math.abs(this.getX() - Xhero) < 10) {
			System.out.println(this.getX() - Xhero);
			System.out.println("ATAK");
		}
	}
	
	

}
