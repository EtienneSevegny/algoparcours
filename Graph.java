package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private ArrayList<ArrayList<Integer>> graph;

    public Graph() {
        int nbDeNoeud = 7;
        graph = new ArrayList<>(nbDeNoeud);
        for(int i =0 ; i<nbDeNoeud;i++){
            graph.add(new ArrayList<>());
        }
        AjoutArrete(0,1);
        AjoutArrete(0,2);
        AjoutArrete(1,3);
        AjoutArrete(1,4);
        AjoutArrete(3,5);
        AjoutArrete(5,1);
        AjoutArrete(2,6);
        AjoutArrete(4,6);
        AjoutArrete(2,4);
    }
    public void AjoutArrete(int a, int b){
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
    public ArrayList<ArrayList<Integer>> getGraph() {
        return graph;
    }



}
