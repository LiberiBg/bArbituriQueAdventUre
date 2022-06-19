package application.modele;

import java.util.Optional;

import application.modele.objet.Objet;
import application.modele.objet.blocs.Bois;
import application.modele.objet.blocs.Pierre;
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
		ajouterObjet(new Pierre(2));
		ajouterObjet(new Bois(6));
		}
	
	public void ajouterObjet(Objet o) {
		this.listeObjetObs.add(o);
	}

	public void retirerObjet(String o) {
		listeObjetObs.remove(getIdObjetDansInventaire(o));
	}

	public ObservableList<Objet> getListeObjet() {
		return this.listeObjetObs;
	}
	
	public Objet getIdObjetDansInventaire(String o) {
	
		Objet objcherche = null  ;	
		for ( Objet ob : listeObjetObs) {
				if (ob.getId().equals(o) ) {
					objcherche = ob ;

				}
			}
		return objcherche ;
	}
	
}
	