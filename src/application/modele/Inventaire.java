package application.modele;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaire {

private ArrayList<Objets>lesFournitures;
private Objets objets;


	public Inventaire() {
		super();
		this.lesFournitures = new ArrayList<>();
	}

	public ArrayList <Objets> GetFournitures() {
		return lesFournitures ;
	}
}	
