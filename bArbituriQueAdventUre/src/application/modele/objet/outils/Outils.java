package application.modele.objet.outils;

import application.modele.objet.Objet;

public abstract class Outils extends Objet{
	
	private int degat;
	
	public Outils(String id, int quantité, int degat) {
		super(id, quantité);
		this.degat = degat;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	
	
	




	

}
