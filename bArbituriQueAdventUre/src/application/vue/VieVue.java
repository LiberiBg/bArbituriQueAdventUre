package application.vue;

import javafx.beans.property.IntegerProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class VieVue extends Pane{
	
//	private BorderPane root;
//	private Pane viePane;
	private Image[] tabImages;
	private ImageView imgV;
	IntegerProperty vie;
	
	public VieVue(BorderPane root, IntegerProperty vie) {
		super();
		this.vie = vie;
//		this = new Pane();
		
		this.tabImages = new Image[5];
		this.setMaxHeight(20);
		this.setMaxWidth(50);
		this.setLayoutX(root.getPrefWidth() + this.getMaxWidth());
		
		for (int i=0; i < tabImages.length; i++) {
			tabImages[i] = new Image("application/ressource/vie" + i + ".png");
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
