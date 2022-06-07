package application.controleur;

import application.modele.Terrain;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileCliquée implements EventHandler<MouseEvent> {

	private int indiceTuile;
	private Terrain terrain;
	
	public ControleurTuileCliquée(int indice, Terrain terrain) {
		this.indiceTuile = indice;
		this.terrain = terrain;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img = (ImageView) event.getSource();
		System.out.println(terrain.trouverTuileSelonLIndice(this.indiceTuile));
		terrain.détuireBlocsSelonLIndice(indiceTuile);
		img.setImage(new Image("application/ressource/tile-1.png"));
	}
	

}
