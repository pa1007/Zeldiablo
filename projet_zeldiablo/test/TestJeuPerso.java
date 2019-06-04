package test;

import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.Gnome;
import org.junit.Test;
import utils.Place;

import static junit.framework.TestCase.*;

public class TestJeuPerso {
    /**
     * Test de la mort de l'aventurier dans le labyrinthe et arret de la partie
     */
    @Test
    public void testMortPersonnageArretPartie() {
        // Preparation des donnees
        Place p = new Place(1, 1);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Julien", 4, p, l);
        JeuPerso jp = new JeuPerso(perso, l);
        Gnome g = new Gnome(new Place(0, 0), l);
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
        assertTrue("Le personnage devrait etre mort", res);
        assertTrue("La partie devrait etre fini", res2);
    }


    /**
     * Test de la survie de l'aventurier dans le labyrinthe et poursuite de la partie
     */
    @Test
    public void testSurviePersonnagePoursuitePartie() {
        // Preparation des donnees
        Place p = new Place(0, 0);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Paul", 10, p, l);
        JeuPerso jp = new JeuPerso(perso, l);
        Gnome g = new Gnome(new Place(1, 1), l);
        l.addPerso(perso);
        l.addMonstre(g);
        g.seDeplacer('N');
        g.seDeplacer('S');

        // Methode testee
        boolean res = perso.etreMort();
        boolean res2 = jp.etreFini();
        // Verification
        assertFalse("Le personnage ne devrait pas etre mort", res);
        assertFalse("La partie ne evrait pas etre fini", res2);
    }

    /**
     * Test personnage qui se déplace sur la case de sortie,
     * Devrait provoquer l'arret de la partie
     */
    @Test
    public void testPersonnageGagneLaPartieAvecLaSortie() {
        // Preparation des donnees
        Place p = new Place(19, 18);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Paul", 10, p, l);
        l.addPerso(perso);
        perso.seDeplacer('S');


        // Methode testee
        boolean res = perso.avoirGagne();
        // Verification
        assertTrue("Le personnage devrait avoir gagne", res);
    }

    /**
     * Test personnage qui se déplace sur le labyrinthe,
     * ne devrait pas provoquer l'arret de la partie
     */
    @Test
    public void testPersonnageGagnePas() {
        // Preparation des donnees
        Place p = new Place(12, 18);
        Labyrinthe l = new Labyrinthe();
        Personnage perso = new Personnage("Paul", 10, p, l);
        l.addPerso(perso);
        perso.seDeplacer('S');


        // Methode testee
        boolean res = perso.avoirGagne();
        // Verification
        assertFalse("Le personnage ne devrait pas avoir gagne", res);
    }
}
