package jeu;

import jeu.cases.Case;
import jeu.monstre.Monstre;
import utils.Place;

import java.awt.Color;
import java.awt.Graphics;

public class Personnage extends Entite {

    /**
     * Taille du personnage (utilisé pour swing)
     */
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

    /**
     * Méthode permettant d'afficher graphiquement
     * un personnage sur la grille
     *
     * @param g Graphics
     */
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

    /**
     * Méthode permettant d'attaquer tous les
     * monstres autour du personnage
     */
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

    /**
     * Methode permettant d'attaquer un monstre et
     * vérifie s'il est mort
     *
     * @param m
     */
    private void attaquerMonstre(Monstre m) {
        if (m != null) {
            System.out.println("Tourvé");
            m.subirDegats(degats);
            if (m.etreMort()) {
                System.out.println("MORT");
                labyrinthe.supMonstre(m);
            }
        }
    }

    /**
     * Méthode permettant de savoir si l'utilisateur a gagné
     * en regardant si il se situe sur une case de type Sortie
     *
     * @return
     */
    public boolean avoirGagne() {
        return this.labyrinthe.rechercherCase(position).getType() == Case.CaseType.SORTIE;
    }

    /**
     * Méthode override d'attaquer
     *
     * @param t
     */
    @Override
    public void attaquer(Entite t) {
    }

    /**
     * Getter pour les PV
     *
     * @return PV
     */
    public int getPv() {
        return this.pv;
    }

    /**
     * Getter pour nom du personnage
     *
     * @return Nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     * Getter pour la position du personnage
     *
     * @return Position du personnage
     */
    public Place getPosition() {
        return position;
    }

}
