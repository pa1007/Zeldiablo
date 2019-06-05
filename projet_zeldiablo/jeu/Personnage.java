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
    private static final int    TAILLE_PERSO = 25;
    private              int    ancienPV;
    private final        Niveau niveau;
    /**
     * Attribut prive qui correspond au nom du personnage
     */
    private final        String nom;

    /**
     * Constructeur qui cree un personnage avec un nom est une position
     *
     * @param n        nom du personnage
     * @param position Place occupee par le personnage
     */
    public Personnage(String n, int pdv, Place position, Labyrinthe l, Niveau niv) {
        super(pdv, position, l, Type.PERSONNAGE);
        this.nom = n;
        this.ancienPV = pdv;
        niveau = niv;
    }

    /**
     * Méthode permettant d'afficher graphiquement
     * un personnage sur la grille
     *
     * @param g Graphics
     */
    @Override
    public void afficher(Graphics g) {
        Color temp;
        if (ancienPV != pv) {
            temp = Color.BLACK;
            ancienPV = pv;
        }
        else {
            temp = Color.ORANGE;
        }
        g.setColor(temp);
        if (this.etreMort()) {
            g.setColor(Color.GRAY);
        }
        g.fillOval(
                TAILLE_PERSO * position.getX(),
                TAILLE_PERSO * position.getY(),
                TAILLE_PERSO,
                TAILLE_PERSO
        );
        super.afficher(g);
    }

    @Override
    public void attaquer(Entite t) {

    }

    @Override
    public void subirDegats(int d) {
        ancienPV = pv;
        super.subirDegats(d);

    }

    /**
     * Méthode permettant d'attaquer tous les
     * monstres autour du personnage
     */
    public void attaquer() {
        Place   pPerso = getPosition();
        Monstre m1     = labyrinthe.rechercherMonstre(new Place(pPerso.getX() + 1, pPerso.getY()));
        Monstre m2     = labyrinthe.rechercherMonstre(new Place(pPerso.getX() - 1, pPerso.getY()));
        Monstre m3     = labyrinthe.rechercherMonstre(new Place(pPerso.getX(), pPerso.getY() + 1));
        Monstre m4     = labyrinthe.rechercherMonstre(new Place(pPerso.getX(), pPerso.getY() - 1));
        attaquerMonstre(m1);
        attaquerMonstre(m2);
        attaquerMonstre(m3);
        attaquerMonstre(m4);
    }

    /**
     * Méthode permettant de savoir si l'utilisateur a gagné
     * en regardant si il se situe sur une case de type Sortie
     *
     * @return
     */
    public void avoirChanger() {
        if (this.labyrinthe.rechercherCase(position).getType() == Case.CaseType.SORTIE) {
            niveau.moveLaby(this, labyrinthe);

        }
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

    /**
     * Methode permettant d'attaquer un monstre et
     * vérifie s'il est mort
     *
     * @param m
     */
    private void attaquerMonstre(Monstre m) {
        if (m != null) {
            m.subirDegats(degats);
            if (m.etreMort()) {
                labyrinthe.supMonstre(m);
            }
        }
    }
}
