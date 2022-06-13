package application.controleur;

import java.util.ArrayList;
import java.util.List;

import application.modele.Parametres;
import application.modele.Terrain;
import application.modele.personnages.Heros;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleurTuileCliquée implements EventHandler<MouseEvent> {

	private int indiceTuile;
	private Terrain terrain;
	private List<String> listeTerrain;
	private Heros hero;
	private ImageView img;

	public ControleurTuileCliquée(int indice, Terrain terrain, Heros hero) {
		this.indiceTuile = indice;
		this.terrain = terrain;
		this.listeTerrain = this.terrain.getListeTerrain();
		this.hero = hero;
	}

	@Override
	public void handle(MouseEvent event) {
		this.img = (ImageView) event.getSource();

		if(tuileAtteignable()) {
			baieRevigorante();
			détruireTuile();
		}
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

	public void détruireTuile() {
		this.terrain.détuireBlocsSelonLIndice(this.indiceTuile);
		this.img.setImage(new Image("application/ressource/tile/tile-1.png"));
	}

	public void baieRevigorante() {
		if(this.listeTerrain.get(indiceTuile).equals("48")) {
			this.hero.soigner(20);
		}
	}

	
}






















