package jeu.monstre;

import jeu.Labyrinthe;
import jeu.monstre.ai.AI;
import utils.Place;

public class Gnome extends Monstre {

    private static final int POINT_DE_VIE_MONSTRE = 3;

    public Gnome(Place p, Labyrinthe l) {
        super(POINT_DE_VIE_MONSTRE, p, l);
    }

    public Gnome(Place p, Labyrinthe l, AI ai) {
        super(POINT_DE_VIE_MONSTRE, p, l, ai);
    }

}
