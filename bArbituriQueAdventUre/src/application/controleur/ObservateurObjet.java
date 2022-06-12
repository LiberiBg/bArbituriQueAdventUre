package application.controleur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import application.modele.Heros;
import application.vue.HerosVue;


public class ObservateurObjet implements ChangeListener<Number>{
	private Heros hero ;
	
	public ObservateurObjet(Heros hero) {
	this.hero = hero;
}
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		// TODO Auto-generated method stub
		
		System.out.println("changement");
		//this.heroVue.ChangerSprite();
	}
	
}
