package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Heros extends Personnage{

	private IntegerProperty x, y ;
	
	public Heros(int x, int y) {
		super(x, y);
	}
}

