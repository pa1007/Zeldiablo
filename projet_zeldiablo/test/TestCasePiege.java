package test;

import jeu.Case;
import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.Piege;
import jeu.monstre.Gnome;
import jeu.monstre.Monstre;
import org.junit.Test;
import utils.Place;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestCasePiege {

    @Test
    public void testCaseFonctionnelle() {
        Case c1 = new Case(new Place(0, 0));
        Piege c2 = new Piege(new Place(1, 0));
        ArrayList<Case> lCases = new ArrayList<>();
        lCases.add(c1);
        lCases.add(c2);
        Labyrinthe laby = new Labyrinthe(lCases);
        Place positionperso = new Place(0, 0);
        Personnage personnage = new Personnage("PaulAlexandre", 10, positionperso, laby);
        personnage.seDeplacer('E');


        int res = personnage.getPv();

        assertEquals("Le piege n'a pas fonctionné", 8, res);
    }

    @Test
    public void testCaseSpawnSurLePiege() {
        Piege c2 = new Piege(new Place(0, 0));
        ArrayList<Case> lCases = new ArrayList<>();
        lCases.add(c2);
        Labyrinthe laby = new Labyrinthe(lCases);
        Place positionperso = new Place(0, 0);
        Personnage personnage = new Personnage("PaulAlexandre", 10, positionperso, laby);


        int res = personnage.getPv();

        assertEquals("Le piege n'a pas fonctionné", 10, res);
    }


    @Test
    public void testCaseMonstre() {
        Case c1 = new Case(new Place(0, 0));
        Piege c2 = new Piege(new Place(1, 0));
        ArrayList<Case> lCases = new ArrayList<>();
        lCases.add(c1);
        lCases.add(c2);
        Labyrinthe laby = new Labyrinthe(lCases);
        Place positionmonstre = new Place(0, 0);
        Gnome gnome = new Gnome(positionmonstre, laby);
        gnome.seDeplacer('E');


        int res = gnome.getPv();

        assertEquals("Le monstre ne devrait pas perdre des pv", 3, res);
    }


}
