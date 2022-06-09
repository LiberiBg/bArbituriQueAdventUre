package application.vue;

import java.util.ArrayList;

import application.modele.Heros;
import application.modele.Objet;
import application.modele.outils.Epee;
import application.modele.outils.Pioche;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HerosVue extends ImageView {

	private Heros hero;
	//ArrayList<Image>ListeImg ; 
	Image[]Tabimg;
	//Objet o ; 


	public HerosVue(String url, Heros hero) {
		super();
		//this.ListeImg  = new ArrayList<Image>();
		Tabimg = new Image[3];
		setImage(new Image(url));
		this.hero = hero ;
		initJoueur();
		creerImage();
	}


	public void initJoueur() {
		
		this.translateXProperty().bind(this.hero.XProperty());
		this.translateYProperty().bind(this.hero.YProperty());
		System.out.println("it works");
	}

	public Image[]creerImage() {
		
		Image img ;
		for (int i = 0 ; i < Tabimg.length; i ++){
			String chemin = "application/ressource/hero "+ i +".png";
			img = new Image(chemin);
			Tabimg[i] = img;
			System.out.println(Tabimg[i]);
		}

		return Tabimg;
	}

	public void ChangerSprite() {
//		if (this.hero.objetEnMain()) {
//		//Objet o = this.hero.getObjetporté();
//			if (o instanceof Epee)
//				setImage(Tabimg[0]);
//			else if (o instanceof Pioche) {
//				setImage(Tabimg[1]);
//		}
	}
}

