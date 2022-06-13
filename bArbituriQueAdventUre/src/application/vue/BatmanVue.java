package application.vue;

import application.modele.personnages.Batman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BatmanVue extends ImageView {
	
	private Batman batman;
	
	public BatmanVue(String url, Batman batman) {
		super();
        setImage(new Image(url));
        this.batman = batman ;
        initJoueur();
    }
	

	public void initJoueur() {
		this.translateXProperty().bind(this.batman.XProperty());
		this.translateYProperty().bind(this.batman.YProperty());
		System.out.println("batman works");
	}

}
