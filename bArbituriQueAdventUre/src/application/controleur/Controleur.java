package application.controleur;

import java.net.URL;
import java.util.ResourceBundle;

import application.modele.Environnement;
import application.vue.BatmanVue;
import application.vue.HerosVue;
import application.vue.HmpzVue;
import application.vue.InventaireVue;
import application.vue.TerrainVue;
import application.vue.VieVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Image de Fond
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
		
		//Creation de l'environnement
		environnement = new Environnement();
		TerrainVue terrainVue = new TerrainVue(environnement.getTerrain(), environnement.getHero());
		environnementPane.getChildren().add(terrainVue);

		//Creation Vue du Hero
		HerosVue heroVue = new HerosVue(environnement.getHero());
		environnementPane.getChildren().add(heroVue);
		
		//Creation Vue de Batman
		BatmanVue batmanVue = new BatmanVue("application/ressource/litlebatman.png", environnement.getBatman(), environnement, environnementPane);
		environnementPane.getChildren().add(batmanVue);
		
		//Creation Vue de Hmpz
		HmpzVue hmpzVue = new HmpzVue(environnement.getHmpz(), environnement, environnementPane);
		environnementPane.getChildren().add(hmpzVue);
		
		//Creation de la vue de l'inventairethis.environnement.getBatman().seDeplacer();
		this.environnement.getBatman().gravite();
		this.environnement.getBatman().seDeplace();
		
		this.environnement.getBatman().attaqueHero(this.environnement.getHero());
		InventaireVue InventaireVue = new InventaireVue(environnement.getHero(), root);
		environnementPane.getChildren().add(InventaireVue);
		
		//Creation de la vue de la vie
		this.vieVue = new VieVue(root, environnement.getHero().vieProperty());
		environnementPane.getChildren().add(vieVue);
		
		//listener vie
		environnement.getHero().vieProperty().addListener(new VieListener(this.vieVue, environnement.getHero()));
		environnement.getHero().getInventaire().getListeObjet().addListener(new ListeObsObjet(InventaireVue));
		//KeyEvent
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getHero(), InventaireVue));
		root.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getHero()));
		
		//Début de l'animation et de la gameloop
		initAnimation();
		gameLoop.play();	
		
		
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),
				(ev -> {
					this.environnement.getHero().seDeplacer();

					if (environnement.getBatman() != null) {
						this.environnement.getBatman().seDeplacer();
						this.environnement.getBatman().seDeplace();					
						this.environnement.getBatman().attaqueHero(this.environnement.getHero());
						
					if(environnement.getHmpz() != null) {
						this.environnement.getHmpz().seDeplacer();
					}
					}
				}));
		this.gameLoop.getKeyFrames().add(kf);
		this.gameLoop.play();
		
	}
	
	
	
}