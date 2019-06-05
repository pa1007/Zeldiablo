package utils;

import java.util.ArrayList;
import java.util.List;

public class Place implements Comparable {

    /**
     * La coordonnée en X
     */
    private int x;

    /**
     * La coordonnée en Y
     */
    private int y;

    /**
     * Permet de crée une place, <strong>ne verifie pas si la place est valide </strong>
     *
     * @param x La coordonnée en X
     * @param y La coordonnée en Y
     */
    public Place(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     *
     * @param p la place a copier
     */
    public Place(Place p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * This methode compare this place to an object in parameters
     *
     * @param o un object, caster durant la methode est lance une ClassCastException si il n'est pas du bon type
     * @return <ul>
     * <li>0 : si egual </li>
     * <li>1 : si le Y du parametre est superieur a celui la  </li>
     * <li>2 : si le Y de this  est superieur a celui du parametre  </li>
     * <li>-1 : si le X du parametre est superieur a celui la  </li>
     * <li>-2 : si le X de this  est superieur a celui du parametre  </li>
     * </ul>
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        Place p = (Place) o;
        int   res;
        if (p.equals(this)) {
            res = 0;
        }
        else if (p.getY() != getY()) {
            res = p.getY() > getY() ? 1 : 2;
        }
        else {
            res = p.getX() > getX() ? -1 : -2;
        }
        return res;
    }

    /**
     * Getter de X
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Set de x
     *
     * @param x La coordonnée en x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter de Y
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Set de y
     *
     * @param y La coordonnée en Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Pour incrementer Y en fonction des paramêtre
     *
     * @param dx le nombre a ajouter
     */
    public void incrementerX(int dx) {
        this.x = x + dx < 0 ? 0 : x + dx;
    }

    /**
     * Pour incrementer X en fonction des paramêtre
     *
     * @param dy le nombre a ajouter
     */
    public void incrementerY(int dy) {
        this.y = y + dy < 0 ? 0 : y + dy;
    }

    public List<Place> getNext() {
        List<Place> pl = new ArrayList<>();
        pl.add(new Place(x + 1, y));
        pl.add(new Place(x - 1, y));
        pl.add(new Place(x, y + 1));
        pl.add(new Place(x, y - 1));
        return pl;
    }

    /**
     * equals
     *
     * @param o l'object a tester
     * @return si les deux sont egaux
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Place)) {
            return false;
        }

        Place place = (Place) o;

        if (x != place.x) {
            return false;
        }
        return y == place.y;
    }


    /**
     * To string
     *
     * @return le string
     */
    @Override
    public String toString() {
        return x + "," + y;
    }
}
