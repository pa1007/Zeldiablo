package jeu;

import utils.Place;

public abstract class Entite {

    private int pv;

    private Place position;

    private Labyrinthe labyrinthe;


    public Entite(int pointdevie, Place place, Labyrinthe l) {
        this.pv = pointdevie;
        this.position = place;
        this.labyrinthe = l;
    }

    public abstract void attaquer(Entite t);

    public void subirDegats(int degats) {
        if (this.pv >= degats) {
            this.pv -= degats;
        }else {
            this.pv = 0;
        }
    }
}
