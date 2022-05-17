package application.vue;

import application.modele.Heros;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HerosVue extends ImageView {

	private Heros hero;

	public HerosVue(String url, Heros hero) {
		super();
        setImage(new Image(url));
        this.hero = hero ;
    }
	

	public void initJoueur() {
		this.translateXProperty().bind(this.hero.getX());
		this.translateYProperty().bind(this.hero.getY());
		System.out.println("it works");
	}
		
}
		
