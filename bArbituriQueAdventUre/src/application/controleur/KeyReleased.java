package application.controleur;

import application.modele.Heros;
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
			System.out.println("Gauche STOP");
			this.hero.setDirection(0);
			break ;
		case D :
			System.out.println("Droite STOP");
			this.hero.setDirection(0);
			break;
		default:
			break;
			
		}
		
		//changer les switch en if pour pouvoir avancer et sauter simultanément ???
	}
}
