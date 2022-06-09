package application.vue;
import java.util.ArrayList;

import application.controleur.ControleurChangementSprite;
import application.modele.Inventaire;
import application.modele.Objet;
import application.modele.fourniture.Fourniture;
import application.modele.outils.Arc;
import application.modele.outils.Epee;
import application.modele.outils.Hache;
import application.modele.outils.Outils;
import application.modele.outils.Pioche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;


public class InventaireVue extends TilePane{

	private ObservableList<Objet> inventaire;
	private boolean afficheInventaire ;

	public InventaireVue(ObservableList<Objet> inv) {
		super();
		inventaire = inv;
		afficheInventaire = false ;
		for (Objet o : inv) {
			afficherImage(o);
		}
		this.setVisible(afficheInventaire);
	}
	
	public boolean getafficheInventaire() {
		System.out.println(this.inventaire);
		return afficheInventaire ;		
	}
	
	public void desafficherInventaire() {
		afficheInventaire = false ; 
		this.setVisible(afficheInventaire);		
	}
	
	public void afficherInventaire() {
		afficheInventaire = true ; 
		this.setVisible(afficheInventaire);
	}	
	
	public void afficherImage(Objet o) {
		String chemin = "application/ressource/" + o.toId() + ".png";
		ImageView img = new ImageView(new Image(chemin));
		this.getChildren().add(img);
		
	}
	

	public void supprimerImage(Objet o) {
	//	this.getChildren().clear;
	}

}
