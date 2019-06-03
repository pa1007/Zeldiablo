package jeu.monstre;

import jeu.Entite;
import jeu.Labyrinthe;
import utils.Place;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Monstre extends Entite {

    private static final int TAILLE_MONSTRE = 25;

    private static final int POINT_DE_VIE_MONSTRE = 3;


    public Monstre(Place p, Labyrinthe laby) {
        super(POINT_DE_VIE_MONSTRE, p, laby, Type.MONSTRE);
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
