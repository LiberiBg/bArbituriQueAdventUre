package application.modele;

import java.util.List;

public class Colision {
	
	private int x, y;
	private List<String> blocks;
	private String id;
	
	public Colision (Terrain terrain) {
		this.blocks = terrain.getListeTerrain();
	}
	
	public boolean blockDessousVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y*20 + 40;
		id = blocks.get(x);
		return estVide(id);
	}
	
	public boolean blockDessusVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y*20 - 40;
		id = blocks.get(x);
		return estVide(id);
	}
	
	public boolean blockDroitVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y*20;
		id = blocks.get(x + 1);
		return estVide(id);
	}
	
	public boolean blockGaucheVide (int x, int y) {
		x = x/16;
		y = y/16;
		x = x + y*20;
		id = blocks.get(x - 1);
		return estVide(id);
	}
	
	public boolean estVide (String id) {
		return id.equals("-1");
	}
}
														