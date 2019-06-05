package jeu;

import utils.Place;
import java.util.ArrayList;
import java.util.List;

public class Niveau {

    public List<Labyrinthe> labyrinthes;

    private boolean fin;

    public Niveau(List<Labyrinthe> labyrinthes) {
        this.labyrinthes = labyrinthes;
    }

    public Niveau() {
        this.labyrinthes = new ArrayList<>();
    }

    public void addLaby(Labyrinthe l) {
        labyrinthes.add(l);
    }

    public void moveLaby(Personnage p, Labyrinthe current) {
        int i = labyrinthes.indexOf(current);
        if (i + 1 < labyrinthes.size()) {
            current.removePerso();
            p.setPosition(new Place(19, 1));
            Labyrinthe newLaby = labyrinthes.get(i + 1);
            newLaby.addPerso(p);
            p.setLabyrinthe(newLaby);
        }
        else {
            fin = true;
        }
    }

    public Labyrinthe getCurentLaby() {
        for (Labyrinthe l : labyrinthes) {
            if (l.hasPerso()) {
                return l;
            }
        }
        return null;
    }

    public boolean isFinish() {
        return fin;
    }
}
