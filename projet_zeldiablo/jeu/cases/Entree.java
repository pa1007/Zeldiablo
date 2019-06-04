package jeu.cases;

import utils.Place;

import java.awt.*;

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

    @Override
    public char getLetter() {
        return 'E';
    }

    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        g.setColor(Color.BLUE);
        g.fillRect(TAILLE_CASE * place.getX()+1, TAILLE_CASE * place.getY()+1, TAILLE_CASE, TAILLE_CASE);
    }
}
