package jeu;

import jeu.monstre.Monstre;
import moteur_jeu.Commande;

public class JeuPerso implements moteur_jeu.Jeu {

    private Personnage personnage;

    private Labyrinthe labyrinthe;

    public JeuPerso(Personnage personnage, Labyrinthe labyrinthe) {
        this.personnage = personnage;
        this.labyrinthe = labyrinthe;
    }

    /**
     * methode qui contient l'evolution du jeu en fonction de la commande
     *
     * @param commandeUser commande utilisateur
     */
    @Override
    public void evoluer(Commande commandeUser) {
        for (Monstre m : labyrinthe.getMonstres()) {
            if (m.getType() == Entite.Type.MONSTRE_AI) {
                m.seDeplacer(((MonstreAI) m).getChoix(labyrinthe.getAventurier().getPosition()));
            }
        }
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
        if (commandeUser.espace) {
            personnage.attaquer();
        }


    }

    /**
     * @return true si et seulement si le jeu est fini
     */
    @Override
    public boolean etreFini() {
        return personnage.etreMort() || personnage.avoirGagne();
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }
}
