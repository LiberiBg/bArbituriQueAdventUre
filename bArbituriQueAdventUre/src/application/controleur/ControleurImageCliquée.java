package application.controleur;

import application.modele.Environnement;
import application.modele.objet.outils.Epee;
import application.modele.personnages.Personnage;
import application.vue.BatmanVue;
import application.vue.HmpzVue;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleurImageCliquée implements EventHandler<MouseEvent> {
	
	private Environnement env;
	private ImageView imgV;
	private Pane environnementPane;
	
	public ControleurImageCliquée(Environnement env, ImageView imgV, Pane environnementPane) {
		this.env = env;
		this.imgV = imgV;
		this.environnementPane = environnementPane;
	}

	@Override
	public void handle(MouseEvent event) {
		this.imgV = (ImageView) event.getSource();
		Personnage p = null;
		if (this.imgV instanceof BatmanVue) {
			p = this.env.getBatman();
		}
		if (this.imgV instanceof HmpzVue) {
			p = this.env.getHmpz();
		}
		
		System.out.println(p);
		System.out.println(imgV);
		
		if (env.getHero().getObjetPorté() instanceof Epee && Math.abs(env.getHero().getX() - p.getX()) <= 48 && Math.abs(env.getHero().getY() - p.getY()) <= 48)  {
			p.setVie(p.getVie() - 50);
			System.out.println("vie" +p+ " : " + p.getVie());
		}
		if (p.getVie() == 0) {
			this.env.mort(p);
			environnementPane.getChildren().remove(imgV);
			System.out.println("MORT");
		}
		
			
	}
		
}
