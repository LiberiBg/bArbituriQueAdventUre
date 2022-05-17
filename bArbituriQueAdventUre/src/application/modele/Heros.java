package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Heros extends Personnage{
	
	public Heros(int x, int y) {
		super();
	}
	
	public void avancer () {
		setX(this.x.getValue() + 8);
	}
	
	public void reculer() {
		setX(XProperty() - 8);
	}
	
	public void sauter() {
		this.y.setValue(this.y.getValue() - 10);
	}
}

