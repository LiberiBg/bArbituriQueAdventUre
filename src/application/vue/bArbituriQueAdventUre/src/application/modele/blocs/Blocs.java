package application.modele.blocs;

import application.modele.Objet;

public abstract class Blocs extends Objet {
		
	private int vieBloc;
	
	public Blocs(int id, int quantité, int quantitéMax) {
		super(id, quantité, quantitéMax);
		this.vieBloc = 100 ;
		// TODO Auto-generated constructor stub
	}


	
}
