package application.vue;
import java.util.ArrayList;
import java.util.HashMap;

import application.modele.Inventaire;
import application.modele.Objet;
import application.modele.fourniture.Fourniture;
import application.modele.outils.Arc;
import application.modele.outils.Epee;
import application.modele.outils.Hache;
import application.modele.outils.Outils;
import application.modele.outils.Pioche;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;


public class InventaireVue extends TilePane{

	public Inventaire inventaire ;
	private boolean afficheInventaire ;
	private HashMap<ImageView, Objet> mapImageToObjet;

	public InventaireVue(Inventaire inventaire) {
		this.inventaire = inventaire;
		this.afficheInventaire = true;
		this.mapImageToObjet = new HashMap<ImageView, Objet>();
		initInventaire();
	}
	
	public void initInventaire() {
		for (Objet o : this.inventaire.getListeObjet()) {
			ajouterObjetALaVue(o);
		}
	}
	
	public void ajouterObjetALaVue(Objet o) {
		String chemin = "application/ressource/" + o.getId() + ".png";
		System.out.println(chemin);
		System.out.println(o);
		System.out.println(o.getId());
//		ImageView img = new ImageView(new Image(chemin));
//		this.getChildren().add(img);
//		this.mapImageToObjet.put(img, o);
	}
	
	public void switchAffichageInventaire() {
		if(this.afficheInventaire) {
			this.setVisible(false);
			this.afficheInventaire = true;
			System.out.println("Inventaire affiché");
		}
		else {
			this.setVisible(true);
			this.afficheInventaire = false;
			System.out.println("Inventaire caché");
		}
			
	}
	
	public HashMap<ImageView, Objet> getMapImageToObjet(){
		return this.mapImageToObjet;
	}
	
}
