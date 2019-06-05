package utils;

import java.util.Random;

public class RandomUtils {


    public static int randBetween(int min, int max) {
        return new Random().nextInt(max + 1 - min) + min;
    }
}
