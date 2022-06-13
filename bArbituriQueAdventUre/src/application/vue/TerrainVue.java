package application.vue;


import java.util.List;

import application.controleur.ControleurTuileCliquée;
import application.controleur.ControleurTuileQuittée;
import application.controleur.ControleurTuileSurvolée;
import application.modele.Parametres;
import application.modele.Terrain;
import application.modele.personnages.Heros;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;

public class TerrainVue extends TilePane{
	
	Terrain terrain;
	Heros hero;
	
	public TerrainVue(Terrain ter, Heros hero) {
		super();
		this.setPrefColumns(Parametres.getNbrcolonnes());
		this.setPrefRows(Parametres.getNbrlignes());
		this.terrain = ter;
		this.hero = hero;
		initCarte();
	}

	public void initCarte() {
		String chemin;
		ImageView img = null;
		List<String> terrain = this.terrain.getListeTerrain();
		System.out.println(terrain);
		for (int i=0; i < terrain.size(); i++) {
			chemin = "application/ressource/tile/tile" +terrain.get(i)+ ".png";
			img = new ImageView(new Image(chemin));

			this.getChildren().add(img);
			img.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new ControleurTuileSurvolée());
			img.addEventHandler(MouseEvent.MOUSE_EXITED, new ControleurTuileQuittée());
			img.addEventHandler(MouseEvent.MOUSE_CLICKED, new ControleurTuileCliquée(i, this.terrain, this.hero));
		}
		
	}
	
	
}