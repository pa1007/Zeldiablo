package jeu;

import jeu.monstre.Monstre;
import utils.Place;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {

    private List<Case> cases;
    private Personnage aventurier;
    private List<Monstre> monstres;


    public Labyrinthe(Personnage aventurier) {
        this.aventurier = aventurier;
        monstres = new ArrayList<>();
        this.cases = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.cases.add(new Case(i, j));
            }
        }
        if (aventurier != null) {
            Case c = rechercherCase(aventurier.getPosition());
            if (c != null) {
                c.setOccupe(true);
            }
        }
    }

    public Labyrinthe(List<Case> cases, Personnage aventurier) {
        this.monstres = new ArrayList<>();
        this.aventurier = aventurier;
        if (cases != null) {
            this.cases = cases;
        } else {
            this.cases = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    this.cases.add(new Case(i, j));
                }
            }
        }
        if (aventurier != null) {
            Case c = rechercherCase(aventurier.getPosition());
            if (c != null) {
                c.setOccupe(true);
            }
        }

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

    public void afficher(Graphics g) {
        for (Case c : cases) {
            c.afficher(g);
        }
        aventurier.afficher(g);

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
            Case  c = rechercherCase(p);
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
    public void supMosntre(Monstre m) {
        if (m != null) {
            Place p = m.getPosition();
            Case  c = rechercherCase(p);
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
}
