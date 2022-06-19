package application.controleur;

import java.util.HashMap;
import java.util.List;

import application.modele.Arbre;
import application.modele.Parametres;
import application.modele.Terrain;
import application.modele.objet.blocs.Blocs;
import application.modele.objet.blocs.Bois;
import application.modele.objet.outils.Hache;
import application.modele.objet.outils.Pioche;
import application.modele.personnages.Heros;
import application.vue.TerrainVue;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileCliquée implements EventHandler<MouseEvent> {

	private final int indiceTuile;
	private Terrain terrain;
	private TerrainVue terrainVue;
	private List<String> listeTerrain;
	private Heros hero;
	private ImageView img;
	private final String idTuilecliquée;
	private List<Arbre> listeArbre;

	public ControleurTuileCliquée(int indice, Terrain terrain, Heros hero, TerrainVue terrainVue) {
		this.indiceTuile = indice;
		this.terrain = terrain;
		this.terrainVue = terrainVue;
		this.listeTerrain = this.terrain.getListeTerrain();
		this.listeArbre = this.terrain.getListeArbre();
		this.hero = hero;
		this.idTuilecliquée = this.listeTerrain.get(indiceTuile);
	}

	@Override
	public void handle(MouseEvent event) {
		this.img = (ImageView) event.getSource();

		if(tuileAtteignable()) {
			if(this.hero.getObjetPorté() instanceof Hache) {
				arbre();
			}
			else if(this.hero.getObjetPorté() instanceof Pioche) {
				casserBlocPiochable();
			}
			
			baieRevigorante();
			

		}
//		for(Objet o : this.hero.getInventaire().getListeObjet())
//			System.out.println(o.getId() + " : " + o.getQuantité());
	}
	public boolean tuileAtteignable() {

		//Récupère les coordonnées de la tuile cliquée
		int x = (indiceTuile % Parametres.getNbrcolonnes()) * 16;
		int y = (indiceTuile / Parametres.getNbrcolonnes()) * 16;

		System.out.println("X de tuile cliquée : " + x);
		System.out.println("Y de tuile cliquée : " + y);

		//Si la tuile est trop éloignée il n'est pas possible de la détruire
		if(Math.abs(hero.getX() - x) <= 32 && Math.abs(hero.getY() - y) <= 32) {
			return true;
		}
		return false;
	}

	private void casserBlocPiochable() {
		String idBlocCliqué = this.terrain.getListeTerrain().get(this.indiceTuile);
		HashMap<String, Blocs> map = this.terrain.getmapStringToBloc();
		//Si le bloc miné est piochabe
		if(this.terrain.getListePiochable().contains(idBlocCliqué)) {
			System.out.println("CASSER BLOC");
			
			Blocs b = map.get(idBlocCliqué);
			b.setQuantité(1);
			System.out.println("bloc crée quantité" + b.getQuantité());
			this.hero.ajouterALinvetaire(b);
			
			
			détruireTuileCliquée();
		}
			
	}
	
	public void détruireTuileCliquée() {
		this.terrain.détuireBlocsSelonLIndice(this.indiceTuile);
		this.img.setImage(new Image("application/ressource/tile/tile-1.png"));
	}

	public void baieRevigorante() {
		if(this.idTuilecliquée.equals("48")) {
			this.hero.soigner(20);
			détruireTuileCliquée();
		}
	}

	public void arbre() {
		for(Arbre a : this.listeArbre) {
			if(a.indiceAppartientALArbre(this.indiceTuile)) {
				Hache h = (Hache)this.hero.getObjetPorté();
				a.infligerDegat(h.getDegat());
				System.out.println(a.getVieArbreEntier());

				if(a.getVieArbreEntier() <= 0) {
					for(int i = 0; i < a.getListeTuileComposantLArbre().size(); i++) {
						supprimerTuile(a.getListeTuileComposantLArbre().get(i));
					}
					
					this.hero.ajouterALinvetaire(new Bois(a.getListeTuileComposantLArbre().size()));
					//Ajouter bois équivalent a l'arbre dans l'inventaire
				}
			}
		}


	}

	private void supprimerTuile(int indiceTuile) {
		this.terrain.détuireBlocsSelonLIndice(indiceTuile);
		this.terrainVue.supprimerTuileDeLaVue(indiceTuile);
	}
}





















