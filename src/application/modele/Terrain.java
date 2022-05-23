package application.modele;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//import application.Parametres;

public class Terrain {
	
	static String[] terrain  ;
//	int [] tabTerrain = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//			-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//			-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//			-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,
//			-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,21,
//			-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,21,21,21,20,
//			-1,-1,-1,21,21,21,-1,-1,-1,-1,21,21,21,21,21,21,20,20,20,20,
//			21,21,21,20,20,20,21,21,21,21,20,20,20,20,20,20,20,20,20,20,
//			20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,
//			20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20};
	

	
	public static void InitMap () throws IOException {
	String path = "/home/etudiants/info/wgane/Téléchargements/FirstMap.csv";
	String line = "" ;
	try {
		BufferedReader br = new BufferedReader(new FileReader(path));
	
		while((line = br.readLine()) != null) {
			terrain = line.split(",");
		//	System.out.println(terrain[5]);

		}
	
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
	
	public static String[] getTerrain(){
		return terrain;
	}
	
}