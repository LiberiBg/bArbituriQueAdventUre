package application.controleur;

import application.modele.personnages.Heros;
import application.vue.InventaireVue;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ControleurTuileInventaireCliquée implements EventHandler<MouseEvent> {

	private Heros hero;
	private ImageView imageCliquée;
	private InventaireVue inventaireVue;
	private BorderPane root;

	
	public ControleurTuileInventaireCliquée(Heros hero, ImageView imageCliquée, InventaireVue inventaireVue, BorderPane r) {
		this.hero = hero;
		this.imageCliquée = imageCliquée;
		this.inventaireVue = inventaireVue;
		this.root = r ; 
	}

	@Override
	public void handle(MouseEvent arg0) {
		this.hero.ekipHero(this.inventaireVue.getMapImageToObjet().get(this.imageCliquée));
		System.out.println(this.hero.getObjetPorté());
		String chemin = "application/ressource/" +this.hero.getObjetPorté().getId() + ".png";
		Image image = new Image(chemin);
		root.setCursor(new ImageCursor(image));
		System.out.println(this.inventaireVue.getMapImageToObjet().get(this.imageCliquée));
	}

}
