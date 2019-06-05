package main;

import dessin.DessinPerso;
import jeu.JeuPerso;
import jeu.Labyrinthe;
import jeu.Niveau;
import jeu.Personnage;
import jeu.monstre.Gnome;
import jeu.monstre.ai.AIExperte;
import jeu.monstre.ai.AIRandom;
import jeu.monstre.ai.Algorithm;
import moteur_jeu.MoteurGraphique;
import utils.Place;
import utils.Sauvegarde;

public class MainPerso {

    public static void main(String[] args) throws InterruptedException {

        Niveau     n = new Niveau();
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger());
        Personnage p = new Personnage("dzqd", 10, new Place(19, 1), l, n);
        l.addPerso(p);
        JeuPerso j = new JeuPerso(p, n);
        n.addLaby(l);
        DessinPerso d = new DessinPerso(j);
        l.addMur(new Place(4, 4));
        l.addMonstre(new Gnome(new Place(14, 0), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(4, 5), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(0, 6), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(14, 13), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(3, 19), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(17, 19), l, new AIRandom()));
        initOthersLaby(n);

        MoteurGraphique mg = new MoteurGraphique(j, d);
        mg.lancerJeu(500, 500);
    }

    private static void initOthersLaby(Niveau n) {
        Labyrinthe l = new Labyrinthe(Sauvegarde.charger());
        l.addMonstre(new Gnome(new Place(14, 0), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(4, 5), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(0, 6), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(14, 13), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(3, 19), l, new AIRandom()));
        l.addMonstre(new Gnome(new Place(17, 19), l, new AIExperte(new Algorithm(l))));
        n.addLaby(l);

        Labyrinthe l2 = new Labyrinthe(Sauvegarde.charger());
        l2.addMonstre(new Gnome(new Place(14, 0), l, new AIExperte(new Algorithm(l))));
        l2.addMonstre(new Gnome(new Place(4, 5), l, new AIExperte(new Algorithm(l))));
        l2.addMonstre(new Gnome(new Place(0, 6), l, new AIExperte(new Algorithm(l))));
        l2.addMonstre(new Gnome(new Place(14, 13), l, new AIExperte(new Algorithm(l))));
        l2.addMonstre(new Gnome(new Place(3, 19), l, new AIExperte(new Algorithm(l))));
        l2.addMonstre(new Gnome(new Place(17, 19), l, new AIExperte(new Algorithm(l))));
        n.addLaby(l2);
    }
}
