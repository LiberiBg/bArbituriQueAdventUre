package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;
import application.modele.Heros;
import application.modele.Terrain;
import application.vue.HerosVue;
import application.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;


public class Controleur implements Initializable{

	@FXML
	private BorderPane root;

	@FXML
	private Pane environnementPane;

	private Timeline gameLoop;

	private int temps;
	
	private Heros hero;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Terrain terrain = new Terrain();
		TerrainVue terrainMap = new TerrainVue(terrain);
		environnementPane.getChildren().add(terrainMap);

		this.hero = new Heros(160, 200) ;
		HerosVue heroVue = new HerosVue("application/ressource/sprite.png", hero);
		environnementPane.getChildren().add(heroVue);

		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(hero));
		root.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(hero));
		
		initAnimation();
		//demarre l'animation
		gameLoop.play();
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),
				(ev -> {
					this.hero.move();
				}));
		this.gameLoop.getKeyFrames().add(kf);
		this.gameLoop.play();
		
	}

}