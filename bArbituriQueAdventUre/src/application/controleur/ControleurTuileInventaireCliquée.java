package application.controleur;

import application.modele.personnages.Heros;
import application.vue.InventaireVue;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileInventaireCliquée implements EventHandler<MouseEvent> {

	private Heros hero;
	private ImageView imageCliquée;
	private InventaireVue inventaireVue;
	
	public ControleurTuileInventaireCliquée(Heros hero, ImageView imageCliquée, InventaireVue inventaireVue) {
		this.hero = hero;
		this.imageCliquée = imageCliquée;
		this.inventaireVue = inventaireVue;
		
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.hero.ekipHero(this.inventaireVue.getMapImageToObjet().get(this.imageCliquée));
		System.out.println(this.hero.getObjetPorté());
	}

}
