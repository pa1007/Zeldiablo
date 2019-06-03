package jeu.monstre;

import utils.Place;

import java.awt.*;

public abstract class Monstre {

    protected Place position;

    private static final int TAILLE_MONSTRE = 25;

    public Monstre(Place p){
        this.position = p;
    }

    public void afficher(Graphics g){
        g.setColor(Color.red);
        g.fillRect(TAILLE_MONSTRE * position.getX(), TAILLE_MONSTRE * position.getY(), TAILLE_MONSTRE, TAILLE_MONSTRE);
    }
}
