package application.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Terrain {
	
	
	private List<String> listeTerrain;

	public Terrain() throws IOException {
		File file = new File("/home/etudiants/info/manguyen/git/oui/bArbituriQueAdventUre/src/application/ressource/FirstMap.csv");
		this.listeTerrain = readFile(file);
	}
	
	public List<String> readFile(File file) throws IOException {
	
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


}