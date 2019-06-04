package jeu.monstre.ai;

import jeu.monstre.Monstre;
import utils.Place;

public class AIExperte implements AI {

    private Monstre   monstre;
    private Algorithm algorithm;

    public AIExperte(Monstre monstre, Algorithm a) {
        this.monstre = monstre;
        algorithm = a;
    }

    @Override
    public char faireChoix(Place destination) {
        boolean algoLee = algorithm.leeAlgorithm(destination);
        if (algoLee) {
            return calcMov(algorithm.backTracking().get(0));
        }
        return 'v';
    }

    private char calcMov(Place p) {
        Place position = monstre.getPosition();
        int   x        = p.getX() - position.getX();
        int   y        = p.getY() - position.getY();
        char  c        = 'a';
        if (x != 0) {
            c = x < 0 ? 'O' : 'E';
        }
        else if (y != 0) {
            c = y < 0 ? 'N' : 'S';
        }
        return c;

    }
}
