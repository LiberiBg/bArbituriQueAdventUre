package application.controleur;

import application.modele.personnages.Heros;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyReleased implements EventHandler<KeyEvent>{
	
	private Heros hero ;
	
	public KeyReleased(Heros hero) {
		this.hero = hero;
	}

	@Override
	public void handle(KeyEvent event) {
		
		switch(event.getCode()) {
		case Q:
			this.hero.ralentir();
			break ;
		case D :
			this.hero.ralentir();
			break;
		default:
			break;
			
		}
	}
}
