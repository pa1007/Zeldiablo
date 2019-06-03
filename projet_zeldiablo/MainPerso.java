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
        Labyrinthe l = new Labyrinthe();
        Personnage p = new Personnage("dzqd", new Place(15, 15), l);
        l.addPerso(p);
        JeuPerso    j = new JeuPerso(p, l);
        DessinPerso d = new DessinPerso(j);
        l.addMur(new Place(4, 4));
        l.addMonstre(new Gnome(new Place(5, 5), l));

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }
}
