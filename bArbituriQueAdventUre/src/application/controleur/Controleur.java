package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Environnement;
import application.modele.Heros;
import application.modele.Inventaire;
import application.modele.Objet;
import application.modele.outils.Hache;
import application.vue.HerosVue;
import application.vue.InventaireVue;
import application.vue.TerrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Controleur implements Initializable{

	@FXML
	private BorderPane root;

	@FXML
	private Pane environnementPane;

	private Timeline gameLoop;
	
	private Heros hero;
	
	private Environnement environnement;
	
	//private Pane InventairePane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		environnement = new Environnement();
		TerrainVue terrainVue = new TerrainVue(environnement.getTerrain());
		environnementPane.getChildren().add(terrainVue);

		this.hero = new Heros(160, 200) ;
		HerosVue heroVue = new HerosVue("application/ressource/sprite.png", hero);
		environnementPane.getChildren().add(heroVue);

		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(hero));
		root.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(hero));
		
		initAnimation();
		//demarre l'animation
		gameLoop.play();
		
		InventaireVue InventaireVue = new InventaireVue(environnement.getInventaire());
		environnementPane.getChildren().add(InventaireVue);
		//Hache hache = new Hache(1,1,1);
		//environnement.getInventaire().ajouterObjet(hache);
		System.out.println("oui");
		System.out.println(environnement.getInventaire().getListeObjet());
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),
				(ev -> {
					this.hero.move();
					
					//FAIRE LA GRAVITE
				}));
		this.gameLoop.getKeyFrames().add(kf);
		this.gameLoop.play();
		
	}
	
}