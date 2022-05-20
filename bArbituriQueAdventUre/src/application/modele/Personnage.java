package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Personnage {

		private IntegerProperty x, y;
		private int vie;
		private int direction;
		
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
		
		public void setDirection(int d){
			this.direction = d;
		}
		
		public void move () {
			switch(direction) {
			case 1:
				this.x.setValue(this.x.getValue() + 3);
				break;
			case 2:
				this.x.setValue(this.x.getValue() - 3);
				break;
			case 3:
				this.y.setValue(this.y.getValue() - 4);
				break;
			}

		}
		
		public void fall() {
			
		}
}