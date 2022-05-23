package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

		private IntegerProperty x, y;
		private int vie;
		private int vitesse;
		
		public Personnage(int x, int y, int vie, int vitesse) {
			
			this.x= new SimpleIntegerProperty(x);
			this.y = new SimpleIntegerProperty(y);
			this.vie = vie;
			this.vitesse = vitesse;
		}
		
		public void setX(int n){
			x.setValue(n);
		}
		
		public void setY(int n){
			y.setValue(n);
		}
		
		public abstract void avancer () ;
			
		public abstract void reculer() ;
		
		public abstract void sauter() ;
		
		
}