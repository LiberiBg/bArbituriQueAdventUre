package application.vue;
import java.util.ArrayList;

import application.modele.Heros;
import application.modele.Inventaire;
import application.modele.Objet;
import application.modele.Personnage;
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

	public InventaireVue(Inventaire inv) {
		super();
		inventaire = inv;
		afficherObjets();
	}
	
	public void afficherObjets() {
	
		// pour afficher l'objet 
		// changer l'arborescence pour les ressources
		
		ImageView img = null ;
		//Objet p = null ; 
		ArrayList<Objet>ListeObjet = inventaire.getListeObjet() ;
		System.out.println(ListeObjet);
//		Hache hache = new Hache(1,1,1);
//		ListeObjet.add(hache); 
		for ( int i = 0 ; i < ListeObjet.size(); i++) {
			
			//for (Objet p: inventaire.getListeObjet()) {
				if (ListeObjet.get(i) instanceof Outils) {
					if (ListeObjet.get(i) instanceof Arc) {
						img = new ImageView(new Image("/home/etudiants/info/wgane/git/bArbituriQueAdventUre/bArbituriQueAdventUre/src/application/ressource/ezgif.com-gif-maker(4).png"));	
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
					//return  la photo ;
				}
				else if (ListeObjet.get(i) instanceof Fourniture) {
					
			}
				this.getChildren().add(img);
//				System.out.println("lllll");
		}
	}
	
	
}
