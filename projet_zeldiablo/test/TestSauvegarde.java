package test;

import jeu.Labyrinthe;
import jeu.cases.Case;
import org.junit.Test;
import utils.Sauvegarde;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

public class TestSauvegarde {


    /**
     * permet de tester que le fichier sois bien la lors de la creation
     *
     * @throws IOException Si il y a une erreur
     */
    @Test
    public void testCreationSauvegardeFichier() throws IOException {
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger("./projet_zeldiablo/test/testTemoins.txt"));

        Sauvegarde.save(l);
        File f = new File("SaveLaby.txt");

        assertTrue("La file devais exister", f.exists());
    }

    /**
     * permet de tester que le contenu du fichier sois bien fidel a la grie
     *
     * @throws IOException Si il y a une erreur
     */
    @Test
    public void testCreationSauvegardeContenu() throws IOException {
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger("./projet_zeldiablo/test/testTemoins.txt"));
        Sauvegarde.save(l);

        File           f     = new File("SaveLaby.txt");
        BufferedReader br    = new BufferedReader(new FileReader(f));
        List<String>   lines = br.lines().collect(Collectors.toList());

        File           f2     = new File("./projet_zeldiablo/test/testTemoins.txt");
        BufferedReader br2    = new BufferedReader(new FileReader(f2));
        List<String>   lines2 = br2.lines().collect(Collectors.toList());


        assertEquals("Le contenu n'est pas bon", lines2, lines);
    }

    /**
     * permet de tester que le fichier sois bien la lors de la creation
     */
    @Test
    public void testChargeSauvegardeFichierInexistant() {
        File f = new File("SaveLabyTEST.txt");
        if (f.exists()) {
            f.delete();
        }
        //on supprime les autres sauvegardes qui peuvent venir interfere

        List<Case> cases = Sauvegarde.charger("SaveLabyTEST.txt");


        assertTrue("La file n'existe plus, donc on doit avoir une liste vide", cases.isEmpty());
    }

    /**
     * permet de tester que le fichier sois bien la lors de la creation
     *
     * @throws IOException Si il y a une erreur
     */
    @Test
    public void testChargeSauvegardeFichier() throws IOException {
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger("./projet_zeldiablo/test/testTemoins.txt"));
        Sauvegarde.save(l);


        List<Case> cases = Sauvegarde.charger();


        assertArrayEquals("La file devais exister", l.getCases().toArray(), cases.toArray());
    }
}
