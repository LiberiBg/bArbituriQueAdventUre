package application.modele;

public abstract class Objet {
	
	private String cheminSprite;
	private int quantité;
	private int quantitéMax;

	public Objet(String cheminSprite, int quantité, int quantitéMax) {
		this.cheminSprite = cheminSprite;
		this.setQuantité(quantité);
		this.setQuantitéMax(quantitéMax);
	}

	public String getCheminsprite() {
		return this.cheminSprite;
	}
	
	public void setCheminSprite(String cheminSprite) {

		this.cheminSprite = cheminSprite;
	}

	public int getQuantitéMax() {
		return quantitéMax;
	}

	public void setQuantitéMax(int quantitéMax) {
		this.quantitéMax = quantitéMax;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
}
