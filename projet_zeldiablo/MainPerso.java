import dessin.DessinPerso;
import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Personnage;
import jeu.monstre.Gnome;
import jeu.monstre.ai.AIExperte;
import jeu.monstre.ai.Algorithm;
import moteur_jeu.MoteurGraphique;
import utils.Place;
import utils.Sauvegarde;

public class MainPerso {

    public static void main(String[] args) throws InterruptedException {
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger());
        Personnage p = new Personnage("dzqd", 10, new Place(19, 1), l);
        l.addPerso(p);
        JeuPerso    j = new JeuPerso(p, l);
        DessinPerso d = new DessinPerso(j);
        l.addMur(new Place(4, 4));
        l.addMonstre(new Gnome(new Place(5, 5), l,new AIExperte(new Algorithm(l))));

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }
}
