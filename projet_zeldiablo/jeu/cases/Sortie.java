package jeu.cases;

import utils.Place;

import java.awt.*;

public class Sortie extends Case {
    public Sortie(Place place) {
        super(place);
        this.type = CaseType.SORTIE;
    }

    @Override
    public char getLetter() {
        return 'S';
    }

    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        g.setColor(Color.GREEN);
        g.fillRect(TAILLE_CASE * place.getX()+1, TAILLE_CASE * place.getY()+1, TAILLE_CASE, TAILLE_CASE);
    }
}
