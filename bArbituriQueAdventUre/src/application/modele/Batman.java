package application.modele;

public class Batman extends Personnage {
	
	public Batman (int x, int y, Terrain terrain) {
		super(x, y, terrain, 200);
	}
	
	public void seDeplace () {
		double n= Math.random();
		if (n <0.5)
			this.augmenterVitesseGauche();
		else
			this.augmenterVitesseDroite();
		double m= Math.random();
		if (m <0.05)
			this.augmenterVitesseHaut();
		
	}
	
	
	public void attaqueHero (Heros hero) {
		if (Math.abs(this.getX() - hero.getX()) < 16) {
			System.out.println("ATAK");
			hero.setVie(hero.getVie() - 1);
			System.out.println(hero.getVie());
		}
	}
	
	

}
