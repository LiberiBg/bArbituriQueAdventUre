package application.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
// + 8 dans les constantes + attribut vitesse 
public class Heros extends Personnage{

	private IntegerProperty x, y ;
	
	
	public Heros(IntegerProperty x, IntegerProperty y, int vie, int vitesse) {
		super(x, y, vie, vitesse);
		
	}

//	public Heros(int x, int y) {
//		super();
//		
//	}
	
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
}

