package test;

import jeu.Case;
import jeu.Labyrinthe;
import jeu.Personnage;
import org.junit.Test;
import utils.Place;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.TestCase.assertEquals;

/**
 * Classe de test permettant de tester
 * la classe Labyrinthe
 */
public class TestLabyrinthe {


    /**
     * Test de creation de Labyrinthee Constructeur avec un Personnage
     */
    @Test
    public void testConstructeurLabyrintheAvecPersonnage() {
        // Preparation des donnees
        Place      p     = new Place(1, 1);
        Personnage perso = new Personnage("Julien", p);

        // Methode testee
        Labyrinthe l = new Labyrinthe(perso);

        // Verification
        assertEquals(
                "Le labyrinthe devrait avoir un personnage s'appellant Julien",
                l.getAventurier().getNom(),
                "Julien"
        );
    }


    /**
     * Test de creation de Labyrinthee Constructeur et de calcul du nombre de cases crées
     */
    @Test
    public void testConstructeurLabyrintheNBCases() {
        // Preparation des donnees
        Place      p     = new Place(1, 1);
        Personnage perso = new Personnage("Julien", p);

        // Methode testee
        Labyrinthe l = new Labyrinthe(perso);

        // Verification
        assertEquals("Le labyrinthe devrait avoir 400 cases", 400, l.getCases().size());
    }


    /**
     * Test de creation de Labyrinthee Constructeur avec liste de case et de calcul du nombre de cases crées
     */
    @Test
    public void testConstructeurLabyrintheConstructeurListeCases() {
        // Preparation des donnees
        Place      p     = new Place(1, 1);
        Personnage perso = new Personnage("Julien", p);
        List<Case> cases = new ArrayList<>();
        cases.add(new Case(1, 1));

        // Methode testee
        Labyrinthe l = new Labyrinthe(cases, perso);

        // Verification
        assertEquals("Le labyrinthe devrait avoir 1 case", 1, l.getCases().size());
    }


    /**
     * Test de creation de Labyrinthee Constructeur Paramètre personnage null
     */
    @Test
    public void testConstructeurLabyrintheConstructeurPersonnageNull() {
        // Preparation des donnees

        // Methode testee
        Labyrinthe l = new Labyrinthe(null);

        // Verification
        assertEquals("Le labyrinthe devrait avoir un personnage null", null, l.getAventurier());
    }


    /**
     * Test de creation de Labyrinthee Constructeur Paramètres personnage et liste de cases null
     */
    @Test
    public void testConstructeurLabyrintheConstructeurPersonnageListeCasesNull() {
        // Preparation des donnees

        // Methode testee
        Labyrinthe l = new Labyrinthe(null, null);

        // Verification
        assertEquals("Le labyrinthe devrait avoir 400 cases", 400, l.getCases().size());
    }
}
