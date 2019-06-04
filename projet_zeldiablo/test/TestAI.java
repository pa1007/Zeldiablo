package test;

import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.ai.Algorithm;
import org.junit.Test;
import utils.Place;
import java.util.List;
import static org.junit.Assert.*;

public class TestAI {


    /**
     * Test pour un algo avec aucun chemin
     */
    @Test
    public void test_Algorithm_AucunChemin() {
        Labyrinthe l  = new Labyrinthe();
        Algorithm  al = new Algorithm(l);

        boolean res = al.leeAlgorithm(new Place(-1, -1), new Place(1, 1));

        assertFalse("L'ago ne devais pas pouvoir se faire", res);
    }

    /**
     * Nous allons regarder pour une entrée toute simple
     */
    @Test
    public void test_Algorithm_RechercheSimple() {
        Labyrinthe l      = new Labyrinthe();
        Place      persoP = new Place(4, 4);
        l.addPerso(new Personnage("louppe", 1, persoP, l));
        Algorithm al = new Algorithm(l);
        al.getStartIndex(persoP);

        boolean     res  = al.leeAlgorithm(new Place(3, 3), persoP);
        List<Place> back = al.backTracking();

        assertTrue("L'ago  devais  pouvoir se faire", res);
        assertEquals("Il devais avoir 1 places traiter, car on ne veux pas la dernière position", 1, back.size());
        assertEquals("La place deteminer devrais etre 3,4", new Place(3, 4), back.get(0));
    }

    /**
     * On ajout un mur pour voir ce qu'il se passe
     */
    @Test
    public void test_Algorithm_RechercheAvecMur() {
        Labyrinthe l      = new Labyrinthe();
        Place      persoP = new Place(5, 5);
        l.addPerso(new Personnage("louppe", 1, persoP, l));
        l.addMur(new Place(4, 3));
        l.addMur(new Place(3, 4));
        Algorithm al = new Algorithm(l);
        al.getStartIndex(persoP);

        boolean     res  = al.leeAlgorithm(new Place(3, 3), persoP);
        List<Place> back = al.backTracking();

        assertTrue("L'ago  devais  pouvoir se faire", res);
        assertEquals("Il devais avoir 1 places traiter, car on ne veux pas la dernière position", 5, back.size());
        assertEquals("La place deteminer devrais etre 3,4", new Place(2, 3), back.get(back.size() - 1));
    }
}
