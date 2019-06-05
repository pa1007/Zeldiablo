package moteur_jeu;


import jeu.JeuPerso;

/**
 * classe MoteurGraphique represente un moteur de jeu generique.
 * <p>
 * On lui passe un jeu et un afficheur et il permet d'executer un jeu.
 */
public class MoteurGraphique {

    /**
     * le jeu a executer
     */
    private JeuPerso jeu;

    /**
     * l'interface graphique
     */
    private InterfaceGraphique gui;

    /**
     * l'afficheur a utiliser pour le rendu
     */
    private DessinJeu dessin;

    /**
     * construit un moteur
     *
     * @param pJeu     jeu a lancer
     * @param pAffiche afficheur a utiliser
     */
    public MoteurGraphique(JeuPerso pJeu, DessinJeu pAffiche) {
        // creation du jeu
        this.jeu = pJeu;
        this.dessin = pAffiche;
    }

    /**
     * permet de lancer le jeu
     */
    public void lancerJeu(int width, int height) throws InterruptedException {

        // creation de l'interface graphique
        this.gui = new InterfaceGraphique(this.dessin, width, height);
        Controleur controle = this.gui.getControleur();

        // boucle de jeu
        while (!this.jeu.etreFini()) {
            // demande controle utilisateur
            Commande c = controle.getCommande();
            // fait evoluer le jeu
            this.jeu.evoluer(c);
            this.jeu.getPersonnage().avoirChanger();
            // affiche le jeu
            this.gui.dessiner();
            // met en attente
            Thread.sleep(100);
        }
        if (this.jeu.getNiveau().isFinish()) {
            this.gui.dessinerGagner();
        }
        else {
            this.gui.dessinerGameOver();
        }
    }

}
