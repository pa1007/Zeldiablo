package test;

import jeu.Personnage;
import org.junit.Test;
import utils.Place;

import static org.junit.Assert.assertEquals;

public class TestPersonnage {

    /**
     * Ce test vérifie si le personnage peut se deplacer vers le nord
     */
    @Test
    public void testSeDeplacerNord() {
        Place place1 = new Place(1, 1);
        Personnage perso = new Personnage("bob", place1);

        perso.seDeplacer('N');

        assertEquals("mauvaise place", new Place(1, 2), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers le sud
     */
    @Test
    public void testSeDeplacerSud() {
        Place place1 = new Place(1, 1);
        Personnage perso = new Personnage("bob", place1);

        perso.seDeplacer('S');

        assertEquals("mauvaise place", new Place(1, 0), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers l'est
     */
    @Test
    public void testSeDeplacerEst() {
        Place place1 = new Place(1, 1);
        Personnage perso = new Personnage("bob", place1);

        perso.seDeplacer('E');

        assertEquals("mauvaise place", new Place(2, 1), place1);
    }

    /**
     * Ce test vérifie si le personnage peut se deplacer vers l'ouest
     */
    @Test
    public void testSeDeplacerOuest() {
        Place place1 = new Place(1, 1);
        Personnage perso = new Personnage("bob", place1);

        perso.seDeplacer('O');

        assertEquals("mauvaise place", new Place(0, 1), place1);
    }

    /**
     * Ce test vérifie que le personnage ne bouge pas si le charactere n'est pas valide
     */
    @Test
    public void testSeDeplacerMauvaisChar() {
        Place place1 = new Place(1, 1);
        Personnage perso = new Personnage("bob", place1);

        perso.seDeplacer('R');

        assertEquals("mauvaise place", new Place(1, 1), place1);
    }

}
