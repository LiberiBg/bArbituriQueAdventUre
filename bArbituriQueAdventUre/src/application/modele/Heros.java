package application.modele;

import javafx.beans.property.IntegerProperty;

public class Heros extends Personnage{

	private IntegerProperty x, y ;
	
	public Heros(int x, int y) {
		super(x, y);
	}
}

