package application.modele.outils;

import application.modele.Objet;

public abstract class Outils extends Objet{
	
	private double degat;

	public Outils(String cheminSprite, int quantité, int quantitéMax) {
		super(cheminSprite, quantité, 1);
	}

	

}
