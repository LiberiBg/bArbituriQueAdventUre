package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

		private IntegerProperty x, y;
		private int vie;
		private int vitesse;
		
		public Personnage() {
			this.x= new SimpleIntegerProperty();
			this.y = new SimpleIntegerProperty();
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
		
//		public boolean checkCaseEnDessous() {
//			IntegerProperty yDuPersonnage = this.y;
//			
//		}
}