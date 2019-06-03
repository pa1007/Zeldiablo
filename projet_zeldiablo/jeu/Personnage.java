package jeu;

import utils.Place;
import java.awt.Color;
import java.awt.Graphics;

public class Personnage extends Entite {

    private static final int    TAILLE_PERSO       = 25;
    private final static int    POINT_DE_VIE_PERSO = 10;
    /**
     * Attribut prive qui correspond au nom du personnage
     */
    private final        String nom;
    /**
     * Attribut de type Place qui permet de connaitre la position du personnage
     */
    private final        Place  position;

    /**
     * Constructeur qui cree un personnage avec un nom est une position
     *
     * @param n        nom du personnage
     * @param position Place occupee par le personnage
     */
    public Personnage(String n, Place position, Labyrinthe l) {
        super(POINT_DE_VIE_PERSO, position, l);
        this.nom = n;
        this.position = position;
    }

    @Override
    public void attaquer(Entite t) {

    }

    @Override
    public void subirDegats(int degats) {

    }

    /**
     * Methode publique qui permet de faire se deplacer le personnage selon les points cardinaux
     * Nord :  'N'
     * Sud :   'S'
     * Est :   'E'
     * Ouest : 'O'
     * Si la direction n'est pas valide le personage ne bouge pas
     *
     * @param direction direction dans laquelle va aller le personnage
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

    public String getNom() {
        return nom;
    }

    public Place getPosition() {
        return position;
    }

    public void afficher(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval(
                TAILLE_PERSO * position.getX(),
                TAILLE_PERSO * position.getY(),
                TAILLE_PERSO,
                TAILLE_PERSO
        );
    }

    public void setLabyrinthe(Labyrinthe l) {
        this.labyrinthe = l;
    }

    private void move(int dx, int dy) {
        Place tempPlace      = new Place(this.getPosition().getX() + dx, this.getPosition().getY() + dy);
        Case  caseRecherchee = this.labyrinthe.rechercherCase(tempPlace);
        if (caseRecherchee != null && caseRecherchee.isVide()) {
            this.position.incrementerX(dx);
            this.position.incrementerY(dy);
        }
    }
}
