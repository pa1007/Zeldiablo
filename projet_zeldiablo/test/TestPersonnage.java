package test;

import jeu.Labyrinthe;
import jeu.Niveau;
import jeu.Personnage;
import jeu.monstre.Gnome;
import org.junit.Test;
import utils.Place;
import static org.junit.Assert.*;

public class TestPersonnage {

    /**
     * Ce test vérifie si le personnage peut se deplacer vers le nord
     */
    @Test
    public void testSeDeplacerNord() {
        Place      place1 = new Place(1, 1);
        Labyrinthe l      = new Labyrinthe();
        Niveau     n      = new Niveau();
        n.addLaby(l);
        Personnage perso = new Personnage("bob", 10, place1, l, n);

        perso.seDeplacer('N');

        assertEquals("mauvaise place", new Place(1, 0), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers le sud
     */
    @Test
    public void testSeDeplacerSud() {
        Place      place1 = new Place(1, 1);
        Labyrinthe l      = new Labyrinthe();
        Niveau     n      = new Niveau();
        n.addLaby(l);
        Personnage perso = new Personnage("bob", 10, place1, l, n);
        perso.setLabyrinthe(l);

        perso.seDeplacer('S');

        assertEquals("mauvaise place", new Place(1, 2), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers l'est
     */
    @Test
    public void testSeDeplacerEst() {
        Place      place1 = new Place(1, 1);
        Labyrinthe l      = new Labyrinthe();
        Niveau     n      = new Niveau();
        n.addLaby(l);
        Personnage perso = new Personnage("bob", 10, place1, l, n);
        perso.setLabyrinthe(l);

        perso.seDeplacer('E');

        assertEquals("mauvaise place", new Place(2, 1), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers l'ouest
     */
    @Test
    public void testSeDeplacerOuest() {
        Place      place1 = new Place(1, 1);
        Labyrinthe l      = new Labyrinthe();
        Niveau     n      = new Niveau();
        n.addLaby(l);
        Personnage perso = new Personnage("bob", 10, place1, l, n);
        perso.setLabyrinthe(l);

        perso.seDeplacer('O');

        assertEquals("mauvaise place", new Place(0, 1), place1);
    }

    /**
     * Ce test vérifie que le personnage ne bouge pas si le charactere n'est pas valide
     */
    @Test
    public void testSeDeplacerMauvaisChar() {
        Place      place1 = new Place(1, 1);
        Labyrinthe l      = new Labyrinthe();
        Niveau     n      = new Niveau();
        n.addLaby(l);
        Personnage perso = new Personnage("bob", 10, place1, l, n);
        perso.setLabyrinthe(l);

        perso.seDeplacer('R');

        assertEquals("mauvaise place", new Place(1, 1), place1);
    }

    /**
     * Test d'attaquer un monstre
     */
    @Test
    public void testAttaquerMonstre() {
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage paul = new Personnage("Paul", 10, new Place(1, 1), l, n);
        Gnome      g    = new Gnome(new Place(1, 3), l);
        l.addMonstre(g);
        l.addPerso(paul);
        paul.setLabyrinthe(l);
        paul.seDeplacer('S');

        paul.attaquer();

        assertEquals("Le monstre devrait avoir 0 pdv", 0, g.getPv());
    }

    /**
     * Test d'attaquer un monstre pas a côté
     */
    @Test
    public void testAttaquerMonstrePasAcote() {
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage paul = new Personnage("Paul", 10, new Place(1, 1), l, n);
        Gnome      g    = new Gnome(new Place(1, 4), l);
        l.addMonstre(g);
        l.addPerso(paul);
        paul.setLabyrinthe(l);
        paul.seDeplacer('S');

        paul.attaquer();

        assertEquals("Le monstre devrait avoir 3 pdv", 3, g.getPv());
    }

    /**
     * Test d'attaquer un monstre mais en fait il n'y
     * en a pas
     */
    @Test
    public void testAttaquerMonstreMaisEnFaitIlNYAPasDeMonstreSurLeLabyrinthe() {
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage paul = new Personnage("Paul", 10, new Place(1, 1), l, n);
        l.addPerso(paul);
        paul.setLabyrinthe(l);
        paul.seDeplacer('S');

        paul.attaquer();

        // Ne devrait pas renvoyer d'erreur
    }

    /**
     * Test d'attaque de monstre pour qu'il meurt
     */
    @Test
    public void testAttaqueMeurtreMonstre() {
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage paul = new Personnage("Paul", 10, new Place(1, 1), l, n);
        l.addPerso(paul);
        Gnome g = new Gnome(new Place(0, 1), l);
        l.addMonstre(g);
        paul.attaquer();


        assertTrue("Le gnome devrait etre mort", g.etreMort());
    }

    /**
     * Test d'attaque de monstre mais ne meurt pas
     */
    @Test
    public void testAttaqueMonstreMaisNeMeurtPas() {
        Labyrinthe l = new Labyrinthe();
        Niveau     n = new Niveau();
        n.addLaby(l);
        Personnage paul = new Personnage("Paul", 10, new Place(1, 1), l, n);
        paul.setDegats(1);
        l.addPerso(paul);
        Gnome g = new Gnome(new Place(0, 1), l);
        l.addMonstre(g);
        paul.attaquer();

        assertFalse("Le gnome ne devrait pas etre mort", g.etreMort());
        assertEquals("Le gnome devrait avoir 2 pv", 2, g.getPv());
    }
}
