package jeu.monstre;

import jeu.Entite;
import jeu.Labyrinthe;
import jeu.monstre.ai.AI;
import jeu.monstre.ai.AIDebille;
import utils.Place;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Monstre extends Entite {

    private static final int TAILLE_MONSTRE = 25;

    private AI ai;

    public Monstre(int pdv, Place p, Labyrinthe laby) {
        super(pdv, p, laby, Type.MONSTRE);
        ai = new AIDebille();
    }

    public Monstre(int pointDeVieMonstre, Place place, Labyrinthe l, AI ai) {
        super(pointDeVieMonstre, place, l, Type.MONSTRE);
        this.ai = ai;
    }

    @Override
    public void attaquer(Entite t) {
        if (peutAttaquer()) {
            t.subirDegats(degats);
        }
    }

    public void setAi(AI ai) {
        this.ai = ai;
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

    public int getPv() {
        return this.pv;
    }

    public void seMouvoire(Place destination) {
        char res = ai.faireChoix(position, destination);
        super.seDeplacer(res);
    }

    private boolean peutAttaquer() {
        boolean res = false;
        if (labyrinthe.getAventurier() != null) {
            Place pPerso = labyrinthe.getAventurier().getPosition();
            if (position.getX() + 1 == pPerso.getX() && position.getY() == pPerso.getY()) {
                res = true;
            }
            else if (position.getX() == pPerso.getX() && position.getY() + 1 == pPerso.getY()) {
                res = true;
            }
            else if (position.getX() - 1 == pPerso.getX() && position.getY() == pPerso.getY()) {
                res = true;
            }
            else if (position.getX() == pPerso.getX() && position.getY() - 1 == pPerso.getY()) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Monstre{");
        sb.append("pv=").append(pv);
        sb.append(",degats=").append(degats);
        sb.append(", position=").append(position);
        sb.append(", entiteType=").append(entiteType);
        sb.append('}');
        return sb.toString();
    }
}
