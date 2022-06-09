package application.controleur;


import application.modele.Objet;
import application.vue.HerosVue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControleurChangementSprite implements EventHandler<MouseEvent> {

	private HerosVue hero ;
	
	
	public ControleurChangementSprite(HerosVue hero) {
		super();
		this.hero = hero;
	}
	@Override
	public void handle(MouseEvent event) {
		this.hero.ChangerSprite();
		
	}

}
