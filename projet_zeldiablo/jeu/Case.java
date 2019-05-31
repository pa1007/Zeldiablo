package jeu;

import exceptions.CaseException;
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
        if(pl.getX() >= 0 && pl.getY() >= 0 && pl.getX() < 20 && pl.getY() < 20) {
            this.pl = pl;
        } else {
            throw new CaseException("0 <= (X,Y) < 20");
        }
    }

    /**
     * Constructeur de Case à partir de coordonnées
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Case(int x, int y) {
        if(x >= 0 && y >= 0 && x < 20 && y < 20) {
            this.pl = new Place(x, y);
        } else {
            throw new CaseException("0 <= (X,Y) < 20");
        }
    }

    /**
     * Getter de la place
     * @return place
     */
    public Place getPl() {
        return pl;
    }
}
