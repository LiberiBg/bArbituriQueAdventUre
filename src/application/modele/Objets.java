package application.modele;

public class Objets {

	private int id ;
	public static int compteur;

	public Objets(int id) {
		this.id = 0 + compteur;
		compteur++ ;
	}
	
	public int GetId() {
		return id;
	}
	
	
}
