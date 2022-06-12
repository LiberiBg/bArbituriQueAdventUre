package application.modele;

import application.modele.outils.Epee;
import application.modele.outils.Hache;
import application.modele.outils.Pioche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Objet> listeObjetObs;
	
	public Inventaire() {
		listeObjetObs = FXCollections.observableArrayList();
		ajouterObjet(new Hache(1));
		ajouterObjet(new Epee(1));
		ajouterObjet(new Pioche(1));
		//Nathan check la construction des outils stp c'est pas normal qu'ils soient créer avec un ID null et je sais pas comment corriger ça
		}
	
	//METHODE AJOUTER OBJET 
	public void ajouterObjet(Objet o) {
		this.listeObjetObs.add(o);
	}

	public void retirerObjet(Objet o) {
		listeObjetObs.remove(o);
	}

	public ObservableList<Objet> getListeObjet() {
		return this.listeObjetObs;
	}
}
	