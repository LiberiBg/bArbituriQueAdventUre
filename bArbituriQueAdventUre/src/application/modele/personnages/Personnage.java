package application.modele.personnages;

import application.modele.Colision;
import application.modele.Parametres;
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
		
		public void augmenterVitesseDroite(double v) {
			if (!getColision().blockDroitVide(this.x.getValue(), this.y.getValue()) || !getColision().blockDroitVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() > Parametres.getNbrcolonnes()*16)
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale < VITESSEMAX)
				this.vitesseHotizontale =(int) +v;
		}
		
		public void augmenterVitesseGauche(double v) {
			if (!getColision().blockGaucheVide(this.x.getValue(), this.y.getValue()) || !getColision().blockGaucheVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() < 0)
				this.vitesseHotizontale = 0;
			else if (vitesseHotizontale > -VITESSEMAX)
				this.vitesseHotizontale =(int) -v ;
		}
		
		
		public void augmenterVitesseHaut() {
			if (!getColision().blockDessousVide(this.x.getValue() + 8, this.y.getValue()) && getColision().blockDessusVide(this.x.getValue() + 8, this.y.getValue()))
				this.vitesseVerticale =- 48;
		}
		
		public void ralentir() {
			if (vitesseHotizontale != 0)
				vitesseHotizontale = (int) (vitesseHotizontale * 0.2);
		}
		
		public void gravite() {
			if (getColision().blockDessousVide(this.x.getValue() + 2, this.y.getValue()) && getColision().blockDessousVide(this.x.getValue() + 14, this.y.getValue()))
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
			if (!getColision().blockGaucheVide(this.x.getValue(), this.y.getValue()) || !getColision().blockGaucheVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() < 0)
				this.vitesseHotizontale = 0;
			if (!getColision().blockDroitVide(this.x.getValue(), this.y.getValue()) || !getColision().blockDroitVide(this.x.getValue(), this.y.getValue() + 16) || this.x.getValue() > Parametres.getNbrcolonnes()*16)
				this.vitesseHotizontale = 0;
			gravite();
		}
		
		public int getVie() {
			return this.vie.getValue();
		}
		
		public IntegerProperty vieProperty() {
			return this.vie;
		}
		
		public void setVie(int vie) {
			if (vie >= 0 )
				this.vie.setValue(vie);
		
		}

		public Colision getColision() {
			return colision;
		}
		

}