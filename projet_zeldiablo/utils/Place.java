package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Place {

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

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Place)) {
            return false;
        }
        Place place = (Place) o;
        return x == place.x &&
               y == place.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
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
