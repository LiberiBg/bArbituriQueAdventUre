package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Terrain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Controleur implements Initializable{
	
	@FXML
	private TilePane terrainMap;
	
	@FXML
	private ImageView perso;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		terrainMap.setMaxSize(20*16, 10*16);
		this.initCarte();
		
	}
	
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
			terrainMap.getChildren().add(img);
		}
		
	}

}