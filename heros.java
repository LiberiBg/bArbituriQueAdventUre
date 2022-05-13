package bArbituriQueAdvEntuRe;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class heros {

	private IntegerProperty x, y ;
	
	public heros(int x, int y) {
		super();
		this.x=new SimpleIntegerProperty(x);
		this.y = new SimpleIntegerProperty(y);
	}
	
	public IntegerProperty getX2() {
		return x;
	}
	
	public IntegerProperty getY2() {
		return y ;
	}	

	public  void setX(int n){
		x.setValue(n);
	}
	
	public  void setY(int n){
		y.setValue(n);
	}
	
	public static void avancer () {
		
	}
	
	public static void reculer() {
		
	}
	
	public static void sauter() {
		
	}
}
