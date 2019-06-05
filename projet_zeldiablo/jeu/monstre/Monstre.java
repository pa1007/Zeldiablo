package jeu.monstre;

import jeu.Entite;
import jeu.Labyrinthe;
import jeu.monstre.ai.AI;
import jeu.monstre.ai.AIDebille;
import utils.Place;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Monstre extends Entite {

    /**
     * Taille du monstre (utilisé dans le graphics)
     */
    private static final int TAILLE_MONSTRE = 25;

    /**
     * Intelligence associée au monstre
     */
    private AI ai;

    /**
     * Constructeur du Monstre
     *
     * @param pdv  points de vie
     * @param p    place ou spawn
     * @param laby labyrinthe
     */
    public Monstre(int pdv, Place p, Labyrinthe laby) {
        super(pdv, p, laby, Type.MONSTRE);
        ai = new AIDebille();
    }

    /**
     * Constructeur de monstre
     *
     * @param pointDeVieMonstre points de vie du monstre
     * @param place             place
     * @param l                 labyrinthe
     * @param ai                intelligence
     */
    public Monstre(int pointDeVieMonstre, Place place, Labyrinthe l, AI ai) {
        super(pointDeVieMonstre, place, l, Type.MONSTRE);
        this.ai = ai;
    }

    /**
     * Méthode permettant d'attaquer une entité
     *
     * @param t entité
     */
    @Override
    public void attaquer(Entite t) {
        if (peutAttaquer()) {
            t.subirDegats(degats);
        }
    }

    /**
     * Méthode permettant d'afficher un monstre
     *
     * @param g Graphics
     */
    @Override
    public void afficher(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(
                TAILLE_MONSTRE * position.getX(),
                TAILLE_MONSTRE * position.getY(),
                TAILLE_MONSTRE,
                TAILLE_MONSTRE
        );
        super.afficher(g);
    }

    /**
     * Setter pour l'intelligence
     *
     * @param ai intelligence
     */
    public void setAi(AI ai) {
        this.ai = ai;
    }

    /**
     * Appel l'intelligence pour se déplacer
     *
     * @param destination destination
     */
    public void seMouvoire(Place destination) {
        char res = ai.faireChoix(position, destination);
        super.seDeplacer(res);
    }

    /**
     * Getter pour la position
     *
     * @return position
     */
    public Place getPosition() {
        return position;
    }

    /**
     * Getter pour les PV
     *
     * @return points de vie
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Méthode permettant de savoir si un monstre
     * a un personange a proximité de lui et retourne
     * un booleen s'il peut attaquer
     *
     * @return booleen
     */
    private boolean peutAttaquer() {
        boolean res = false;
        if (labyrinthe.getAventurier() != null) {
            Place pPerso = labyrinthe.getAventurier().getPosition();
            if (position.getX() + 1 == pPerso.getX() && position.getY() == pPerso.getY()
                || position.getX() == pPerso.getX() && position.getY() + 1 == pPerso.getY()
                || position.getX() - 1 == pPerso.getX() && position.getY() == pPerso.getY()
                || position.getX() == pPerso.getX() && position.getY() - 1 == pPerso.getY()) {
                res = true;
            }
        }
        return res;
    }

    /**
     * To String du monstre
     *
     * @return string
     */
    @Override
    public String toString() {
        return "Monstre{" + "pv=" + pv
               + ",degats=" + degats
               + ", position=" + position
               + ", entiteType=" + entiteType
               + '}';
    }
}
