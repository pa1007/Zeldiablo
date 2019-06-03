package jeu;

import exceptions.CaseException;
import utils.Place;

import java.awt.Color;
import java.awt.Graphics;

public class Case {

    private static final int TAILLE_CASE = 25;

    /**
     * Place associée à la case
     */
    private Place place;

    /**
     * Booleen pour savoir si une case est un mur ou non
     */
    private boolean mur;

    /**
     * Booleen pour savoir si une case est occupee par un personnage ou non
     */
    private boolean occupe;

    /**
     * Constructeur de Case à partir d'une Place
     *
     * @param place Place
     */
    public Case(Place place) {
        if (place != null && place.getX() >= 0 && place.getY() >= 0 && place.getX() < 20 && place.getY() < 20) {
            this.place = place;
        } else {
            throw new CaseException("0 <= (X,Y) < 20");
        }
    }

    /**
     * Constructeur de Case à partir de coordonnées
     *
     * @param x Abscisse
     * @param y Ordonnée
     */
    public Case(int x, int y) {
        if (x >= 0 && y >= 0 && x < 20 && y < 20) {
            this.place = new Place(x, y);
        } else {
            throw new CaseException("0 <= (X,Y) < 20");
        }
    }

    /**
     * Getter de la place
     *
     * @return place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Getter pour savoir si la case est un mur
     *
     * @return booleen
     */
    public boolean isMur() {
        return mur;
    }

    /**
     * Setter pour indiquer si une case est un mur ou non
     *
     * @param mur booleen
     */
    public void setMur(boolean mur) {
        if (!this.isOccupe()) {
            this.mur = mur;
        }
    }

    public boolean isVide() {
        return !this.isOccupe() && !this.isMur();
    }

    /**
     * Getter pour savoir si la case est occupee
     *
     * @return booleen
     */
    public boolean isOccupe() {
        return occupe;
    }

    /**
     * Setter pour indiquer si une case est occupee par un personnage ou non
     *
     * @param occupe booleen
     */
    public void setOccupe(boolean occupe) {
        if (!this.isMur()) {
            this.occupe = occupe;
        }
    }

    public void afficher(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY(), TAILLE_CASE, TAILLE_CASE);
        if (isMur()) {
            g.setColor(Color.GRAY);
            g.fillRect(TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY(), TAILLE_CASE, TAILLE_CASE);
        }


    }
}
