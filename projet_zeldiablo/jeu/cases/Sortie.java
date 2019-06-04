package jeu.cases;

import utils.Place;

import java.awt.*;

public class Sortie extends Case {

    /**
     * Constructeur de la case Sortie
     *
     * @param place place
     */
    public Sortie(Place place) {
        super(place);
        this.type = CaseType.SORTIE;
    }

    /**
     * Méthode retournant la lettre
     * associé à la case
     *
     * @return S
     */
    @Override
    public char getLetter() {
        return 'S';
    }

    /**
     * Méthode permettant d'afficher graphiquement
     * la case de sortie
     *
     * @param g Graphics
     */
    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        g.setColor(Color.GREEN);
        g.fillRect(TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY() , TAILLE_CASE, TAILLE_CASE);
    }
}
