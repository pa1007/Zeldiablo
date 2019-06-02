package test;

import exceptions.CaseException;
import jeu.Case;
import org.junit.Test;
import utils.Place;
import static org.junit.Assert.assertEquals;

/**
 * Classe de test permettant de tester
 * la classe Case
 */
public class TestCase {


    /**
     * Test création de Case Constructeur avec
     * une Place
     */
    @Test
    public void testConstructeurCaseAvecPlace() {
        // Preparation des donnees
        Place pl = new Place(7, 8);

        // Methode testee
        Case c = new Case(pl);

        // Verification
        assertEquals("La case devrait avoir la bonne place passée en paramètre", c.getPlace(), pl);
    }


    /**
     * Test création de Case Constructeur avec
     * des coordonées
     */
    @Test
    public void testConstructeurCaseAvecCoord() {
        // Preparation des donnees
        int x = 7;
        int y = 12;

        // Methode testee
        Case c = new Case(x, y);

        // Verification
        Place pl = c.getPlace();
        assertEquals("La case devrait avoir une place ayant les bonnes coordonnées", pl.getX(), 7);
        assertEquals("La case devrait avoir une place ayant les bonnes coordonnées", pl.getY(), 12);
    }


    /**
     * Test création de Case Constructeur avec
     * des coordonées pas bonnes
     */
    @Test(expected = CaseException.class)
    public void testConstructeurCaseAvecCoordPasBonnes() {
        // Preparation des donnees
        int x = -8;
        int y = 22;

        // Methode testee
        Case c = new Case(x, y);

        // Verification
    }


    /**
     * Test création de Case Constructeur avec
     * une Place avec mauvaises coordonnées
     */
    @Test(expected = CaseException.class)
    public void testConstructeurCaseAvecPlacePasBonne() {
        // Preparation des donnees
        Place pl = new Place(-1, 22);

        // Methode testee
        Case c = new Case(pl);

        // Verification
    }


    /**
     * Test création de Case Constructeur avec
     * une Place null
     */
    @Test(expected = CaseException.class)
    public void testConstructeurCaseAvecPlaceNull() {
        // Preparation des donnees
        Place pl = null;

        // Methode testee
        Case c = new Case(pl);

        // Verification
    }
}
