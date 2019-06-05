package jeu.cases;

import jeu.Personnage;
import utils.Place;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Piege extends Case {

    /**
     * Dégats du piege
     */
    private final static int DEGATS_PIEGE = 2;

    /**
     * Booleen est-ce que le piege est visible?
     */
    private boolean visible;

    /**
     * Constructeur de la case Piege
     *
     * @param place place
     */
    public Piege(Place place) {
        super(place);
        this.type = CaseType.PIEGE;
    }

    /**
     * Méthode retournant la lettre associé
     * au Type de case
     *
     * @return
     */
    @Override
    public char getLetter() {
        return 'P';
    }

    /**
     * Méthode permettant d'afficher graphiquement
     * le piège en fonction de sa visiblité
     *
     * @param g Graphics
     */
    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        if (visible) {
            g.setColor(new Color(139, 69, 19));
            g.setFont(new Font("Arial", Font.PLAIN, 33));
            g.drawString("X", TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY() + TAILLE_CASE);
        }
    }

    /**
     * Méthode permettant d'infliger des dégats
     * à un personnage
     *
     * @param p personnage
     */
    public void infligerDegats(Personnage p) {
        p.subirDegats(DEGATS_PIEGE);
        if (!this.visible) {
            this.visible = true;
        }
    }

}
