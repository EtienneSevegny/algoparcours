package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import java.util.ArrayList;
import java.util.LinkedList;

public class AlgoLargeur {
    private Graph graph;
    private LinkedList<Integer> chemin;

    public AlgoLargeur(Graph graph) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        this.graph = graph;
        chemin = new LinkedList<>();
    }

    public LinkedList<Integer> Profondeur() {
        for (Integer i = 0; i < graph.getGraph().size(); i++) {
            if (graph.getGraph().get(i).size() != 0) {
                if (!chemin.contains(i)) {
                    Visite(i);
                }
            }
        }
        return chemin;
    }

    public LinkedList<Integer> Largeur() {
        LinkedList<Integer> file = new LinkedList<>();
        file.add(0);
        chemin.add(0);
        while (file.size() != 0) {
            Integer noeud = file.remove();
            for (Integer[] voisin : graph.getGraph().get(noeud)) {
                if (!chemin.contains(voisin[0])) {
                    file.add(voisin[0]);
                    chemin.add(voisin[0]);
                }
            }
        }
        return chemin;
    }

    public LinkedList<Integer> Dijkstra() {
        int[] tableauValeur = new int[graph.getGraph().size()];
        LinkedList<Integer> marque = new LinkedList<>();
        for (int i = 0; i < graph.getGraph().size(); i++) {
            tableauValeur[i] = 10000;
        }
        tableauValeur[0] = 0;
        DijkstraRecursif(0, tableauValeur, marque);
        int[][] tableauDeChemin = new int[25][];
        cheminPlusCours(0, tableauValeur);
        return chemin;
    }

    private boolean DijkstraRecursif(int noeud, int[] tableau, LinkedList<Integer> marque) {
        for (Integer[] voisin : graph.getGraph().get(noeud)) {
            if (tableau[voisin[0]] == 10000) {
                int valeur = tableau[noeud] + voisin[1];
                if (tableau[voisin[0]] > valeur) {
                    tableau[voisin[0]] = valeur;
                }
            }
        }
        marque.add(noeud);
        int noeudPlusPetit = 0;
        int voisinNM = 0;
        for (Integer[] voisin : graph.getGraph().get(noeud)) {
            if (!marque.contains(voisin[0])) {
                if (noeudPlusPetit == 0) {
                    noeudPlusPetit = voisin[0];
                } else {
                    if (tableau[noeudPlusPetit] > tableau[voisin[0]]) {
                        noeudPlusPetit = voisin[0];
                    }
                }
                voisinNM++;
            }
        }
        if (voisinNM != 0) {
            DijkstraRecursif(noeudPlusPetit, tableau, marque);
        }
        return true;
    }

    private boolean cheminPlusCours(Integer noeud, int[] valeur) {
        chemin.add(noeud);
        if (noeud != 21) {
            int noeudPlusPetit = 0;
            for (Integer[] voisin : graph.getGraph().get(noeud)) {
                if (!chemin.contains(voisin[0])) {
                    if (noeudPlusPetit == 0) {
                        noeudPlusPetit = voisin[0];
                    }
                    if (valeur[noeudPlusPetit] > valeur[voisin[0]]) {
                        noeudPlusPetit = voisin[0];
                    }
                }
            }
            cheminPlusCours(noeudPlusPetit, valeur);
        }
        return true;
    }

    private void Visite(Integer noeud) {
        chemin.add(noeud);
        for (Integer[] voisin : graph.getGraph().get(noeud)) {
            if (!chemin.contains(voisin[0])) {
                Visite(voisin[0]);
            }
        }
    }
}
