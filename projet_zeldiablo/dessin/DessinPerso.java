package dessin;

import jeu.JeuPerso;
import moteur_jeu.DessinJeu;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu {

    /**
     * Jeu
     */
    private JeuPerso jeu;

    /**
     * Constructeur pour le dessinPerso
     *
     * @param jeu
     */
    public DessinPerso(JeuPerso jeu) {
        this.jeu = jeu;
    }

    /**
     * methode dessiner a completer. Elle construit une image correspondant au
     * jeu. Jeu est un attribut de l'afficheur
     *
     * @param image image sur laquelle dessiner
     */
    @Override
    public void dessiner(BufferedImage image) {

        Graphics g = image.getGraphics();
        //ajouter ce qu'on veut dessiner

        jeu.getCurentLaby().afficher(g);


        //finir avec
        g.dispose();
    }
}
