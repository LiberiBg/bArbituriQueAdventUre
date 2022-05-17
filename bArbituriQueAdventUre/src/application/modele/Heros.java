package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Heros extends Personnage{

	private IntegerProperty x, y ;
	
	public Heros(int x, int y) {
		super(x, y);
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
}

