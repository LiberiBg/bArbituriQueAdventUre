package application.modele;

public abstract class Objet {
	
	private int quantité;
	private int quantitéMax;
	private int id ; 

	public Objet(int id , int quantité, int quantitéMax) {
		this.setQuantité(quantité);
		this.setQuantitéMax(quantitéMax);
		this.id = id ;
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
