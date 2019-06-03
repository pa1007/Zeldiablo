import dessin.DessinPerso;
import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.Gnome;
import moteur_jeu.MoteurGraphique;
import utils.Place;
import java.io.IOException;

public class MainPerso {

    public static void main(String[] args) throws InterruptedException, IOException {
        Personnage  p = new Personnage("dzqd", new Place(15, 15));
        Labyrinthe  l = new Labyrinthe(p);
        p.setLabyrinthe(l);
        JeuPerso    j = new JeuPerso(p, l);
        DessinPerso d = new DessinPerso(j);
        l.addMur(new Place(4, 4));
        l.addMosntre(new Gnome(new Place(5,5)));

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }
}
