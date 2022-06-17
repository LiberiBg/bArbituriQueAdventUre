package application.vue;

import application.controleur.ControleurImageCliquée;
import application.modele.Environnement;
import application.modele.personnages.Batman;
import application.modele.personnages.Hmpz;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class HmpzVue extends ImageView{
	
	private Hmpz hmpz;
	
	public HmpzVue(Hmpz hmpz, Environnement env, Pane environnementPane) {
		super();
        setImage(new Image("application/ressource/litlehmpz.png"));
        this.hmpz = hmpz;
        initHmpz();
    	this.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurImageCliquée(env, this, environnementPane));

    }
	

	public void initHmpz() {
		this.translateXProperty().bind(this.hmpz.XProperty());
		this.translateYProperty().bind(this.hmpz.YProperty());
		System.out.println("Humpz works");
	}

}
