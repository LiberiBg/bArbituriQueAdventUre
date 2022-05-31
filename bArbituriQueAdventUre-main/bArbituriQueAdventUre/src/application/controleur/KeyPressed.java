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
		//VIRER LES DIRECTIONS ET AUGMENTER LA VITESSE JUSQU'AU MAX QUAND ON APPUIE SUR LES TOUCHES
		switch(event.getCode()) {
		case Q:
			System.out.println("Gauche");
			this.hero.augmenterVitesseGauche();
//			this.hero.setDirection(2);
			break ;
		case D :
			System.out.println("Driute");
			this.hero.augmenterVitesseDroite();
//			this.hero.setDirection(1);
			break ;
		case SPACE:
			System.out.println("sauter");
			this.hero.augmenterVitesseHaut();
//			this.hero.setDirection(3);
			break;
		default:
			break;
			
		}
	}
}
