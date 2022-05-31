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
        initJoueur();
    }
	

	public void initJoueur() {
		this.translateXProperty().bind(this.hero.XProperty());
		this.translateYProperty().bind(this.hero.YProperty());
		System.out.println("it works");
	}
		
}
		
