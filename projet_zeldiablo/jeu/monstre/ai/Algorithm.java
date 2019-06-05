package jeu.monstre.ai;

import jeu.Labyrinthe;
import jeu.cases.Case;
import utils.Place;
import java.util.*;

public class Algorithm {


    /**
     * Permet de stoquer une place avec une numeration donnée par l'algorithme
     */
    private Map<Place, Integer> temp;

    /**
     * L'index ou se trouve le joueur rechercher
     */
    private int outIndex;

    /**
     * Listes de toutes les places
     */
    private List<Place> workingList;

    /**
     * Le labyrinthe qui correspond a l'algo/monstre
     */
    private Labyrinthe labyrinthe;

    /**
     * Permet de cree un alogrithm
     *
     * @param l le labyrinthe de l'algo
     */
    public Algorithm(Labyrinthe l) {
        this.labyrinthe = l;
        temp = new HashMap<>();
        workingList = new ArrayList<>();
        l.getCases().forEach(a -> workingList.add(a.getPlace()));
    }

    /**
     * l'algorithme de Lee <a href="https://en.wikipedia.org/wiki/Lee_algorithm">https://en.wikipedia.org/wiki/Lee_algorithm </a> qui se fais  par expension<br>
     * On commence par une place déterminier on lui attribut la valeur de 0, on regarde les voisins, on leur attribut une valeur 1 si ils ne sont pas des murs
     * ou occuper par un monstre puis on continue ce cheminement en augementant la valeur par le nombre d'itération fais <br>
     *
     * @param start       la place de départ
     * @param destination la place d'arriver
     * @return <ul>
     * <li>true : l'algorithme a trouvé un chemin </li>
     * <li>false : l'algorithme a trouvé un chemin</li>
     * </ul>
     * <img src="https://upload.wikimedia.org/wikipedia/commons/5/5a/Lee_waveprop.png" alt="Image tirée du wikipédia">
     * @see <a href="https://en.wikipedia.org/wiki/Lee_algorithm">https://en.wikipedia.org/wiki/Lee_algorithm </a>
     */
    public boolean leeAlgorithm(Place start, Place destination) {
        int         nb             = 1;
        List<Place> directNeibourg = start.getNext();
        List<Place> passedNeibourg = new ArrayList<>();
        boolean     found          = false;
        while (!found) {
            if (directNeibourg.isEmpty()) {
                break;
            }
            for (Place m : directNeibourg) {
                Case s;
                int  x = 0;
                try {
                    x = workingList.indexOf(m);
                }
                catch (Exception ignored) {
                }
                if (x != -1) {
                    s = labyrinthe.rechercherCase(m);
                    if (s.getPlace().equals(destination)) {
                        outIndex = x;
                        found = true;
                        break;
                    }
                    else if (s.isVide() && !contains(m)) {
                        temp.put(m, nb);
                        passedNeibourg.add(m);
                    }
                }
            }
            if (!found) {
                nb++;
                directNeibourg.clear();
                for (Place t : passedNeibourg) {
                    for (Place nex : t.getNext()) {
                        if (!directNeibourg.contains(nex)) {
                            directNeibourg.add(nex);
                        }
                    }
                }
                passedNeibourg.clear();
            }
        }
        if (!found) {
            temp.clear();
        }
        return found;
    }

    /**
     * @return la liste des action a faire en partant de la plus proche
     */
    public List<Place> backTracking() {
        List<Place> res            = new ArrayList<>();
        List<Place> directNeibourg = workingList.get(outIndex).getNext();
        List<Place> passedNeibourg = new ArrayList<>();
        boolean     found          = false;
        int         max            = Integer.MAX_VALUE;
        while (!found) {
            if (directNeibourg.isEmpty()) {
                break;
            }
            for (Place m : directNeibourg) {
                int x = 0;
                try {
                    x = workingList.indexOf(m);
                }
                catch (Exception ignored) {
                    //L'exception est causé car les casses ne sont pas valide, (Nombre négative ou sup a 20) dans touts les cas c'est cases
                    //ne sont pas sur notre chemin
                }
                if (x != -1) {
                    if (contains(m)) {
                        int c = getFromTemp(m);
                        if (c < max) {
                            max = c;
                            passedNeibourg.clear();
                            passedNeibourg.add(m);
                            res.add(m);
                        }
                        if (c == 0) {
                            res.add(m);
                            found = true;
                            break;

                        }
                    }
                }
            }
            directNeibourg.clear();
            for (Place t : passedNeibourg) {
                directNeibourg.addAll(t.getNext());
            }
            passedNeibourg.clear();
        }
        temp.clear();
        outIndex = 0;
        Collections.reverse(res);
        return res;
    }

    /**
     * Permet d'avoir l'index de début dans la list
     *
     * @param destination la place rechercher
     * @return la position de l'index de début, -1 si pas trouvé
     */
    public int getStartIndex(Place destination) {
        int i = 0;
        for (Place p : workingList) {
            Case c = labyrinthe.rechercherCase(p);
            if (c.isOccupe() && !c.getPlace().equals(destination)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * permet d'avoir le resultat d'une place depuis la sauvegarde
     *
     * @param m la place rechercher
     * @return la valeur attribuer a la place, -1 si pas trouve
     */
    private int getFromTemp(Place m) {
        for (Place p : temp.keySet()) {
            if (p.equals(m)) {
                return temp.get(p);
            }
        }
        return -1;
    }

    /**
     * Permet de savoir si la place est dans la Map
     *
     * @param m la place rechercher
     * @return true si elle est presente, false sinon
     */
    private boolean contains(Place m) {
        for (Place p : temp.keySet()) {
            if (p.equals(m)) {
                return true;
            }
        }
        return false;
    }


}
