package jeu;

import exceptions.CaseException;
import utils.Place;

public class Case {
    /**
     * Place associée à la case
     */
    private Place place;

    /**
     * Constructeur de Case à partir d'une Place
     * @param place Place
     */
    public Case(Place place) {
        if(place != null && place.getX() >= 0 && place.getY() >= 0 && place.getX() < 20 && place.getY() < 20) {
            this.place = place;
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
            this.place = new Place(x, y);
        } else {
            throw new CaseException("0 <= (X,Y) < 20");
        }
    }

    /**
     * Getter de la place
     * @return place
     */
    public Place getPlace() {
        return place;
    }
}
