package application.test;

import org.junit.jupiter.api.Test;

import application.modele.Environnement;
import application.modele.Parametres;
import application.modele.personnages.Batman;
import application.modele.personnages.Heros;
import junit.framework.TestCase;

class BatmanTest extends TestCase{

	private Environnement env = new Environnement();
	private Heros hero = env.getHero();
	private Batman batman = env.getBatman();

	@Test
	public void testBatMouvement(){
		batman.setX(161);
		batman.setY(161);
		batman.batMouvement();
		env.getTerrain().getListeTerrain().set(11+10*Parametres.getNbrcolonnes(), "-1");
		env.getTerrain().getListeTerrain().set(11+10*Parametres.getNbrcolonnes(), "-1");

		//Block à gauche
		batman.setVitesseHorizontale(0);
		env.getTerrain().getListeTerrain().set(10+10*Parametres.getNbrcolonnes(), "50");
		batman.batMouvement();
		assertTrue(batman.getVitesseHorizontale() > 0);

		//Block à droite
		batman.setVitesseHorizontale(0);
		env.getTerrain().getListeTerrain().set(10+10*Parametres.getNbrcolonnes(), "-1");
		env.getTerrain().getListeTerrain().set(11+10*Parametres.getNbrcolonnes(), "50");
		batman.batMouvement();
		assertTrue(batman.getVitesseHorizontale() < 0);

		//Block à droite et à gauche
		batman.setVitesseHorizontale(0);
		env.getTerrain().getListeTerrain().set(10+10*Parametres.getNbrcolonnes(), "50");
		batman.batMouvement();
		assertEquals(0,batman.getVitesseHorizontale());
		env.getTerrain().getListeTerrain().set(10+10*Parametres.getNbrcolonnes(), "-1");
		env.getTerrain().getListeTerrain().set(11+10*Parametres.getNbrcolonnes(), "-1");
	}

	@Test
	public void testAttaqueHero(){
		batman.setX(100);
		batman.setY(100);
		hero.setX(100);
		hero.setY(100);
		//Batman peut attaquer
		batman.attaqueHero(hero);
		assertEquals(99,hero.getVie());

		batman.setX(500);
		//Batman ne peut pas attaquer
		batman.attaqueHero(hero);
		assertEquals(99,hero.getVie());

		batman.setX(116);
		//Batman ne peut toujours pas attaquer
		batman.attaqueHero(hero);
		assertEquals(99,hero.getVie());

		batman.setX(84);
		//Batman ne peut toujours pas attaquer
		batman.attaqueHero(hero);
		assertEquals(99,hero.getVie());
	}

	@Test
	void testAugmenterVitesseHaut(){
		batman.setVitesseVerticale(0);
		//peut sauter
		batman.setX(161);
		batman.setY(161);
		env.getTerrain().getListeTerrain().set(10+9*Parametres.getNbrcolonnes(), "-1");
		env.getTerrain().getListeTerrain().set(10+12*Parametres.getNbrcolonnes(), "50");
		batman.augmenterVitesseHaut();
		assertTrue(batman.getVitesseVerticale() < 0);


		//ne peut pas sauter
		//block au dessus
		env.getTerrain().getListeTerrain().set(10+9*Parametres.getNbrcolonnes(), "50");
		batman.augmenterVitesseHaut();
		assertEquals(0,batman.getVitesseHorizontale());

		//pas de block en dessous
		env.getTerrain().getListeTerrain().set(10+8*Parametres.getNbrcolonnes(), "-1");
		env.getTerrain().getListeTerrain().set(10+11*Parametres.getNbrcolonnes(), "-1");
		batman.augmenterVitesseHaut();
		assertEquals(0,batman.getVitesseHorizontale());
	}

}