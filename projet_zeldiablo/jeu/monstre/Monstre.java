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
        g.fillOval(TAILLE_MONSTRE/2 * position.getX(), TAILLE_MONSTRE/2 * position.getY(), TAILLE_MONSTRE/2, TAILLE_MONSTRE/2);
    }
}
