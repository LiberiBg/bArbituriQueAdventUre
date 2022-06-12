package application.modele;

public abstract class Objet {
	
	private int quantité;
	private int quantitéMax;
	private String id ; 

	public Objet(String id , int quantité, int quantitéMax) {
		
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

	public String getId() {
		return id;
	}

}
