package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

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
        for(Integer i =0;i<graph.getGraph().size();i++){
            if(!chemin.contains(i)){
                Visite(i);
            }
        }
        return chemin;
    }
    public LinkedList<Integer> Largeur(){
        LinkedList<Integer> file = new LinkedList<>();
        file.add(0);
        chemin.add(0);
        while(file.size()!=0){
            Integer noeud = file.remove();
            for (Integer voisin:graph.getGraph().get(noeud)) {
                if(!chemin.contains(voisin)){
                    file.add(voisin);
                    chemin.add(voisin);
                }
            }
        }
        return chemin;
    }
    private void Visite(Integer noeud) {
        chemin.add(noeud);
        for (Integer voisin : graph.getGraph().get(noeud)) {
            if(!chemin.contains(voisin)){
                Visite(voisin);
            }
        }
    }
}
