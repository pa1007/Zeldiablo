package jeu.monstre;

import jeu.Labyrinthe;
import jeu.MonstreAI;
import jeu.monstre.ai.AI;
import jeu.monstre.ai.AIExperte;
import jeu.monstre.ai.Algorithm;
import utils.Place;

public class GnomeAI extends Gnome implements MonstreAI {

    public AI aiExperte;

    public GnomeAI(Place place, Labyrinthe l) {
        super(place, l, Type.MONSTRE_AI);
        aiExperte = new AIExperte(this, new Algorithm(l));
    }


    public void setAiExperte(AI aiExperte) {
        this.aiExperte = aiExperte;
    }


    @Override
    public char getChoix(Place p) {
        return aiExperte.faireChoix(p);
    }
}
