package dessin;

import moteur_jeu.DessinJeu;
import moteur_jeu.Jeu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DessinPerso implements DessinJeu {

    private Jeu jeu;

    public DessinPerso(Jeu jeu) {
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


        //finir avec
        g.dispose();
    }
}
