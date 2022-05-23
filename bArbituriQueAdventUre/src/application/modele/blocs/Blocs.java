package application.modele.blocs;

import application.modele.Objet;

public abstract class Blocs extends Objet {
	
	private int vieBloc;
	
	public Blocs(String cheminSprite, int quantité, int quantitéMax) {
		super(cheminSprite, quantité, 60);
	}
}
