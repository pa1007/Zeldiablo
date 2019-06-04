package jeu;

import jeu.monstre.Monstre;
import utils.Place;

import java.awt.Color;
import java.awt.Graphics;

public class Personnage extends Entite {

    private static final int TAILLE_PERSO = 25;
    /**
     * Attribut prive qui correspond au nom du personnage
     */
    private final String nom;
    /**
     * Attribut de type Place qui permet de connaitre la position du personnage
     */
    private final Place position;

    /**
     * Constructeur qui cree un personnage avec un nom est une position
     *
     * @param n        nom du personnage
     * @param position Place occupee par le personnage
     */
    public Personnage(String n, int pdv, Place position, Labyrinthe l) {
        super(pdv, position, l, Type.PERSONNAGE);
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
        if (this.etreMort()) {
            g.setColor(Color.GRAY);
        }
        g.fillOval(
                TAILLE_PERSO * position.getX(),
                TAILLE_PERSO * position.getY(),
                TAILLE_PERSO,
                TAILLE_PERSO
        );
    }

    public int getPv() {
        return this.pv;
    }

    public void attaquer() {
        Place pPerso = getPosition();
        Monstre m1 = labyrinthe.rechercherMonstre(new Place(pPerso.getX() + 1, pPerso.getY()));
        Monstre m2 = labyrinthe.rechercherMonstre(new Place(pPerso.getX() - 1, pPerso.getY()));
        Monstre m3 = labyrinthe.rechercherMonstre(new Place(pPerso.getX(), pPerso.getY() + 1));
        Monstre m4 = labyrinthe.rechercherMonstre(new Place(pPerso.getX(), pPerso.getY() - 1));
        attaquerMonstre(m1);
        attaquerMonstre(m2);
        attaquerMonstre(m3);
        attaquerMonstre(m4);
    }

    public void attaquerMonstre(Monstre m) {
        if (m != null) {
            m.subirDegats(degats);
            if (m.etreMort()){
                labyrinthe.supMonstre(m);
            }
        }
    }

    @Override
    public void attaquer(Entite t) {}
}
