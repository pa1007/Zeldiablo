package jeu;

import jeu.monstre.Gnome;
import jeu.monstre.Monstre;
import utils.Place;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {

    private List<Case>    cases;
    private Personnage    aventurier;
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
    }

    public List<Case> getCases() {
        return cases;
    }

    public Personnage getAventurier() {
        return aventurier;
    }

    public Case rechercherCase(Place p) {
        Case res = null;
        for (Case c : this.cases) {
            if (c.getPlace().equals(p)){
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

    public void addMur(Place p) {
        Case res = rechercherCase(p);
        if (res != null && res.isVide()) {
            res.setMur(true);
        }
    }
}
