package application.controleur;

import application.modele.Environnement;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControleurImageCliquée implements EventHandler<MouseEvent> {
	
	private Environnement env;
	
	public ControleurImageCliquée(Environnement env) {
		this.env = env;
	}

	@Override
	public void handle(MouseEvent event) {
		this.env.getBatman().setVie(this.env.getBatman().getVie() - 50);
		System.out.println("vie batman :" + this.env.getBatman().getVie());
		if (this.env.getBatman().getVie() == 0)
			this.env.getBatman().mort();
	}

	
}
