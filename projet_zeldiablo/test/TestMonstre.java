package test;

import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.Gnome;
import org.junit.Test;
import utils.Place;

import static org.junit.Assert.assertEquals;

public class TestMonstre {

    /**
     * Test attaquer
     */
    @Test
    public void testAttaquerPersonnageAcote() {
        // Prep données
        Labyrinthe l = new Labyrinthe();
        Personnage p = new Personnage("Mohammed", 10, new Place(1,1), l);
        Gnome g = new Gnome(new Place(0,1), l);
        l.addPerso(p);
        l.addMonstre(g);

        // Méthode testee
        g.attaquer(l.getAventurier());

        // Result
        assertEquals("La vie du perso devrait etre 7", 7, l.getAventurier().getPv());
    }

    /**
     * Test attaquer
     */
    @Test
    public void testAttaquerPersonnagePasAcote() {
        // Prep données
        Labyrinthe l = new Labyrinthe();
        Personnage p = new Personnage("Mohammed", 10, new Place(0,1), l);
        Gnome g = new Gnome(new Place(0,3), l);
        l.addPerso(p);
        l.addMonstre(g);

        // Méthode testee
        g.attaquer(l.getAventurier());

        // Result
        assertEquals("La vie du perso devrait etre 10", 10, l.getAventurier().getPv());
    }
}
