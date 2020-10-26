package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import java.util.LinkedList;

public class AlgoLargeur {
    private Graph graph;
    private LinkedList<String> chemin;

    public AlgoLargeur(Graph graph) {
        if(graph == null){
            throw new IllegalArgumentException();
        }
        this.graph = graph;
    }

    public LinkedList<String> Algo(){
        return chemin;
    }
}
