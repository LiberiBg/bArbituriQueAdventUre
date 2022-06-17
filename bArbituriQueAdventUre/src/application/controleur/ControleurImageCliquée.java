package application.controleur;

import application.modele.Environnement;
import application.modele.objet.outils.Epee;
import application.vue.BatmanVue;
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
		if (env.getHero().getObjetPorté() instanceof Epee && Math.abs(env.getHero().getX() - env.getBatman().getX()) <= 32 && Math.abs(env.getHero().getY() - env.getBatman().getY()) <= 32)  {
			this.env.getBatman().setVie(this.env.getBatman().getVie() - 50);
			System.out.println("vie batman :" + this.env.getBatman().getVie());
		}
		if (this.env.getBatman().getVie() == 0) {
			this.env.mort();
			environnementPane.getChildren().remove(imgV);
			System.out.println("MORT");
		}
	}

	
}
