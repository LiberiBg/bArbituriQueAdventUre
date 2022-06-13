package application.modele.objet.blocs;

import application.modele.objet.Objet;

public abstract class Blocs extends Objet {
		
	private int vieBloc;
	
	public Blocs(String id, int quantité, int quantitéMax) {
		super(id, quantité, quantitéMax);
		this.vieBloc = 100 ;
	}


	
}
