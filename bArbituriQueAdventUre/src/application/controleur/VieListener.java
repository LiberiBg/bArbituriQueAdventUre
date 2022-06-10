package application.controleur;

import application.modele.Heros;
import application.vue.VieVue;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class VieListener implements ChangeListener{

	private VieVue vieVue;
	private Heros hero;
	
	
	public VieListener(VieVue vieVue, Heros hero) {
		this.vieVue = vieVue;
		this.hero = hero;
	}

	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		vieVue.reafficherVie(hero.getVie());
		System.out.println("changed vie");
	}
	
	
}
