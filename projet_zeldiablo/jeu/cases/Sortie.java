package jeu.cases;

import utils.Place;

public class Sortie extends Case {
    public Sortie(Place place) {
        super(place);
        this.type = CaseType.SORTIE;
    }

    @Override
    public char getLetter() {
        return 'S';
    }
}
