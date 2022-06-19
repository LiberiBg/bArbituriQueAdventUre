package application.modele.personnages;

import application.modele.Terrain;

public class Batman extends Personnage {
	
	boolean b ;
	
	public Batman (int x, int y, Terrain terrain) {
		super(x, y, terrain, 200);
	}
	
	public void batMouvement () {
		double n= Math.random();
		if (!getColision().blockDroitVide(this.getX(), this.getY()))
			b =true;
		if (!getColision().blockGaucheVide(this.getX(), this.getY()))
			b = false;
		
		if (b)
			this.augmenterVitesseGauche(1);
		else
			this.augmenterVitesseDroite(1);
		
		if (n <0.01)
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
