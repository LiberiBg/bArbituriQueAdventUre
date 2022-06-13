package application.controleur;

import application.modele.personnages.Heros;
import application.vue.VieVue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class VieListener implements ChangeListener<Number>{

	private VieVue vieVue;
	private Heros hero;
	
	
	public VieListener(VieVue vieVue, Heros hero) {
		this.vieVue = vieVue;
		this.hero = hero;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		vieVue.reafficherVie(hero.getVie());
		System.out.println("changed vie");
	}
	
	
}
