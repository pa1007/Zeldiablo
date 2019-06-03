package jeu;

import utils.Place;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {
    private List<Case> cases;
    private Personnage aventurier;

    public Labyrinthe(Personnage aventurier) {
        this.aventurier = aventurier;
        this.cases = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.cases.add(new Case(i, j));
            }
        }
    }

    public Labyrinthe(List<Case> cases, Personnage aventurier) {
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
}
