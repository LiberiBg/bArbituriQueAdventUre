package application.vue;
import java.util.ArrayList;

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
//import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;


public class InventaireVue extends TilePane{

	public Inventaire inventaire ;
	private boolean afficheInventaire ;

	public InventaireVue(Inventaire inv) {
		super();
		inventaire = inv;
		afficheInventaire = false ;
	}
	
	public boolean getafficheInventaire() {
		return afficheInventaire ;
	}
	
	public void desafficherInventaire() {
		afficheInventaire = false ; 
		this.getChildren().clear();
	}
	
	public void afficherInventaire() {
		afficheInventaire = true ; 
		ImageView img = null ;	
		ArrayList<Objet>ListeObjet = inventaire.getListeObjet() ;
		
			for ( int i = 0 ; i < ListeObjet.size(); i++) {
				
					if (ListeObjet.get(i) instanceof Outils) {
						if (ListeObjet.get(i) instanceof Arc) {
							img = new ImageView(new Image("application/ressource/ezgif.com-gif-maker(4).png"));	
						}
						else if (ListeObjet.get(i) instanceof Epee) {
							img = new ImageView(new Image("application/ressource/ezgif.com-gif-maker(1).png"));	
						}
						else if (ListeObjet.get(i) instanceof Hache) {
							img = new ImageView(new Image("application/ressource/ezgif.com-gif-maker(2).png"));	
						}
						else if (ListeObjet.get(i) instanceof Pioche) {
							img = new ImageView(new Image("application/ressource/ezgif.com-gif-maker(3).png"));	
						}
					}
					else if (ListeObjet.get(i) instanceof Fourniture) {
						
				}
					this.getChildren().add(img);
			}
		}
}
