import dessin.DessinPerso;
import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Personnage;
import moteur_jeu.MoteurGraphique;
import utils.Place;
import java.io.IOException;

public class MainPerso {

    public static void main(String[] args) throws InterruptedException, IOException {
        Personnage p = new Personnage("dzqd", new Place(50, 50));
        Labyrinthe l = new Labyrinthe(p);
        JeuPerso j = new JeuPerso(p, l);

        DessinPerso d = new DessinPerso(j);

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }
}
