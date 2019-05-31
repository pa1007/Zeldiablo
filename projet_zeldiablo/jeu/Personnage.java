package jeu;

import utils.Place;

public class Personnage {

    private String nom;
    private Place position;


    public Personnage(String nom, Place position){
        this.nom = nom;
        this.position = position;
    }

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


}
