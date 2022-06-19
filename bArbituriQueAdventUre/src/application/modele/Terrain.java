package application.modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import application.modele.objet.blocs.Blocs;
import application.modele.objet.blocs.Pierre;
import application.modele.objet.blocs.Terre;

public class Terrain {

	private List<Arbre> listeArbre;
	private List<String> listeTerrain;
	private List<String> listePiochable;
	private HashMap<String, Blocs> mapStringToBloc;

	public Terrain() throws IOException {
		String file = Parametres.getCheminTerrain();
		this.mapStringToBloc = new HashMap<String, Blocs>();
		this.listePiochable = new ArrayList<String>();
		this.listeArbre = new ArrayList<Arbre>();
		this.listeTerrain = readFile(file);
		initArbre();
		initListePiochable();
		initMapStringToBlocs();
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

	private void initMapStringToBlocs() {
		Terre t = new Terre(1);
		Pierre p = new Pierre(1);
		for(int i = 0; i <= 5; i++)
			this.mapStringToBloc.put(Integer.toString(i), t);
		for(int i = 7; i <= 9; i++)
			this.mapStringToBloc.put(Integer.toString(i), t);
		for(int i = 14; i <= 16; i++)
			this.mapStringToBloc.put(Integer.toString(i), t);
		for(int i = 17; i <= 19; i++)
			this.mapStringToBloc.put(Integer.toString(i), p);
		for(int i = 24; i <= 26; i++)
			this.mapStringToBloc.put(Integer.toString(i), p);
		for(int i = 31; i <= 33; i++)
			this.mapStringToBloc.put(Integer.toString(i), p);
	}

	public List<String> getListeTerrain(){
		return this.listeTerrain;
	}

	public List<Arbre> getListeArbre(){
		return this.listeArbre;
	}

	public HashMap<String, Blocs> getmapStringToBloc(){
		return this.mapStringToBloc;
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

	private void initListePiochable() {
		for(int i = 0; i <= 20; i++)
			this.listePiochable.add(Integer.toString(i));
		for(int i = 24; i <= 27; i++)
			this.listePiochable.add(Integer.toString(i));
		for(int i = 31; i <= 34; i++)
			this.listePiochable.add(Integer.toString(i));
	}

	public List<String> getListePiochable(){
		return this.listePiochable;
	}

}