package jeu;

import java.util.ArrayList;
import java.util.List;

public class Labyrinthe {
    private List<Case> cases;
    private Personnage aventurier;

    public Labyrinthe(Personnage aventurier) {
        this.aventurier = aventurier;
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                this.cases = new ArrayList<>(400);
                this.cases.add(new Case(i,j));
            }
        }
    }

    public Labyrinthe(List<Case> cases, Personnage aventurier) {
        this.aventurier = aventurier;
        if (cases != null) {
            this.cases = cases;
        }
    }
}
