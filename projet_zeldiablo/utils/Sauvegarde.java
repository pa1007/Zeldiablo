package utils;

import jeu.Labyrinthe;
import jeu.cases.Case;
import jeu.cases.Entree;
import jeu.cases.Piege;
import jeu.cases.Sortie;
import jeu.monstre.Monstre;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sauvegarde {

    private static final String PATH = "SaveLaby.txt";

    public static void save(Labyrinthe l) throws IOException {
        StringBuilder sb    = new StringBuilder();
        int           lastY = 0;
        Place         p     = new Place(0, 0);
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

    public static List<Case> charger() {
        return charger(PATH);
    }

    public static List<Case> charger(String path) {
        List<Case>     cases = new ArrayList<>();
        File           f     = new File(path);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(f));
        }
        catch (FileNotFoundException e) {
            return cases;
        }
        var ref = new Object() {
            int y = 0;
        };
        br.lines().forEach((line) -> {
            int      x  = 0;
            String[] sp = line.replace("/", "").split("-");
            for (String ca : sp) {
                Case c = new Case(ref.y, x);
                if (ca.equals("M")) {
                    c.setMur(true);
                }
                else if (ca.equals("P")) {
                    c = new Piege(new Place(ref.y, x));
                }
                else if (ca.equals("E")) {
                    c = new Entree(ref.y, x);
                }
                else if (ca.equals("S")) {
                    c = new Sortie(new Place(ref.y, x));
                }
                cases.add(c);
                x++;
                if (x > 20) {
                    x = 0;
                }
            }
            ref.y = ref.y + 1;
        });
        return cases;
    }

}
