package jeu.monstre.ai;

import utils.Place;
import utils.RandomUtils;

public class AIRandom implements AI {

    private char[] tab;

    public AIRandom() {
        tab = new char[]{'N', 'S', 'E', 'O'};
    }

    @Override
    public char faireChoix(Place start, Place destination) {
        int r = RandomUtils.randBetween(0, 3);
        return tab[r];
    }
}
