package application.vue;

import application.controleur.ControleurImageCliquée;
import application.modele.Environnement;
import application.modele.personnages.Batman;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class BatmanVue extends ImageView {
	
	private Batman batman;
	
	public BatmanVue(String url, Batman batman, Environnement env, Pane environnementPane) {
		super();
        setImage(new Image(url));
        this.batman = batman ;
        initBatman();
    	this.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurImageCliquée(env, this, environnementPane));

    }
	

	public void initBatman() {
		this.translateXProperty().bind(this.batman.XProperty());
		this.translateYProperty().bind(this.batman.YProperty());
		System.out.println("batman works");
	}

	
	
}
