package test;

import jeu.Labyrinthe;
import jeu.Niveau;
import jeu.Personnage;
import jeu.monstre.Gnome;
import org.junit.Test;
import utils.Place;
import static org.junit.Assert.assertEquals;

public class TestMonstre {

    /**
     * Test attaquer avec un personnage a côté
     */
    @Test
    public void testAttaquerPersonnageAcote() {
        // Prep données
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage p = new Personnage("Mohammed", 10, new Place(1, 1), l, n);
        Gnome      g = new Gnome(new Place(0, 1), l);
        l.addPerso(p);
        l.addMonstre(g);

        // Méthode testee
        g.attaquer(l.getAventurier());

        // Result
        assertEquals("La vie du perso devrait etre 7", 7, l.getAventurier().getPv());
    }

    /**
     * Test attaquer un personnage pas a côté
     */
    @Test
    public void testAttaquerPersonnagePasAcote() {
        // Prep données
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage p = new Personnage("Mohammed", 10, new Place(0, 1), l, n);
        Gnome      g = new Gnome(new Place(0, 3), l);
        l.addPerso(p);
        l.addMonstre(g);

        // Méthode testee
        g.attaquer(l.getAventurier());

        // Result
        assertEquals("La vie du perso devrait etre 10", 10, l.getAventurier().getPv());
    }

    /**
     * Test attaquer un personnage pas sur le
     * même labyrinthe
     */
    @Test
    public void testAttaquerPersonnagePasSurLeMemeLabyrinthe() {
        // Prep données
        Labyrinthe labyperso = new Labyrinthe();
        Labyrinthe labygnome = new Labyrinthe();
        Niveau     n         = new Niveau();
        n.addLaby(labygnome);
        Personnage p       = new Personnage("Mohammed", 10, new Place(0, 1), labyperso, n);
        Personnage inutile = new Personnage("inutile", 10, new Place(10, 10), labygnome, n);
        Gnome      g       = new Gnome(new Place(0, 2), labygnome);
        labyperso.addPerso(p);
        labygnome.addPerso(inutile);
        labygnome.addMonstre(g);

        // Méthode testee
        g.attaquer(labyperso.getAventurier());

        // Result
        assertEquals("La vie du perso devrait etre 10", 10, labyperso.getAventurier().getPv());
        assertEquals("La vie du perso devrait etre 10", 10, labygnome.getAventurier().getPv());

    }
}
