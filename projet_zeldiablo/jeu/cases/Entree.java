package jeu.cases;

import utils.Place;

public class Entree extends Case {
    /**
     * Constructeur de Case à partir d'une Place
     *
     * @param place Place
     */
    public Entree(Place place) {
        super(place);
        this.type = CaseType.ENTREE;
    }

    /**
     * Constructeur de Case à partir de coordonnées
     *
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Entree(int x, int y) {
        super(x, y);
        this.type = CaseType.ENTREE;
    }

    @Override
    public char getLetter() {
        return 'E';
    }
}
