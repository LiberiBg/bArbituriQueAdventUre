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
//		this.translateXProperty().bind(hero.getX());
//		this.translateYProperty().bind(hero.getY());
	} 
	
	public void initJoueur() {
	//	Heros h = new Heros(0, 0);
		ImageView img = new ImageView(new Image("application/ressource/sprite.jpg"));
		creerSprite();
		img.translateXProperty().bind(this.hero.getX());
		img.translateYProperty().bind(this.hero.getY());
		System.out.println("it works");
	}
	
	public void creerSprite() {
		this.setRadius(10);
		this.setCenterX(200);
		this.setCenterY(250);
		

	}	
}
		
