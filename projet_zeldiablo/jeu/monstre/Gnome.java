package jeu.monstre;

import jeu.Entite;
import jeu.Labyrinthe;
import utils.Place;

public class Gnome extends Monstre {

    private static final int POINT_DE_VIE_MONSTRE = 3;

    public Gnome(Place p, Labyrinthe l) {
        super(POINT_DE_VIE_MONSTRE, p, l);
    }

    public Gnome(Place place, Labyrinthe l, Type monstreAi) {
        super(POINT_DE_VIE_MONSTRE, place, l,monstreAi);
    }
}
