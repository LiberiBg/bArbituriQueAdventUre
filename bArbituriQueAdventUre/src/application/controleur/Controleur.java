package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Environnement;
import application.modele.Heros;
import application.vue.BatmanVue;
import application.vue.HerosVue;
import application.vue.InventaireVue;
import application.vue.TerrainVue;
import application.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class Controleur implements Initializable{

	@FXML
	private BorderPane root;

	@FXML
	private Pane environnementPane;

	private Timeline gameLoop;
		
	private Environnement environnement;
	
	@FXML
	private VieVue vieVue;
	
	//private Pane InventairePane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Image img = new Image("application/ressource/bg.png");
		BackgroundImage bgimg = new BackgroundImage(
				img,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT
				);
		Background bg = new Background(bgimg);
		root.setBackground(bg);
		environnement = new Environnement();
		TerrainVue terrainVue = new TerrainVue(environnement.getTerrain(), environnement.getHero());
		environnementPane.getChildren().add(terrainVue);

		HerosVue heroVue = new HerosVue("application/ressource/sprite.png", environnement.getHero());
		environnementPane.getChildren().add(heroVue);
		
		BatmanVue batmanVue = new BatmanVue("application/ressource/litlebatman.png", environnement.getBatman());
		environnementPane.getChildren().add(batmanVue);
		
		InventaireVue InventaireVue = new InventaireVue(environnement.getInventaire());
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getHero(), InventaireVue));
		root.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getHero()));
		
		initAnimation();
		//demarre l'animation
		gameLoop.play();
		
		environnementPane.getChildren().add(InventaireVue);
		
		this.vieVue = new VieVue(root, environnement.getHero().vieProperty());
		environnementPane.getChildren().add(vieVue);
		
		//listener vie
		environnement.getHero().vieProperty().addListener(new VieListener(this.vieVue, environnement.getHero()));
		
		
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),
				(ev -> {
					this.environnement.getHero().seDeplacer();
					this.environnement.getHero().gravite();

					this.environnement.getBatman().seDeplacer();
					this.environnement.getBatman().gravite();
					this.environnement.getBatman().seDeplace();
					
					this.environnement.getBatman().attaqueHero(this.environnement.getHero());
					
				}));
		this.gameLoop.getKeyFrames().add(kf);
		this.gameLoop.play();
		
	}
	
}