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
    private Niveau niveau;

    /**
     * Constructeur du jeu
     *
     * @param personnage personnage
     * @param niveau     niveau
     */
    public JeuPerso(Personnage personnage, Niveau niveau) {
        this.personnage = personnage;
        this.niveau = niveau;
    }

    /**
     * methode qui contient l'evolution du jeu en fonction de la commande
     *
     * @param commandeUser commande utilisateur
     */
    @Override
    public void evoluer(Commande commandeUser) {
        Labyrinthe currentLaby = niveau.getCurentLaby();
        if (currentLaby != null) {
            for (Iterator<Monstre> iterator = currentLaby.getMonstres().iterator(); iterator.hasNext(); ) {
                Monstre m = iterator.next();
                if (!m.etreMort()) {
                    currentLaby.rechercherCase(m.getPosition()).setOccupe(false);
                    m.seMouvoire(currentLaby.getAventurier().getPosition());
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

    }

    /**
     * Méthode permettant de savoir si le jeu est fini ou pas
     * en testant sir le personange est mort ou a gagné
     *
     * @return true si et seulement si le jeu est fini
     */
    @Override
    public boolean etreFini() {
        return personnage.etreMort() || niveau.isFinish();
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
     * Getter pour niveau
     *
     * @return niveau
     */
    public Niveau getNiveau() {
        return niveau;
    }

    public Labyrinthe getCurentLaby() {
        return niveau.getCurentLaby();
    }
}
