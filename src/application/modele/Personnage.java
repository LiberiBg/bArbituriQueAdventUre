package application.modele;

import javafx.beans.property.IntegerProperty;

public abstract class Personnage {

		private IntegerProperty x, y;
		private int vie;
		private int vitesse;
		
		public Personnage(IntegerProperty x, IntegerProperty y, int vie, int vitesse) {
			
			this.x = x;
			this.y = y;
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