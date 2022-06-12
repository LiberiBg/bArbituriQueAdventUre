package application.controleur;

import application.modele.Objet;
import application.vue.InventaireVue;
import javafx.collections.ListChangeListener;

public class ListeObsObjet implements ListChangeListener<Objet> {
	
	private InventaireVue inventaireVue ;
	
	
	public ListeObsObjet(InventaireVue inv) {
		this.inventaireVue = inv;
	}

	@Override
	public void onChanged(Change<? extends Objet> c) {
		System.out.println("changement");
		
	
		while (c.next()) {
			
			for (Objet o : c.getAddedSubList() ) {
				this.inventaireVue.afficherImage(o);
				}
			
			for (Objet o :c.getRemoved() ) {
				this.inventaireVue.supprimerImage(o);
				
			}
		}
	} 

}
