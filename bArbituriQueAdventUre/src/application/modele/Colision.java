package application.modele;

import java.util.List;

public class Colision {

	private List<String> blocks;
	private String id;
	private final static int col = Parametres.getNbrcolonnes();
	public Colision (Terrain terrain) {
		this.blocks = terrain.getListeTerrain();
	}

	public boolean blockDessousVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y * col + col * 2;
		id = blocks.get(x);
		return estVide(id);
	}

	public boolean blockDessusVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y * col - col;
		id = blocks.get(x);
		return estVide(id);
	}

	public boolean blockDroitVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y * col + 1;
		id = blocks.get(x);
		return estVide(id);
	}

	public boolean blockGaucheVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y * col;
		id = blocks.get(x);
		return estVide(id);
	}

	public boolean estVide (String id) {
		return id.equals("-1") || id.equals("48") || id.equals("37") || id.equals("23") || id.equals("30");
	}
}