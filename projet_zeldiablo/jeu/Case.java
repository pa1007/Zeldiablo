package jeu;

import utils.Place;

public class Case {
    /**
     * Place associée à la case
     */
    private Place pl;

    /**
     * Constructeur de Case à partir d'une Place
     * @param pl Place
     */
    public Case(Place pl) {
        this.pl = pl;
    }

    /**
     * Constructeur de Case à partir de coordonnées
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Case(int x, int y) {
        if(x >= 0 && y >= 0 && x < 20 && y < 20) {
            this.pl = new Place(x, y);
        }
    }
}
