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

    @Test
    /**
     * Test création de Case Constructeur avec
     * une Place
     */
    public void testConstructeurCaseAvecPlace() {
        // Preparation des donnees
        Place pl = new Place(7, 8);

        // Methode testee
        Case c = new Case(pl);

        // Verification
        assertEquals("La case devrait avoir la bonne place passée en paramètre", c.getPl(), pl);
    }

    @Test
    /**
     * Test création de Case Constructeur avec
     * des coordonées
     */
    public void testConstructeurCaseAvecCoord() {
        // Preparation des donnees
        int x = 7;
        int y = 12;

        // Methode testee
        Case c = new Case(x, y);

        // Verification
        Place pl = c.getPl();
        assertEquals("La case devrait avoir une place ayant les bonnes coordonnées", pl.getX(), 7);
        assertEquals("La case devrait avoir une place ayant les bonnes coordonnées", pl.getY(), 12);
    }

    @Test(expected = CaseException.class)
    /**
     * Test création de Case Constructeur avec
     * des coordonées pas bonnes
     */
    public void testConstructeurCaseAvecCoordPasBonnes() {
        // Preparation des donnees
        int x = -8;
        int y = 22;

        // Methode testee
        Case c = new Case(x, y);

        // Verification
    }

    @Test(expected = CaseException.class)
    /**
     * Test création de Case Constructeur avec
     * une Place avec mauvaises coordonnées
     */
    public void testConstructeurCaseAvecPlacePasBonne() {
        // Preparation des donnees
        Place pl = new Place(-1, 22);

        // Methode testee
        Case c = new Case(pl);

        // Verification
    }

    @Test(expected = CaseException.class)
    /**
     * Test création de Case Constructeur avec
     * une Place null
     */
    public void testConstructeurCaseAvecPlaceNull() {
        // Preparation des donnees
        Place pl = null;

        // Methode testee
        Case c = new Case(pl);

        // Verification
    }
}
