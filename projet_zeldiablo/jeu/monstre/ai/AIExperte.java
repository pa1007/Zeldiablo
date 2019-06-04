package jeu.monstre.ai;

import utils.Place;

public class AIExperte implements AI {

    private Algorithm algorithm;

    public AIExperte(Algorithm a) {
        algorithm = a;
    }

    @Override
    public char faireChoix(Place start, Place destination) {
        boolean algoLee = algorithm.leeAlgorithm(destination);
        if (algoLee) {
            return calcMov(start, algorithm.backTracking().get(0));
        }
        return 'v';
    }

    private char calcMov(Place start, Place p) {
        int  x = p.getX() - start.getX();
        int  y = p.getY() - start.getY();
        char c = 'a';
        if (x != 0) {
            c = x < 0 ? 'O' : 'E';
        }
        else if (y != 0) {
            c = y < 0 ? 'N' : 'S';
        }
        return c;

    }
}
