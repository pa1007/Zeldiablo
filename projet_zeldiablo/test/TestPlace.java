package test;

import org.junit.Test;
import utils.Place;
import static org.junit.Assert.assertEquals;

public class TestPlace {

    /**
     * Test le constructeur
     */
    @Test
    public void test_Constructeur_Place() {
        Place p = new Place(1, 2);
        int   i = 1;
        int   z = 2;


        assertEquals("Pas le bon x", i, p.getX());
        assertEquals("Pas la bon Y", z, p.getY());
    }

    /**
     * Test l'incrementation du X
     */
    @Test
    public void test_Incrementer_X_Fonctionnel() {
        Place p = new Place(1, 1);

        p.incrementerX(1);

        assertEquals("Pas la bonne place", new Place(2, 1), p);
    }

    /**
     * Test l'incrementation du Y
     */
    @Test
    public void test_Incrementer_Y_Fonctionnel() {
        Place p = new Place(1, 1);

        p.incrementerY(1);

        assertEquals("Pas le bon x", new Place(1, 2), p);
    }

    /**
     * Test le fais de faire reculer la place
     */
    @Test
    public void test_Incrementer_Negatif() {
        Place p = new Place(2, 2);

        p.incrementerX(-1);
        p.incrementerY(-1);

        assertEquals("Pas la bonne place", new Place(1, 1), p);
    }


    /**
     * Test non fonctionnel, qui regarde la taille
     */
    @Test
    public void test_Incrementer_NombreNegatif() {
        Place p = new Place(1, 1);

        p.incrementerX(-40);
        p.incrementerY(-40);

        assertEquals("Pas la bonne place", new Place(0, 0), p);
    }
}
