package application.modele;

import java.util.ArrayList;

import application.modele.outils.Epee;
import application.modele.outils.Hache;
import application.modele.outils.Pioche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {
	
	// creer l'image de l'inventaire de la meme maniere que celle du terrain al'ancienne (tab)

	private ArrayList<Objet> listeObjets;
	private Hache hache ;
	private Epee epee ;
	private Pioche pioche ;
	
	public Inventaire() {
		//listeObjets = FXCollections.observableArrayList();
		hache = new Hache(1,1,1);
		epee = new Epee(1,1,1);
		pioche = new Pioche (1,1,1);		
		listeObjets = new ArrayList<Objet>();
		listeObjets.add(hache);
		listeObjets.add(epee);
		listeObjets.add(pioche);

	}
	
	//METHODE AJOUTER OBJET intelligemment
	public void ajouterObjet(Objet p) {
		for (int i = 0 ; i < listeObjets.size() ; i++ ) {
			if ( p instanceof Objet) {
				listeObjets.add(p);
			}
		}
	}
	
	// METHODE RETIRER OBJET intelligemment

	public ArrayList<Objet> getListeObjet() {
		return this.listeObjets;
	}
	
	//public void get
	
}
