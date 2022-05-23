package application.modele;

public class Inventaire {

	private Objet[] listeObjet;
	
	public Inventaire() {
		//Taille Inventaire
		this.setListeObjet(new Objet[30]);

		//Remplir l'inventaire de vide lors de l'iniatilisation
		}
	
	//METHODE AJOUTER OBJET intelligemment
	
	// METHODE RETIRER OBJET intelligemment

	public Objet[] getListeObjet() {
		return listeObjet;
	}

	public void setListeObjet(Objet[] listeObjet) {
		this.listeObjet = listeObjet;
	}
}
