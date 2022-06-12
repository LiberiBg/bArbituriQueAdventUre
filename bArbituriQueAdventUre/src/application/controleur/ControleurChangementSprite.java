package application.controleur;


import application.modele.Heros;
import application.modele.Objet;
import application.modele.outils.Epee;
import application.vue.HerosVue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControleurChangementSprite implements EventHandler<MouseEvent> {

	private HerosVue herov ;

	
	public ControleurChangementSprite(HerosVue hero) {
		super();
		this.herov = hero;
	}
	@Override
	public void handle(MouseEvent event) {
		
	
		this.herov.mettreAJourSpriteDuHero();
		
	}

}
