package application.vue;

import java.util.ArrayList;

import application.modele.Inventaire;
import application.modele.Objets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

public class InventaireVue extends TilePane {

	private Inventaire inv;

	public InventaireVue(Inventaire inventaire) {
		this.inv = inventaire;
	}
	
	public void InitInventaire(Inventaire inv) {
		ImageView ImgInv = null ;
		ArrayList<Objets> Inventaire = this.inv.GetFournitures();
		for (int i = 0 ; i < Inventaire.size() ; i ++) {
//		switch (Inventaire.get(i)) {
//			case 1 : 
//				ImgInv = new ImageView(new Image ("application/ressource/epee-bois.png") );
//				break;
//			}
			
			
		}
	}
}
