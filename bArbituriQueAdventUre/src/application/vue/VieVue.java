package application.vue;

import application.modele.Parametres;
import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VieVue extends Pane{

	private Image[] tabImages;
	private ImageView imgV;
	//IntegerProperty vie;
	
	public VieVue(BorderPane root, IntegerProperty vie) {
		super();
		//this.vie = vie;
		
		this.tabImages = new Image[5];
		this.setHeight(20);
		this.setWidth(50);
		this.setOpacity(0.8);
		this.setLayoutX(Parametres.getNbrcolonnes() * 16 - 220);
		for (int i=0; i < tabImages.length; i++) {
			tabImages[i] = new Image("application/ressource/vie/vie" + i + ".png");
		}
		
		imgV = new ImageView(tabImages[0]);
		
		this.getChildren().add(imgV);
		
	}
	
	public void reafficherVie(int vie) {
		
		if (vie == 100)
			imgV.setImage(tabImages[0]);
		else if (vie >= 80)
			imgV.setImage(tabImages[1]);
		else if (vie >= 60)
			imgV.setImage(tabImages[2]);
		else if (vie >= 40)
			imgV.setImage(tabImages[3]);
		else if (vie >= 20)
			imgV.setImage(tabImages[4]);
	}
	

}
