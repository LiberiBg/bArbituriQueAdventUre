package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {
	
		private final static int VITESSEMAX = 4;
		private final static int SAUTMAX = 10;

		private IntegerProperty x, y;
		private int vie;
		private int vitesseHotizontale, vitesseVerticale;
		private Terrain terrain;
		private Colision colision;
		
		public Personnage(int x, int y, Terrain terrain) {
			this.x= new SimpleIntegerProperty(x);
			this.y = new SimpleIntegerProperty(y);
			this.terrain = terrain;
			this.colision = new Colision(terrain);
			this.vitesseHotizontale = 0;
			this.vitesseVerticale = 0;
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
		
		public void augmenterVitesseDroite() {
			if (!colision.blockDroitVide(this.x.getValue(), this.y.getValue()))
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale < VITESSEMAX)
				this.vitesseHotizontale ++;
		}
		
		public void augmenterVitesseGauche() {
			if (!colision.blockGaucheVide(this.x.getValue(), this.y.getValue()))
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale > -VITESSEMAX)
				this.vitesseHotizontale --;
		}
		
		public void augmenterVitesseHaut() {
			if (!colision.blockDessusVide(this.x.getValue(), this.y.getValue()))
				this.vitesseVerticale = 0;
			else if (vitesseVerticale < SAUTMAX)
				this.vitesseVerticale =- 50;
		}
		
		public void ralentir() {
			if (vitesseHotizontale != 0)
				vitesseHotizontale = (int) (vitesseHotizontale * 0.2);
		}
		
		public void gravite() {
			if (colision.blockDessousVide(this.x.getValue(), this.y.getValue()))
				this.vitesseVerticale =+ 2;
			else
				this.vitesseVerticale = 0;
		}
		

		
		public void seDeplacer() {
			this.x.setValue(this.x.getValue() + vitesseHotizontale);
			this.y.setValue(this.y.getValue() + vitesseVerticale);
		}
		
}