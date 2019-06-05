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

    /**
     * Méthode permettant de retourner la lettre
     * associé au type de case
     *²²²²²²²²
     * @return E
     */
    @Override
    public char getLetter() {
        return 'E';
    }

    /**
     * Méthode permettant d'afficher graphiquement
     * la case entrée
     *
     * @param g Graphics
     */
    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        g.setColor(Color.BLUE);
        g.fillRect(TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY(), TAILLE_CASE, TAILLE_CASE);
    }
}
