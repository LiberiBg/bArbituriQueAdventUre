package application;

import java.util.ArrayList;
import java.util.List;

import application.modele.Parametres;

public class Arbre {

	private int vieArbreEntier;
	private final int vieTuileDArbre = 50;
	private List<Integer> listeTuileComposantLArbre;
	private List<String> listeTerrain;
	
	public Arbre(int indicePremiereTuileArbre, List<String> listeTerrain) {
		this.listeTuileComposantLArbre = new ArrayList<Integer>();
		this.listeTerrain = listeTerrain;
		initTuileComposantLArbre(indicePremiereTuileArbre);
		this.vieArbreEntier = this.vieTuileDArbre * this.listeTuileComposantLArbre.size();
	}

	private void initTuileComposantLArbre(int indicePremiereTuileArbre) {
		int indiceTuileArbre = indicePremiereTuileArbre;
		this.listeTuileComposantLArbre.add(indiceTuileArbre);
		
		while(!this.listeTerrain.get(indiceTuileArbre).equals("37")) {
			indiceTuileArbre = indiceTuileArbre + Parametres.getNbrcolonnes();
			this.listeTuileComposantLArbre.add(indiceTuileArbre);
		}
		System.out.println(this.listeTuileComposantLArbre);
	}

	public List<Integer> getListeTuileComposantLArbre(){
		return this.listeTuileComposantLArbre;
	}
	
	public int getVieArbreEntier() {
		return this.vieArbreEntier;
	}

	public boolean indiceAppartientALArbre(int indiceTuile) {
		return this.listeTuileComposantLArbre.contains(indiceTuile);
	}
	
	public void infligerDegat(int dégat) {
		this.vieArbreEntier = this.vieArbreEntier - dégat;
	}
}
