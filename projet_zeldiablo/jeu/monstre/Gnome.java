package jeu.monstre;

import jeu.Labyrinthe;
import jeu.monstre.ai.AI;
import utils.Place;

public class Gnome extends Monstre {

    /**
     * Points de vie du Gnome
     */
    private static final int POINT_DE_VIE_MONSTRE = 6;

    /**
     * Constructeur du monstre
     *
     * @param p place
     * @param l labyrinthe
     */
    public Gnome(Place p, Labyrinthe l) {
        super(POINT_DE_VIE_MONSTRE, p, l);
    }

    /**
     * Constructeur du monstre
     *
     * @param p  place
     * @param l  labyrinthe
     * @param ai intelligence
     */
    public Gnome(Place p, Labyrinthe l, AI ai) {
        super(POINT_DE_VIE_MONSTRE, p, l, ai);
    }

}
