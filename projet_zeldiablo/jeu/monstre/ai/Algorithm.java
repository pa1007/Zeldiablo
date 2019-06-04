package jeu.monstre.ai;

import jeu.Labyrinthe;
import jeu.cases.Case;
import utils.Place;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {


    private Map<Place, Integer> temp;

    private int outIndex;

    private List<Place> workingList;

    private Labyrinthe labyrinthe;

    public Algorithm(Labyrinthe l) {
        this.labyrinthe = l;
        temp = new HashMap<>();
        workingList = new ArrayList<>();
        l.getCases().forEach((a) -> workingList.add(a.getPlace()));

        int i = 0;

    }

    public boolean leeAlgorithm(Place c) {
        int         nb             = 1;
        List<Place> directNeibourg = c.getNext();
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
                    if (s.getPlace().equals(c)) {
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

    public List<Place> backTracking() {
        List<Place> res            = new ArrayList<>();
        List<Place> directNeibourg = workingList.get(outIndex).getNext();
        List<Place> passedNeibourg = new ArrayList<>();
        boolean     found          = false;
        int         max            = Integer.MAX_VALUE;
        while (!found) {
            Case s;
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
        return res;
    }

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

    private int getFromTemp(Place m) {
        for (Place p : temp.keySet()) {
            if (p.equals(m)) {
                return temp.get(p);
            }
        }
        return -1;
    }

    private boolean contains(Place m) {
        for (Place p : temp.keySet()) {
            if (p.equals(m)) {
                return true;
            }
        }
        return false;
    }


}
