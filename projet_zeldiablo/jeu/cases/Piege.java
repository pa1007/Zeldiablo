package jeu.cases;

import jeu.Personnage;
import jeu.cases.Case;
import org.w3c.dom.css.RGBColor;
import utils.Place;

import java.awt.*;

public class Piege extends Case {

    private final static int     DEGATS_PIEGE = 2;
    private              boolean visible;

    public Piege(Place place) {
        super(place);
        this.type = CaseType.PIEGE;
    }

    @Override
    public char getLetter() {
        return 'P';
    }

    public void infligerDegats(Personnage p) {
        p.subirDegats(DEGATS_PIEGE);
        if (!this.visible) {
            this.visible = true;
        }
    }

    @Override
    public void afficher(Graphics g) {
        super.afficher(g);
        if (visible){
            g.setColor(new Color(139,69,19));
            g.setFont(new Font("Arial", Font.PLAIN, 33));
            g.drawString("X", TAILLE_CASE * place.getX(), TAILLE_CASE * place.getY()+TAILLE_CASE);
        }
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean b) {
        this.visible = b;
    }
}
