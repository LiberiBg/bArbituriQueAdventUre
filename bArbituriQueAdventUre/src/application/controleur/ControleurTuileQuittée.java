package application.controleur;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileQuittée implements EventHandler<MouseEvent> {

	public ControleurTuileQuittée() {
		
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		//applique une opacité totale lorsque la souris n'est plus sur la tuile
				ImageView img = (ImageView) event.getSource();
				img.setOpacity(1);
	}

}
