package moteur_jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * classe qui represente un controleur en lien avec un KeyListener
 *
 * @author vthomas
 */
public class Controleur implements KeyListener {

    /**
     * commande en cours
     */
    private Commande commandeEnCours;
    /**
     * commande a retourner la difference avec la commandeencours vient du fait
     * qu'on veut memoriser une touche appuyee
     */
    private Commande commandeARetourner;

    /**
     * construction du controleur par defaut le controleur n'a pas de commande
     */
    public Controleur() {
        this.commandeEnCours = new Commande();
        this.commandeARetourner = new Commande();
    }

    @Override
    /**
     * met a jour les commandes en fonctions des touches appuyees
     */
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()) {
            // si on appuie sur 'q',commande joueur est gauche
            case 'q':
                this.commandeEnCours.gauche = false;
                this.commandeARetourner.gauche = true;
                break;
            // si on appuie sur 'd',commande joueur est droite
            case 'd':
                this.commandeEnCours.droite = false;
                this.commandeARetourner.droite = true;
                break;
            // si on appuie sur 'z',commande joueur est haut
            case 'z':
                this.commandeEnCours.haut = false;
                this.commandeARetourner.haut = true;
                break;
            // si on appuie sur 's',commande joueur est bas
            case 's':
                this.commandeEnCours.bas = false;
                this.commandeARetourner.bas = true;
                break;
            case ' ':
                this.commandeEnCours.espace = true;
                this.commandeARetourner.espace = true;
                break;
        }

    }

    @Override
    /**
     * met a jour les commandes quand le joueur relache une touche
     */
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'q':
                this.commandeEnCours.gauche = false;
                break;
            case 'd':
                this.commandeEnCours.droite = false;
                break;
            case 'z':
                this.commandeEnCours.haut = false;
                break;
            case 's':
                this.commandeEnCours.bas = false;
                break;
            case ' ':
                this.commandeEnCours.espace = false;
                break;
        }

    }

    @Override
    /**
     * ne fait rien
     */
    public void keyTyped(KeyEvent e) {

    }

    /**
     * quand on demande les commandes, le controleur retourne la commande en
     * cours
     *
     * @return commande faite par le joueur
     */
    public Commande getCommande() {
        Commande aRetourner = this.commandeARetourner;
        this.commandeARetourner = new Commande(this.commandeEnCours);
        return (aRetourner);
    }

}
