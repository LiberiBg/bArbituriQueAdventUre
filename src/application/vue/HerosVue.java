package application.vue;

import application.modele.Heros;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;


public class HerosVue extends Circle {

	private Heros hero;

	
	public HerosVue(Heros hero) {
		super();
		this.hero = hero ;
	} 
	
	public void initJoueur() {
		
		new Image("application/ressource/sprite.jpg");
		
		creerSprite();
		this.translateXProperty().bind(this.hero.getX());
		this.translateYProperty().bind(this.hero.getY());
		System.out.println("it works");
	}
	
	public void creerSprite() {
		this.setRadius(10);
	}	
}
		
