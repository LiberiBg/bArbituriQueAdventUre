package application.controleur;

import application.modele.Inventaire;
import application.modele.objet.Objet;
import application.vue.InventaireVue;
import javafx.collections.ListChangeListener;

public class ListeObsObjet implements ListChangeListener<Objet> {
	
	private InventaireVue inventaireVue ;
	
	public ListeObsObjet(InventaireVue inventaireVue) {
		this.inventaireVue = inventaireVue;
	}

	@Override
	public void onChanged(Change<? extends Objet> c) {
		System.out.println("changement");
		
	
		while (c.next()) {
			
			for (Objet o : c.getAddedSubList() ) {
				this.inventaireVue.ajouterObjetALaVue(o);
				}
			
			for (Objet o :c.getRemoved() ) {
				this.inventaireVue.supprimerObjetDeLaVue(o);
				
			}
		}
	} 

}
