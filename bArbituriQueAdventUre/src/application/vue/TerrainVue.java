package application.vue;

import application.modele.Terrain;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TerrainVue {

	public void initCarte() {
		ImageView img = null;
		Terrain ter = new Terrain();
		int[] terrain = ter.getTerrain();
		for (int i=0; i < terrain.length; i++) {
			switch (terrain[i]) {
			case -1:
				img = new ImageView(new Image("application/ressource/tile-1.png"));
				break;
			case 20:
				img = new ImageView(new Image("application/ressource/tile20.png"));
				break;
			case 21:
				img = new ImageView(new Image("application/ressource/tile21.png"));
				break;
			}
		//	terrainMap.getChildren().add(img);
		}
		
	}
}
