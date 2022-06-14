package application.vue;

import application.controleur.ControleurImageCliquée;
import application.modele.Environnement;
import application.modele.personnages.Batman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BatmanVue extends ImageView {
	
	private Batman batman;
	
	public BatmanVue(String url, Batman batman, Environnement env) {
		super();
        setImage(new Image(url));
        this.batman = batman ;
        initJoueur();
    	this.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurImageCliquée(env));

    }
	

	public void initJoueur() {
		this.translateXProperty().bind(this.batman.XProperty());
		this.translateYProperty().bind(this.batman.YProperty());
		System.out.println("batman works");
	}

	
	
}
