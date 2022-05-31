package application.vue;

import java.util.List;

import application.controleur.ControleurTuileCliquée;
import application.controleur.ControleurTuileQuittée;
import application.controleur.ControleurTuileSurvolée;
import application.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class TerrainVue extends TilePane{
	
	Terrain terrain;
	
	public TerrainVue(Terrain ter) {
		super();
		this.setPrefColumns(20);
		this.terrain = ter;
		initCarte();
	}

	public void initCarte() {
		ImageView img = null;
		List<String> terrain = this.terrain.getListeTerrain();
		for (int i=0; i < terrain.size(); i++) {
			switch (terrain.get(i)) {
			case "-1":
				img = new ImageView(new Image("application/ressource/tile-1.png"));
				break;
			case "20":
				img = new ImageView(new Image("application/ressource/tile20.png"));
				break;
			case "21":
				img = new ImageView(new Image("application/ressource/tile21.png"));
				break;
			}
			this.getChildren().add(img);
			img.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new ControleurTuileSurvolée());
			img.addEventHandler(MouseEvent.MOUSE_EXITED, new ControleurTuileQuittée());
			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurTuileCliquée(i, this.terrain));
		}
		
	}
	
	
}