package jeu.monstre.ai;

import utils.Place;
import utils.RandomUtils;
import java.util.List;

public class AIExperte implements AI {

    private Algorithm algorithm;
    private int       canMove;

    public AIExperte(Algorithm a) {
        algorithm = a;
    }

    @Override
    public char faireChoix(Place start, Place destination) {
        boolean     algoLee = algorithm.leeAlgorithm(start, destination);
        List<Place> places  = algorithm.backTracking();
        if (algoLee && !places.isEmpty()) {
            return calcMov(start, places.get(0), RandomUtils.randBetween(1, 3));
        }
        return 'v';
    }

    private char calcMov(Place start, Place p, int dif) {
        int  x = p.getX() - start.getX();
        int  y = p.getY() - start.getY();
        char c = 'a';
        if (canMove >= dif) {
            if (x != 0) {
                c = x < 0 ? 'O' : 'E';
            }
            else if (y != 0) {
                c = y < 0 ? 'N' : 'S';
            }
            canMove = 0;
        }
        else {
            canMove += 2;
        }
        return c;

    }
}
