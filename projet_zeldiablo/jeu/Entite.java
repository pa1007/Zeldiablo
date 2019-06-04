package jeu;

import utils.Place;

public abstract class Entite {

    protected int pv;

    protected int degats;

    protected Place position;

    protected Labyrinthe labyrinthe;

    protected Type entiteType;


    public Entite(int pointdevie, Place place, Labyrinthe l, Type type) {
        this.pv = pointdevie;
        this.position = place;
        this.labyrinthe = l;
        this.entiteType = type;
        this.degats = 3;
    }

    /**
     * Methode publique qui permet de faire se deplacer le personnage selon les points cardinaux
     * Nord :  'N'
     * Sud :   'S'
     * Est :   'E'
     * Ouest : 'O'
     * Si la direction n'est pas valide l'entite ne bouge pas
     *
     * @param direction direction dans laquelle va aller l'entite
     */
    public void seDeplacer(char direction) {
        switch (direction) {
            case 'N':
                move(0, -1);
                break;
            case 'S':
                move(0, 1);
                break;
            case 'E':
                move(1, 0);
                break;
            case 'O':
                move(-1, 0);
                break;
            default:
                System.out.println("Caractere non valide");
                break;
        }
    }

    private void move(int dx, int dy) {
        Place tempPlace = new Place(this.position.getX() + dx, this.position.getY() + dy);
        Case caseRecherchee = this.labyrinthe.rechercherCase(tempPlace);
        if (caseRecherchee != null && caseRecherchee.isVide()) {
            this.position.incrementerX(dx);
            this.position.incrementerY(dy);
            if (caseRecherchee.getType() == Case.CaseType.PIEGE && this.entiteType == Type.PERSONNAGE) {
                ((Piege) caseRecherchee).infligerDegats((Personnage) this);
            }
            if (entiteType == Type.MONSTRE) {
                attaquer(labyrinthe.getAventurier());
            }
        }
    }

    public abstract void attaquer(Entite t);

    public void subirDegats(int d) {
        if (this.pv >= d) {
            this.pv -= d;
        } else {
            this.pv = 0;
        }
    }

    public enum Type {
        MONSTRE,
        PERSONNAGE
    }
}
