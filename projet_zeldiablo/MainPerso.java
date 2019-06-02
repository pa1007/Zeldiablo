import dessin.DessinPerso;
import jeu.JeuPerso;
import jeu.Personnage;
import moteur_jeu.MoteurGraphique;
import utils.Place;
import java.io.IOException;

public class MainPerso {

    public static void main(String[] args) throws InterruptedException, IOException {
        Personnage p = new Personnage("dzqd", new Place(50, 50));

        JeuPerso j = new JeuPerso(p);

        DessinPerso d = new DessinPerso(j);

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }
}
