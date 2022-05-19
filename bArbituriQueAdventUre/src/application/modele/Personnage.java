package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

		private IntegerProperty x, y;
		private int vie;
		private int vitesse;
		
		public Personnage(int x, int y) {
			this.x= new SimpleIntegerProperty(x);
			this.y = new SimpleIntegerProperty(y);
		}
		public IntegerProperty getX() {
			return x;
		}
		
		public IntegerProperty getY() {
			return y ;
		}	

		public void setX(int n){
			x.setValue(n);
		}
		
		public void setY(int n){
			y.setValue(n);
		}
		
		public void avancer () {
			this.x.setValue(this.x.getValue() + 8);
		}
		
		public void reculer() {
			this.x.setValue(this.x.getValue() - 8);
		}
		
		public void sauter() {
			this.y.setValue(this.y.getValue() - 10);
		}
		
		public void fall() {
			
		}
}