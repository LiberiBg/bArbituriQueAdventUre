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
	private Timeline GameLoop;
	private int temps;
	private int vitesseY = 0 ;
	private double gravite = 0.2;
	
	@FXML
	private TilePane terrainMap;
	
	@FXML
	private BorderPane root;

	 @FXML
	 private Pane plateau;
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Heros hero = new Heros(100, 100, 100, 100) ;
		HerosVue heroVue = new HerosVue(hero);
		
		//terrainMap.setMaxSize(20*16, 10*16);
		InitAnimation();
		//GameLoop.play();

		this.initTerrain(); 
		heroVue.initJoueur();
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(hero));
		plateau.getChildren().add(heroVue);
	}
	
	public void initTerrain() {
		ImageView img = null;
		Terrain ter = new Terrain();
		String[] terrain = Terrain.getTerrain();
		for (int i=0; i < terrain.length; i++) {
			switch (terrain[i]) {
			case  "-1":
				img = new ImageView(new Image("application/ressource/tile-1.png"));
				break;
			case "20":
				img = new ImageView(new Image("application/ressource/tile20.png"));
				break;
			case "21":
				img = new ImageView(new Image("application/ressource/tile21.png"));
				break;
			}
			terrainMap.getChildren().add(img);
		
		}
	}
	
	public void InitAnimation() {
		GameLoop = new Timeline();
		temps = 0;
		KeyFrame kf = new KeyFrame(Duration.millis(0.017),
				(ev ->{ 
					
						plateau.setLayoutY(plateau.getLayoutY()+vitesseY);
						vitesseY += gravite ;
						System.out.println(plateau.getLayoutY() + plateau.getHeight() +terrainMap.getHeight());
						System.out.println(vitesseY);
				
					temps ++ ;
					
				}));
		GameLoop.getKeyFrames().add(kf);
				
	}

	

}