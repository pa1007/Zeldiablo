package jeu;

import utils.Place;
import java.awt.Color;
import java.awt.Graphics;

public class Personnage extends Entite {

    private static final int    TAILLE_PERSO       = 25;
    /**
     * Attribut prive qui correspond au nom du personnage
     */
    private final        String nom;
    /**
     * Attribut de type Place qui permet de connaitre la position du personnage
     */
    private final        Place  position;

    /**
     * Constructeur qui cree un personnage avec un nom est une position
     *
     * @param n        nom du personnage
     * @param position Place occupee par le personnage
     */
    public Personnage(String n, int pdv, Place position, Labyrinthe l) {
        super(pdv,position, l, Type.PERSONNAGE);
        this.nom = n;
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public Place getPosition() {
        return position;
    }

    public void afficher(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(
                TAILLE_PERSO * position.getX(),
                TAILLE_PERSO * position.getY(),
                TAILLE_PERSO,
                TAILLE_PERSO
        );
    }

    public void setLabyrinthe(Labyrinthe l) {
        this.labyrinthe = l;
    }

    public int getPv(){
        return this.pv;
    }

    @Override
    public void attaquer(Entite t) {

    }
}
