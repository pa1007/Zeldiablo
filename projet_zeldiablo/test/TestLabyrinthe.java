package test;

import jeu.Case;
import jeu.Labyrinthe;
import jeu.Personnage;
import org.junit.Test;
import utils.Place;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

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
        Place p = new Place(1, 1);
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
        Place p = new Place(1, 1);
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
        Place p = new Place(1, 1);
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

    /**
     * Test recherche de case
     */
    @Test
    public void testRechercheDeCaseDansLabyrinthe() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testée
        Case c = l.rechercherCase(new Place(0, 2));
        Case res = l.getCases().get(2);

        // Verification
        assertEquals("Les cases devraient etre les memes", c, res);
    }

    /**
     * Test recherche de case alors que
     * la case n'existe pas vraiment
     */
    @Test
    public void testRechercheDeCaseDansLabyrintheAlorsQueLaCaseNexistePasVraiment() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testée
        Case c = l.rechercherCase(new Place(555, 555));

        // Verification
        assertNull("Devrait retourner null", c);
    }

    /**
     * Test d'ajout d'un mur
     */
    @Test
    public void testAjoutMur() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.addMur(new Place(0, 2));

        // Verification
        assertTrue("La case devrait etre un mur", l.getCases().get(2).isMur());
    }

    /**
     * Test d'ajout d'un mur
     */
    @Test
    public void testAjoutMurSurCaseNull() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.addMur(new Place(555, 555));

        // Verification
        // (La méthode ne renvoie rien, mais ne devrait aussi pas renvoyer d'Exceptions)
    }

    /**
     * Test de suppression d'un mur
     */
    @Test
    public void testSuppresionMur() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);
        l.getCases().get(2).setMur(true);

        // Methode testee
        l.removeMur(new Place(0, 2));

        // Verification
        assertFalse("La case ne devrait pas etre un mur", l.getCases().get(2).isMur());
    }

    /**
     * Test de suppression d'un mur sur
     * une case null
     */
    @Test
    public void testSuppressionMurSurCaseNull() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.removeMur(new Place(555, 555));

        // Verification
        // (La méthode ne renvoie rien, mais ne devrait aussi pas renvoyer d'Exceptions)
    }

    /**
     * Test occuper case
     */
    @Test
    public void testOccuperCase() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.occuperCase(new Place(0, 2), true);

        // Verification
        assertTrue("La case devrait etre occupée", l.getCases().get(2).isOccupe());
    }

    /**
     * Test occuper case null
     */
    @Test
    public void testOccuperCaseNull() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.occuperCase(new Place(0, 2), true);

        // Verification
        // Ne devrait pas renvoyer d'exceptions
    }

    /**
     * Test de désoccuper case
     */
    @Test
    public void testDesoccuperSurCase() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.occuperCase(new Place(0, 2), false);

        // Verification
        assertFalse("La case ne devrait pas etre occupée", l.getCases().get(2).isOccupe());
    }

    /**
     * Test de désoccuper case null
     */
    @Test
    public void testDesoccuperSurCaseNull() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(1, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        l.occuperCase(new Place(5555, 555), false);

        // Verification
        // Ne renvoie pas d'exceptions
    }

    /**
     * Test création labyrinthe, avec un personnage
     * si la case ou se situe le personnage devient occupee
     */
    @Test
    public void testCaseOccupeParPers() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(0, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee

        // Verification
        assertTrue("La case devrait etre occupée", l.getCases().get(1).isOccupe());
    }

    /**
     * Test si la case est occupe
     */
    @Test
    public void testEtreOccupe() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(0, 1));
        Labyrinthe l = new Labyrinthe(p);
        l.getCases().get(0).setOccupe(true);

        // Methode testee
        boolean res1 = l.etreOccupe(new Place(0, 0));
        boolean res2 = l.etreOccupe(new Place(2, 0));
        // Verification
        assertTrue("La case devrait etre occupée", res1);
        assertFalse("La case ne devrait pas etre occupée", res2);
    }

    /**
     * Test si la case est occupe case nulle
     */
    @Test
    public void testEtreOccupeCaseNull() {
        // Preparation des donnees
        Personnage p = new Personnage("AyyLmao", new Place(0, 1));
        Labyrinthe l = new Labyrinthe(p);

        // Methode testee
        boolean res = l.etreOccupe(new Place(545, 54));
        // Verification
        assertFalse("La case ne devrait pas etre occupe", res);
    }
}
