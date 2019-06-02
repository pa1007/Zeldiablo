package jeu;

import moteur_jeu.Commande;

public class JeuPerso implements moteur_jeu.Jeu {

    private Personnage personnage;

    public JeuPerso(Personnage personnage) {
        this.personnage = personnage;
    }

    /**
     * methode qui contient l'evolution du jeu en fonction de la commande
     *
     * @param commandeUser commande utilisateur
     */
    @Override
    public void evoluer(Commande commandeUser) {
        if (commandeUser.bas) {
            personnage.seDeplacer('S');
        }
        if (commandeUser.droite) {
            personnage.seDeplacer('E');
        }
        if (commandeUser.gauche) {
            personnage.seDeplacer('O');
        }
        if (commandeUser.haut) {
            personnage.seDeplacer('N');
        }


    }


    /**
     * @return true si et seulement si le jeu est fini
     */
    @Override
    public boolean etreFini() {
        return false;
    }
}
