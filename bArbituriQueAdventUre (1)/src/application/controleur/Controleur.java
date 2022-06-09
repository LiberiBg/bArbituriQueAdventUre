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
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		environnement = new Environnement();
		TerrainVue terrainVue = new TerrainVue(environnement.getTerrain());
		environnementPane.getChildren().add(terrainVue);

		HerosVue heroVue = new HerosVue("application/ressource/sprite.png", environnement.getHero());
		environnementPane.getChildren().add(heroVue);
	//	changeListener <
		
		InventaireVue InventaireVue = new InventaireVue(environnement.getHero().getInventaire().getListeObjet());
		ListChangeListener<Objet> Obs = new ListeObsObjet(InventaireVue);
		//environnementPane.addEventHandler(MouseEvent.MOUSE_CLICKED,new ControleurChangementSprite(herosVue));
		
		environnement.getHero().getInventaire().getListeObjet().addListener(Obs);
		//environnement.getHero().getInventaire().ajouterObjet(new Hache(1,1,1));
		
		root.addEventHandler(KeyEvent.KEY_PRESSED, new KeyPressed(environnement.getHero(), InventaireVue));
		root.addEventHandler(KeyEvent.KEY_RELEASED, new KeyReleased(environnement.getHero()));
		
		initAnimation();
		//demarre l'animation
		gameLoop.play();
		
		environnementPane.getChildren().add(InventaireVue);
		
	}

	private void initAnimation() {
		gameLoop = new Timeline();
		gameLoop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(
				Duration.seconds(0.017),
				(ev -> {
					this.environnement.getHero().seDeplacer();
					this.environnement.getHero().gravite();
					//FAIRE LA GRAVITE
				}));
		this.gameLoop.getKeyFrames().add(kf);
		this.gameLoop.play();
		
	}
	
}