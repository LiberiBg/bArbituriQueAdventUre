package application.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.Arbre;

public class Terrain {
	
	private List<Arbre> listeArbre;
	private List<String> listeTerrain;

	public Terrain() throws IOException {
		String file = Parametres.getCheminTerrain();
		this.listeArbre = new ArrayList<Arbre>();
		this.listeTerrain = readFile(file);
		initArbre();
	}

	private List<String> readFile(String file) throws IOException {
	
		List<String> listeParLigne = new ArrayList<String>();
		List<String> resultat = new ArrayList<String>();
	    String val = " ";
	    int i=0;
	    FileReader fr = new FileReader(file);
	    BufferedReader br = new BufferedReader(fr);
	    
	    for (String line = br.readLine(); line != null; line = br.readLine()) {
	        listeParLigne.add(line);
	        val = listeParLigne.get(i);
	    	List<String> list = new ArrayList<String>(Arrays.asList(val.split(",")));
	    	resultat.addAll(list);
	    	
	    	i++;
	    }
	    
	    br.close();
	    fr.close();

	    return resultat;
	}
	
	public List<String> getListeTerrain(){
		return this.listeTerrain;
	}
	
	public List<Arbre> getListeArbre(){
		return this.listeArbre;
	}
	
	public int trouverTuileSelonLIndice(int indice) {
		return Integer.parseInt(this.listeTerrain.get(indice));
	}
	
	public void détuireBlocsSelonLIndice(int indice) {
		this.listeTerrain.set(indice, "-1");
	}
	
	private void initArbre() {
		for(int indiceTuile = 0; indiceTuile < this.listeTerrain.size(); indiceTuile++) {
			if(this.listeTerrain.get(indiceTuile).equals("23")) {
				this.listeArbre.add(new Arbre(indiceTuile, this.listeTerrain));
				
			}
		}
		System.out.println("Nombre d'arbres sur le terrain : " + this.listeArbre.size());
	}
	
	public void supprimerArbreDuJeu(Arbre a) {
		this.listeArbre.remove(a);
	}
	
	


}