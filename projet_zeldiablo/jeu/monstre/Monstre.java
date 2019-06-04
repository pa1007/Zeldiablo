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

    private boolean peutAttaquer() {
        boolean res = false;
        if (labyrinthe.getAventurier() != null) {
            Place pPerso = labyrinthe.getAventurier().getPosition();
            if (position.getX() + 1 == pPerso.getX() && position.getY() == pPerso.getY()) {
                res = true;
            } else if (position.getX() == pPerso.getX() && position.getY() + 1 == pPerso.getY()) {
                res = true;
            } else if (position.getX() - 1 == pPerso.getX() && position.getY() == pPerso.getY()) {
                res = true;
            } else if (position.getX() == pPerso.getX() && position.getY() - 1 == pPerso.getY()) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public void attaquer(Entite t) {
        if (peutAttaquer()) {
            t.subirDegats(degats);
        }
    }

    public int getPv() {
        return this.pv;
    }
}
