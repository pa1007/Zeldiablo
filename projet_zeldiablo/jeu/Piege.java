package jeu;

import utils.Place;

public class Piege extends Case {

    private final static int     DEGATS_PIEGE = 2;
    private              boolean visible;

    public Piege(Place place) {
        super(place);
        this.type = CaseType.PIEGE;
    }

    @Override
    public char getLetter() {
        return 'p';
    }

    public void infligerDegats(Personnage p) {
        p.subirDegats(DEGATS_PIEGE);
        if (!this.visible) {
            this.visible = true;
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean b) {
        this.visible = b;
    }
}
