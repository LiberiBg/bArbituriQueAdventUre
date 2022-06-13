package application.modele.personnages;

import application.modele.Colision;
import application.modele.Terrain;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	
		private final static int VITESSEMAX = 3;

		private IntegerProperty x, y;
		private IntegerProperty vie;
		private int vitesseHotizontale, vitesseVerticale;
		private Colision colision;
		
		public Personnage(int x, int y, Terrain terrain, int vie) {
			this.x= new SimpleIntegerProperty(x);
			this.y = new SimpleIntegerProperty(y);
			this.colision = new Colision(terrain);
			this.vitesseHotizontale = 0;
			this.vitesseVerticale = 0;
			this.vie = new SimpleIntegerProperty(vie);
		}
		
		public IntegerProperty XProperty() {
			return x;
		}
		
		public IntegerProperty YProperty() {
			return y ;
		}	

		public void setX(int n){
			x.setValue(n);
		}
		
		public void setY(int n){
			y.setValue(n);
		}
		
		public int getX() {
			return x.getValue();
		}
		
		public int getY() {
			return y.getValue();
		}
		
		public void augmenterVitesseDroite() {
			if (!colision.blockDroitVide(this.x.getValue(), this.y.getValue()) || !colision.blockDroitVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() > 30*16)
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale < VITESSEMAX)
				this.vitesseHotizontale ++;
		}
		
		public void augmenterVitesseGauche() {
			if (!colision.blockGaucheVide(this.x.getValue(), this.y.getValue()) || !colision.blockGaucheVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() < 0)
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale > -VITESSEMAX)
				this.vitesseHotizontale -- ;
		}
		
		
		public void augmenterVitesseHaut() {
			if (!colision.blockDessousVide(this.x.getValue() + 8, this.y.getValue()) && colision.blockDessusVide(this.x.getValue() + 8, this.y.getValue()))
				this.vitesseVerticale =- 48;
		}
		
		public void ralentir() {
			if (vitesseHotizontale != 0)
				vitesseHotizontale = (int) (vitesseHotizontale * 0.2);
		}
		
		public void gravite() {
			if (colision.blockDessousVide(this.x.getValue() + 2, this.y.getValue()) && colision.blockDessousVide(this.x.getValue() + 14, this.y.getValue()))
				this.vitesseVerticale =+ 2;
			else
				this.vitesseVerticale = 0;
		}
		
		public void limiteTerrain() {
			//programmer les limites du terrain
		}
		
		public void seDeplacer() {
			this.x.setValue(this.x.getValue() + vitesseHotizontale);
			this.y.setValue(this.y.getValue() + vitesseVerticale);
			if (!colision.blockGaucheVide(this.x.getValue(), this.y.getValue()) || !colision.blockGaucheVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() < 0)
				this.vitesseHotizontale = 0;
			if (!colision.blockDroitVide(this.x.getValue(), this.y.getValue()) || !colision.blockDroitVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() > 30*16)
				this.vitesseHotizontale = 0;
		}
		
		public int getVie() {
			return this.vie.getValue();
		}
		
		public IntegerProperty vieProperty() {
			return this.vie;
		}
		
		public void setVie(int vie) {
			this.vie.setValue(vie);
		}

}