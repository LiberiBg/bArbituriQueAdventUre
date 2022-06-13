package application.controleur;

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
	private Heros hero;
	
	public ControleurTuileCliquée(int indice, Terrain terrain, Heros hero) {
		this.indiceTuile = indice;
		this.terrain = terrain;
		this.hero = hero;
	}

	@Override
	public void handle(MouseEvent event) {
		ImageView img = (ImageView) event.getSource();
//		System.out.println(terrain.trouverTuileSelonLIndice(this.indiceTuile));
		//Récupère les coordonnées de la tuile cliquée
		int x = (indiceTuile % Parametres.getNbrcolonnes()) * 16;
		int y = (indiceTuile / Parametres.getNbrcolonnes()) * 16;
		
		System.out.println("X de tuile cliquée : " + x);
		System.out.println("Y de tuile cliquée : " + y);
		//Si la tuile est trop éloignée il n'est pas possible de la détruire
		if(Math.abs(hero.getX() - x) <= 32 && Math.abs(hero.getY() - y) <= 32) {
			terrain.détuireBlocsSelonLIndice(indiceTuile);
			img.setImage(new Image("application/ressource/tile/tile-1.png"));
		}
	}
}
