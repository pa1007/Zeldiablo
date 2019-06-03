package jeu.monstre;

import jeu.Entite;
import jeu.Labyrinthe;
import utils.Place;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Monstre extends Entite {

    private static final int TAILLE_MONSTRE = 25;

    public Monstre(int pdv, Place p, Labyrinthe laby) {
        super(pdv, p, laby, Type.MONSTRE);
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

    public boolean peutAttaquer() {
        // @TODO : Doit check si un Personnage est au NORD,SUD,EST,OUEST, si oui alors return true
        return true;
    }

    @Override
    public void attaquer(Entite t) {
        if (peutAttaquer()) {
            t.subirDegats(degats);
        }
    }
}
