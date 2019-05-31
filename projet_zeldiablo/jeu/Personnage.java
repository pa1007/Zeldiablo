package jeu;

import utils.Place;

public class Personnage {

    /**
     * Attribut prive qui correspond au nom du personnage
     */
    private String nom;

    /**
     * Attribut de type Place qui permet de connaitre la position du personnage
     */
    private Place position;


    /**
     * Constructeur qui cree un personnage avec un nom est une position
     * @param n nom du personnage
     * @param position Place occupee par le personnage
     */
    public Personnage(String n, Place position){
        this.nom = n;
        this.position = position;
    }

    /**
     * Methode publique qui permet de faire se deplacer le personnage selon les points cardinaux
     * Nord :  'N'
     * Sud :   'S'
     * Est :   'E'
     * Ouest : 'O'
     * Si la direction n'est pas valide le personage ne bouge pas
     * @param direction direction dans laquelle va aller le personnage
     */
    public void seDeplacer(char direction){
        switch (direction){
            case 'N':
                this.position.incrementerY(1);
                break;
            case 'S':
                this.position.incrementerY(-1);
                break;
            case 'E':
                this.position.incrementerX(1);
                break;
            case 'O':
                this.position.incrementerX(-1);
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
}
