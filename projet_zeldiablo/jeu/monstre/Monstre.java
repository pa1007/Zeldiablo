package jeu.monstre;

import utils.Place;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Monstre {

    private static final int TAILLE_MONSTRE = 25;
    protected Place position;

    public Monstre(Place p) {
        this.position = p;
    }

    public Place getPosition() {
        return position;
    }

    public void afficher(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(
                TAILLE_MONSTRE * position.getX(),
                TAILLE_MONSTRE * position.getY(),
                TAILLE_MONSTRE,
                TAILLE_MONSTRE
        );
    }
}
