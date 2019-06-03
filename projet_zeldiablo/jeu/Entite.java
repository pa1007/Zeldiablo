package jeu;

import utils.Place;

public class Entite {

    private int pv;

    private Place position;

    private Labyrinthe labyrinthe;


    public Entite(int pointdevie, Place place, Labyrinthe l){
        this.pv = pointdevie;
        this.position = place;
        this.labyrinthe = l;
    }

    public void attaquer(Entite t){
        //TODO
    }
}
