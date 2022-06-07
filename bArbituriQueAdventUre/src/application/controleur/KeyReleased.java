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
		
		// VIRER LA DIRECTION ET QUAND ON LACHE LA TOUCHE LA VITESSE ASSOCIEE BAISSE JUSQUA L'ARRET
		switch(event.getCode()) {
		case Q:
			System.out.println("Gauche STOP");
			this.hero.ralentir();
//			this.hero.setDirection(0);
			break ;
		case D :
			System.out.println("Droite STOP");
			this.hero.ralentir();
//			this.hero.setDirection(0);
			break;
		default:
			break;
			
		}
	}
}
