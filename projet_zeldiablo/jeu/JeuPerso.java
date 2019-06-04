package jeu;

import jeu.monstre.Monstre;
import moteur_jeu.Commande;
import java.util.Iterator;

public class JeuPerso implements moteur_jeu.Jeu {

    /**
     * Personnage associé au jeu
     */
    private Personnage personnage;

    /**
     * Labyrinthe associé au jeu
     */
    private Labyrinthe labyrinthe;

    /**
     * Constructeur du jeu
     *
     * @param personnage personnage
     * @param labyrinthe labyrinthe
     */
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
        for (Iterator<Monstre> iterator = labyrinthe.getMonstres().iterator(); iterator.hasNext(); ) {
            Monstre m = iterator.next();
            if (!m.etreMort()) {
                labyrinthe.rechercherCase(m.getPosition()).setOccupe(false);
                m.seMouvoire(labyrinthe.getAventurier().getPosition());
            }
            else {
                iterator.remove();
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
     * Méthode permettant de savoir si le jeu est fini ou pas
     * en testant sir le personange est mort ou a gagné
     *
     * @return true si et seulement si le jeu est fini
     */
    @Override
    public boolean etreFini() {
        return personnage.etreMort() || personnage.avoirGagne();
    }

    /**
     * Getter pour personnage
     *
     * @return personnage
     */
    public Personnage getPersonnage() {
        return personnage;
    }

    /**
     * Getter pour labyrinthe
     *
     * @return labyrinthe
     */
    public Labyrinthe getLabyrinthe() {
        return labyrinthe;
    }
}
