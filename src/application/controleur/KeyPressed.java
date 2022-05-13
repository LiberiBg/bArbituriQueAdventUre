package application.controleur;

import application.modele.Heros;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements EventHandler<KeyEvent>{
	private Heros hero ;
	

	public KeyPressed(Heros hero) {
		super();
		this.hero = hero;
	}

	public void handle(KeyEvent event) {
		switch(event.getCode()) {
		case Q:
			System.out.println("Gauche");
			hero.reculer();
			break ;
		case D :
			System.out.println("Driute");
			hero.avancer();
			break ;
		case SPACE:
			System.out.println("sauter");
			hero.sauter();
			break;
		default:
			break;
			
		}
	}
}
