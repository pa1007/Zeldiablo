package utils;

import jeu.Case;
import jeu.Labyrinthe;
import jeu.monstre.Monstre;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Sauvegarde {

    private static final String PATH = "SaveLaby.txt";

    public static void save(Labyrinthe l) throws IOException {
        StringBuilder sb    = new StringBuilder();
        int           lastY = 0;
        for (Case c : l.getCases()) {
            Place cP = c.getPlace();

            if (cP.getX() > lastY) {
                lastY = cP.getX();
                sb.append("/\n");

            }

            char letter = c.getLetter();
            if (letter == 'O') {
                Monstre m = l.rechercherMonstre(cP);
                if (m == null) {
                    letter = 'V';
                    sb.append(letter);
                }
                else {
                    sb.append(letter);
                }
            }
            else {
                sb.append(letter);
            }
            sb.append("-");
        }
        String         s  = sb.toString();
        File           f  = new File(PATH);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(s);
        bw.flush();
        bw.close();
    }


}
