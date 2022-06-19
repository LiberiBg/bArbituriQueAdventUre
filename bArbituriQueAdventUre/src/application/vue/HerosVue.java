package application.vue;

import application.modele.Parametres;
import application.modele.personnages.Heros;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HerosVue extends ImageView {

	private Heros hero;

	public HerosVue(Heros hero) {
		super();
        setImage(new Image(Parametres.getCheminspritehero()));
        this.hero = hero ;
        initJoueur();
    }
	

	public void initJoueur() {
		this.translateXProperty().bind(this.hero.XProperty());
		this.translateYProperty().bind(this.hero.YProperty());
		System.out.println("it works");
	}	
}
		
