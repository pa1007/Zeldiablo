package jeu.cases;

import exceptions.CaseException;
import utils.Place;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

public class Case {

    /**
     * Taille de la case (utilisé pour graphics)
     */
    protected static final int TAILLE_CASE = 25;

    /**
     * Place associée à la case
     */
    protected Place place;

    /**
     * Booleen pour savoir si une case est un mur ou non
     */
    protected boolean mur;

    /**
     * Booleen pour savoir si une case est occupee par un personnage ou non
     */
    protected boolean occupe;

    /**
     * Type de la case (enum)
     */
    protected CaseType type;

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
        this.type = CaseType.NORMAL;
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

    /**
     * Permet de savoir si une case et vide ou
     * n'est pas un mur
     *
     * @return booleen
     */
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

    /**
     * Méthode permettant d'afficher graphiquement
     * la case
     *
     * @param g Graphics
     */
    public void afficher(Graphics g) {
        if (isMur()) {
            g.setColor(Color.GRAY);
            g.fillRect(TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY(), TAILLE_CASE, TAILLE_CASE);
        }


    }

    /**
     * Récupère le type de la case
     *
     * @return CaseType
     */
    public CaseType getType() {
        return type;
    }

    /**
     * Convertit le type de la case en lettre
     *
     * @return lettre associé à la case
     */
    public char getLetter() {
        char res = ' ';
        if (isMur()) {
            res = 'M';
        } else if (isOccupe()) {
            res = 'O';
        } else if (isVide()) {
            res = 'V';
        }
        return res;
    }

    /**
     * Méthode equals permettant de comparer les cases
     *
     * @param o objet
     * @return booleen
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Case)) {
            return false;
        }

        Case aCase = (Case) o;

        if (mur != aCase.mur) {
            return false;
        }
        return Objects.equals(place, aCase.place);

    }

    /**
     * hashCode
     *
     * @return
     */
    @Override
    public int hashCode() {
        int result = place != null ? place.hashCode() : 0;
        result = 31 * result + (mur ? 1 : 0);
        return result;
    }

    /**
     * To String de la classe Case
     *
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Case{");
        sb.append("place=").append(place);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Enum de types
     */
    public enum CaseType {
        NORMAL,
        ENTREE,
        SORTIE,
        PIEGE
    }
}
