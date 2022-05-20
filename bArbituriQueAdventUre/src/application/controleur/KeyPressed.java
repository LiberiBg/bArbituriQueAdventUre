package application.controleur;

import application.modele.Heros;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements EventHandler<KeyEvent>{
	private Heros hero ;
	

	public KeyPressed(Heros hero) {
		this.hero = hero;
	}

	@Override
	public void handle(KeyEvent event) {
		switch(event.getCode()) {
		case Q:
			System.out.println("Gauche");
			this.hero.setDirection(2);
			break ;
		case D :
			System.out.println("Driute");
			this.hero.setDirection(1);
			break ;
		case SPACE:
			System.out.println("sauter");
			this.hero.setDirection(3);
			break;
		default:
			break;
			
		}
	}
}
