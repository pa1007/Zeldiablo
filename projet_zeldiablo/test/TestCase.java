package test;

import exceptions.CaseException;
import jeu.Case;
import org.junit.Test;
import utils.Place;
import static org.junit.Assert.*;

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

    /**
     * Test de mettre la case occupée
     */
    @Test
    public void testSetOuccpeCase() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setOccupe(true);

        // Verification
        assertTrue("La case devrait etre occupee", c.isOccupe());
    }

    /**
     * Test de mettre la case occupée alors
     * qu'il y a un mur
     */
    @Test
    public void testSetOuccpeCaseMur() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setMur(true);
        c.setOccupe(true);

        // Verification
        assertTrue("La case devrait etre un mur", c.isMur());
        assertFalse("La case devrait ne pas etre occupee", c.isOccupe());
    }

    /**
     * Test de mettre la case non occupee
     */
    @Test
    public void testSetPasOccupeCase() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setOccupe(true);
        c.setOccupe(false);

        // Verification
        assertFalse("La case devrait ne pas etre occupee", c.isOccupe());
    }

    /**
     * Test de mettre sur la case un mur
     */
    @Test
    public void testSetMurCase() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setMur(true);

        // Verification
        assertTrue("La case devrait etre un mur", c.isMur());
    }

    /**
     * Test de mettre sur la case un mur
     * alors qu'elle est occupee
     */
    @Test
    public void testSetMurCaseOccupe() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setOccupe(true);
        c.setMur(true);

        // Verification
        assertFalse("La case devrait ne pas etre un mur", c.isMur());
        assertTrue("La case devrait rester occupee", c.isOccupe());
    }

    /**
     * Test d'enlever un mur
     */
    @Test
    public void testSetMurFalseCase() {
        // Preparation des donnees
        Case c = new Case(1, 1);

        // Methode testee
        c.setMur(true);
        c.setMur(false);

        // Verification
        assertFalse("La case ne devrait etre un mur", c.isMur());
    }

    /**
     * Tester si la case rend bien une letre de mur
     */
    @Test
    public void test_getLetter_Mur() {
        Case c = new Case(1, 1);
        c.setMur(true);


        char l = c.getLetter();


        assertEquals("La lettre n'est pas bonne", 'M', l);
    }

    /**
     * Tester si la case rend bien une letre vide
     */
    @Test
    public void test_getLetter_Vide() {
        Case c = new Case(1, 1);

        char l = c.getLetter();


        assertEquals("La lettre n'est pas bonne", 'V', l);
    }

    /**
     * Tester si la case rend bien une letre occupe
     */
    @Test
    public void test_getLetter_Occupe() {
        Case c = new Case(1, 1);
        c.setMur(true);


        char l = c.getLetter();


        assertEquals("La lettre n'est pas bonne", 'M', l);
    }

    /**
     * Tester si la case rend bien une letre de piege
     */
    @Test
    public void test_getLetter_Piege() {
        Case c = new Case(new Place(1, 1));

        char l = c.getLetter();


        assertEquals("La lettre n'est pas bonne", Case.CaseType.PIEGE, c.getType());
        assertEquals("La lettre n'est pas bonne", 'p', l);
    }
}
