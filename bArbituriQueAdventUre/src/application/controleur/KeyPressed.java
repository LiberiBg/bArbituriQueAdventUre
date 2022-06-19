package application.controleur;

import application.modele.personnages.Heros;
import application.vue.InventaireVue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressed implements EventHandler<KeyEvent>{
	private Heros hero ;
	private InventaireVue inventaire ; 
	
	


	public KeyPressed(Heros hero, InventaireVue inventaire ) {
		this.hero = hero;
		this.inventaire = inventaire ;
	}

	@Override
	public void handle(KeyEvent event) {
		switch(event.getCode()) {
		case Q:
			System.out.println("Gauche");
			this.hero.augmenterVitesseGauche(2);
			break ;
		case D :
			System.out.println("Driute");
			this.hero.augmenterVitesseDroite(2);
			break ;
		case Z:
			System.out.println("sauter");
			this.hero.augmenterVitesseHaut();
			break;
		case I:
			this.inventaire.switchAffichageInventaire();
			break ;
		default:
			break;
			
		}
	}
}
