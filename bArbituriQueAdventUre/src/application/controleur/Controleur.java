package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import application.modele.Heros;
import application.modele.Terrain;
import application.vue.HerosVue;
import application.vue.TerrainVue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class Controleur implements Initializable{
	
	@FXML
	private BorderPane root;
	
    @FXML
    private Pane environnementPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Terrain terrain = new Terrain();
		TerrainVue terrainMap = new TerrainVue(terrain);
		environnementPane.getChildren().add(terrainMap);
		
		Heros hero = new Heros(160, 200) ;
		HerosVue heroVue = new HerosVue("application/ressource/sprite.png", hero);
		heroVue.initJoueur();
		environnementPane.getChildren().add(heroVue);
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(hero));
	}

}