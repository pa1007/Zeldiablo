package test;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.Gnome;
import org.junit.Test;
import utils.Place;

import static junit.framework.TestCase.assertEquals;

public class TestJeuPerso {
    /**
     * Test de la mort de l'aventurier dans le labyrinthe et arret de la partie
     */
    @Test
    public void testMortPersonnageArretPartie() {
        // Preparation des donnees
        Place p = new Place(1, 1);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Julien", 4 , p, l);
        JeuPerso jp = new JeuPerso(perso, l);
        Gnome g = new Gnome(new Place(0,0), l);
        l.addPerso(perso);
        l.addMonstre(g);
        g.seDeplacer('S');
        g.seDeplacer('N');
        g.seDeplacer('S');
        g.seDeplacer('N');

        // Methode testee
        boolean res = perso.etreMort();
        boolean res2 = jp.etreFini();
        // Verification
        assertEquals(
                "Le personnage devrait etre mort",
                true,
                res
        );
        assertEquals("La partie devrait etre fini", true, res2);
    }


    /**
     * Test de la survie de l'aventurier dans le labyrinthe et poursuite de la partie
     */
    @Test
    public void testSurviePersonnagePoursuitePartie() {
        // Preparation des donnees
        Place p = new Place(0, 0);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Paul", 10 , p, l);
        JeuPerso jp = new JeuPerso(perso, l);
        Gnome g = new Gnome(new Place(1,1), l);
        l.addPerso(perso);
        l.addMonstre(g);
        System.out.println(perso.getPv());
        g.seDeplacer('N');
        System.out.println(perso.getPv());
        g.seDeplacer('S');

        // Methode testee
        boolean res = perso.etreMort();
        boolean res2 = jp.etreFini();
        // Verification
        assertEquals(
                "Le personnage ne devrait pas etre mort",false,res);
        assertEquals("La partie ne evrait pas etre fini",false, res2);
    }
}
