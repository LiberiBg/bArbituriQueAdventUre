package application.vue;
import java.util.HashMap;

import application.controleur.ControleurTuileInventaireCliquée;
import application.modele.Inventaire;
import application.modele.objet.Objet;
import application.modele.personnages.Heros;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;


public class InventaireVue extends TilePane{

	public Inventaire inventaire ;
	private boolean afficheInventaire ;
	private HashMap<ImageView, Objet> mapImageToObjet;
	private HashMap<Objet, ImageView> mapObjetToImage;
	private Heros hero;
	private BorderPane root;

	public InventaireVue(Heros hero, BorderPane r) {
		this.hero = hero;
		this.inventaire = this.hero.getInventaire();
		this.afficheInventaire = true;
		this.mapImageToObjet = new HashMap<ImageView, Objet>();
		this.mapObjetToImage = new HashMap<Objet, ImageView>();
		this.root = r ;
		initInventaire();

	}

	public void initInventaire() {
		for (Objet o : this.inventaire.getListeObjet()) {
			ajouterObjetALaVue(o);
		}
	}

	public void ajouterObjetALaVue(Objet o) {
		String chemin = "application/ressource/" + o.getId() + ".png";
		ImageView img = new ImageView(new Image(chemin));
		img.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurTuileInventaireCliquée(this.hero, img, this, root));
		this.getChildren().add(img);
		this.mapImageToObjet.put(img, o);
		this.mapObjetToImage.put(o, img);
	}

	public void switchAffichageInventaire() {
		if(this.afficheInventaire) {
			this.setVisible(false);
			this.afficheInventaire = false;
			System.out.println("Inventaire affiché");
		}
		else {
			this.setVisible(true);
			this.afficheInventaire = true;
			System.out.println("Inventaire caché");
		}

	}

	public HashMap<ImageView, Objet> getMapImageToObjet(){
		return this.mapImageToObjet;
	}

	public HashMap<Objet, ImageView> getMapObjetToImage(){
		return this.mapObjetToImage;
	}
	
	public void retirerObjetAlaVue(Objet o) {
		this.mapObjetToImage.remove(o);
	}
}