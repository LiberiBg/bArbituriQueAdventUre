package application.modele.personnages;

import application.modele.Inventaire;
import application.modele.Terrain;
import application.modele.objet.Objet;
import application.modele.objet.blocs.Blocs;

public class Heros extends Personnage{

	private Objet objetPorté;

	private Inventaire inventaire;
	
	public Heros(int x, int y, Terrain terrain) {
		super(x, y, terrain, 100);
		this.inventaire = new Inventaire();
	}	
	
	public void ekipHero(Objet itemEquipe) {
		this.objetPorté = itemEquipe;
	}

	public Objet getObjetPorté() {
		return objetPorté;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void soigner(int soinProdigué) {
		this.setVie(getVie() + soinProdigué);
		if(this.getVie() >= 100) {
			this.setVie(100);
		}
	}

	public void ajouterALinvetaire(Objet o) {
		boolean objDéjàDansLInv = false;
		if(o instanceof Blocs) {
			for(int i = 0; i < this.inventaire.getListeObjet().size(); i++) {
				if(o.getId().equals(this.inventaire.getListeObjet().get(i).getId())) {
					this.inventaire.getListeObjet().get(i).setQuantité(
							this.inventaire.getListeObjet().get(i).getQuantité()
							+ o.getQuantité());
					System.out.println(this.inventaire.getListeObjet().get(i).getId() + this.inventaire.getListeObjet().get(i).getQuantité());
					objDéjàDansLInv = true;
				}
			}
			if(!objDéjàDansLInv)
				this.inventaire.ajouterObjet(o);
		}
		else
			this.inventaire.ajouterObjet(o);
	}


}