package jeu;

import jeu.cases.Case;
import jeu.cases.Entree;
import jeu.cases.Piege;
import jeu.cases.Sortie;
import jeu.monstre.Monstre;
import utils.Place;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {

    /**
     * Liste de cases du Labyrinthe
     */
    private List<Case> cases;

    /**
     * Personnage dans le Labyrinthe
     */
    private Personnage aventurier;

    /**
     * Liste de monstres dans le labyrinthe
     */
    private List<Monstre> monstres;


    /**
     * Constructeur vide de labyrinthe,
     * initialise la liste de cases (20x20)
     * avec une case d'entrée en 0,0 et une sortie en 19,19
     * ainsi qu'un piege en 18,18
     */
    public Labyrinthe() {
        monstres = new ArrayList<>();
        this.cases = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (j == 0 && i == 0) {
                    this.cases.add(new Entree(new Place(0, 0)));
                } else {
                    if (j == 18 && i == 18) {
                        this.cases.add(new Piege(new Place(18, 18)));
                    } else {
                        if (j == 19 && i == 19) {
                            this.cases.add(new Sortie(new Place(19, 19)));
                        } else {
                            this.cases.add(new Case(i, j));
                        }
                    }
                }
            }
        }
    }

    /**
     * Constructeur de Labyrinthe a partir d'une liste
     * de cases
     *
     * @param cases liste de cases du labyrinthe
     */
    public Labyrinthe(List<Case> cases) {
        this.monstres = new ArrayList<>();
        if (cases != null && !cases.isEmpty()) {
            this.cases = cases;
        } else {
            this.cases = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    this.cases.add(new Case(i, j));
                }
            }
        }

    }

    /**
     * Methode permettant de retourner l'objet Case se situant a une certaine Place
     *
     * @param p Place a tester
     * @return Case recherchee
     */
    public Case rechercherCase(Place p) {
        Case res = null;
        for (Case c : this.cases) {
            if (c.getPlace().equals(p)) {
                res = c;
                break;
            }
        }
        return res;
    }

    /**
     * Méthode permettant de retourner le monstre se situant
     * sur une certaine place
     *
     * @param p place
     * @return monstre sur la places'il existe sinon null
     */
    public Monstre rechercherMonstre(Place p) {
        Monstre res = null;
        for (Monstre m : this.monstres) {
            if (m.getPosition().equals(p)) {
                res = m;
                break;
            }
        }
        return res;
    }

    /**
     * Méthode permettant d'afficher le labyrinthe
     *
     * @param g Graphics
     */
    public void afficher(Graphics g) {
        for (Case c : cases) {
            c.afficher(g);
        }
        if (aventurier != null) {
            aventurier.afficher(g);
        }

        for (Monstre m : monstres) {
            m.afficher(g);
        }

    }

    /**
     * Methode permettant d'ajouter un mur a une certaine place
     *
     * @param p Place ou l'on veut ajouter un mur
     */
    public void addMur(Place p) {
        Case res = rechercherCase(p);
        if (res != null && res.isVide()) {
            res.setMur(true);
        }
    }

    /**
     * Permet de sup le monstre en param <br> et set la case a occupee
     *
     * @param m le monstre
     */
    public void addMonstre(Monstre m) {
        if (m != null) {
            Place p = m.getPosition();
            Case c = rechercherCase(p);
            if (c != null && c.isVide()) {
                monstres.add(m);
                c.setOccupe(true);
            }
        }
    }

    /**
     * Permet de sup le monstre en param <br>
     * et set la case a vide
     *
     * @param m le monstre
     */
    public void supMonstre(Monstre m) {
        if (m != null) {
            Place p = m.getPosition();
            Case c = rechercherCase(p);
            if (c != null && c.isOccupe()) {
                monstres.remove(m);
                c.setOccupe(false);
            }
        }
    }

    /**
     * Methode permettant de supprimer un mur a une certaine place
     *
     * @param p Place
     */
    public void removeMur(Place p) {
        Case res = rechercherCase(p);
        if (res != null && res.isMur()) {
            res.setMur(false);
        }
    }

    /**
     * Methode permettant de changer l'attribut occupe d'une case a une place donne
     *
     * @param p Place
     */
    public void occuperCase(Place p, boolean occupee) {
        Case res = rechercherCase(p);
        if (res != null && res.isVide()) {
            res.setOccupe(occupee);
        }
    }

    /**
     * Methode permettant de savoir si la case situee a une place donnee est un mur ou non
     *
     * @param p Place
     * @return Booleen
     */
    public boolean etreMur(Place p) {
        Case res = rechercherCase(p);
        if (res != null) {
            return res.isMur();
        }
        return false;
    }

    /**
     * Methode permeettant de savoir si la case situee a une placee donne est un mur ou non
     *
     * @param p Place
     * @return Booleen
     */
    public boolean etreOccupe(Place p) {
        Case res = rechercherCase(p);
        if (res != null) {
            return res.isOccupe();
        }
        return false;
    }

    /**
     * Méthode permettant d'ajouter un personnage au labyrinthe
     *
     * @param perso personnage
     */
    public void addPerso(Personnage perso) {
        if (this.aventurier == null) {
            Case c = rechercherCase(perso.getPosition());
            if (c != null) {
                c.setOccupe(true);
                aventurier = perso;
            }

        }
    }

    /**
     * Getter pour la liste de monstres
     *
     * @return Liste de monstres
     */
    public List<Monstre> getMonstres() {
        return this.monstres;
    }

    /**
     * Getter permettant de retourner la liste de cases du labyrinthe
     *
     * @return Liste de cases
     */
    public List<Case> getCases() {
        return cases;
    }

    /**
     * Getter permettant de retourner le personnage se situant dans la labyrinthe
     *
     * @return Personnage
     */
    public Personnage getAventurier() {
        return aventurier;
    }
}
