package application.modele;

import java.util.ArrayList;

import application.modele.outils.Epee;
import application.modele.outils.Hache;
import application.modele.outils.Pioche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Objet> listeObjets;
	
	public Inventaire() {
		listeObjets = FXCollections.observableArrayList();		
		listeObjets.add(new Hache(1,1,1));
		listeObjets.add(new Epee(2,1,1));
		listeObjets.add(new Pioche (3,1,1));
		}
	
	//METHODE AJOUTER OBJET 
	public void ajouterObjet(Objet p) {
		listeObjets.add(p);
	}

	
	// METHODE RETIRER OBJET intelligemment
	public void retirerObjet(Objet p) {
		listeObjets.remove(p);
	}

	public ObservableList<Objet> getListeObjet() {
		return this.listeObjets;
	}

}
