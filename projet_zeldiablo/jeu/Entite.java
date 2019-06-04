package jeu;

import jeu.cases.Case;
import jeu.cases.Piege;
import utils.Place;

public abstract class Entite {

    /**
     * Nombre de points de vie
     */
    protected int pv;

    /**
     * Degats de l'entité
     */
    protected int degats;

    /**
     * Position
     */
    protected Place position;

    /**
     * Labyrinthe où se situe l'entité
     */
    protected Labyrinthe labyrinthe;

    /**
     * Type de l'entité
     */
    protected Type entiteType;

    /**
     * Constructeur de l'entité
     *
     * @param pointdevie points de vie
     * @param place      place où spawn
     * @param l          labyrinthe
     * @param type       type de l'entité
     */
    public Entite(int pointdevie, Place place, Labyrinthe l, Type type) {
        this.pv = pointdevie;
        this.position = place;
        this.labyrinthe = l;
        this.entiteType = type;
        this.degats = 3;
    }

    /**
     * Setter pour degats
     *
     * @param degats degats
     */
    public void setDegats(int degats) {
        this.degats = degats;
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

    /**
     * Méthode abstraite attaquer
     *
     * @param t entité
     */
    public abstract void attaquer(Entite t);

    /**
     * Méthode permettant de subir des dégats
     *
     * @param d degats subis
     */
    public void subirDegats(int d) {
        pv = pv - d <= 0 ? 0 : pv - d;
    }

    /**
     * Méthode permettant de savoir si le personnage
     * est décédé
     *
     * @return booléen si le personnage est mort
     */
    public boolean etreMort() {
        return this.pv == 0;
    }

    /**
     * Setter pour labyrinthe
     *
     * @param l labyrinthe
     */
    public void setLabyrinthe(Labyrinthe l) {
        this.labyrinthe = l;
    }

    /**
     * Getter pour le type de l'entité
     *
     * @return
     */
    public Type getType() {
        return entiteType;
    }

    /**
     * Méthode permettant de déplacer le personnage
     * et test s'il peut attaquer et si c'est une case piege alors
     * il inflige des degats au personnage
     *
     * @param dx deplacement en x
     * @param dy deplacement en y
     */
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

    /**
     * Enum pour les types d'entité
     */
    public enum Type {
        MONSTRE,
        PERSONNAGE,
        MONSTRE_AI
    }
}
