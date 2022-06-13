package application.modele;

import application.modele.objet.Objet;
import application.modele.objet.outils.Epee;
import application.modele.objet.outils.Hache;
import application.modele.objet.outils.Pioche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

	private ObservableList<Objet> listeObjetObs;
	
	public Inventaire() {
		listeObjetObs = FXCollections.observableArrayList();
		ajouterObjet(new Hache(1));
		ajouterObjet(new Epee(1));
		ajouterObjet(new Pioche(1));
		}
	
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
	