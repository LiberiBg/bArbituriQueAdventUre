package application.controleur;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileSurvolée  implements EventHandler<MouseEvent>{

	public ControleurTuileSurvolée() {
		
	}
	@Override
	public void handle(MouseEvent event) {

		//Réduit l'opacité de la tuile lorsqu'elle est survolée par la souris
		ImageView img = (ImageView) event.getSource();
		img.setOpacity(0.8);
	}

}
