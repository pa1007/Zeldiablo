package test;

import jeu.Labyrinthe;
import org.junit.Test;
import utils.Place;
import utils.Sauvegarde;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSauvegarde {


    @Test
    public void test_Creation_Sauvegarde_Fichier() throws IOException {
        Labyrinthe l = new Labyrinthe();
        Sauvegarde s = new Sauvegarde(l);

        s.save(l.getCases());

        File f = new File("SaveLaby.txt");

        assertTrue("La file devais exister", f.exists());
    }

    @Test
    public void test_Creation_Sauvegarde_Contenu() throws IOException {
        Labyrinthe l = new Labyrinthe();
        Sauvegarde s = new Sauvegarde(l);
        l.addMur(new Place(4, 4));
        s.save(l.getCases());

        File           f     = new File("SaveLaby.txt");
        BufferedReader br    = new BufferedReader(new FileReader(f));
        List<String>   lines = br.lines().collect(Collectors.toList());

        File           f2     = new File("./projet_zeldiablo/test/testTemoins.txt");
        BufferedReader br2    = new BufferedReader(new FileReader(f2));
        List<String>   lines2 = br2.lines().collect(Collectors.toList());


        assertEquals("La file devais exister", lines2, lines);
    }

}
