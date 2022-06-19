package application.modele.objet;

public abstract class Objet {
	
	private int quantité;
	private String id ; 

	public Objet(String id , int quantité) {
		this.id = id;
		this.quantité = quantité;
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
	
	public void retirerQuantité(int qté) {
		this.quantité =this.quantité - qté;  ;
	}

}
