package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    private ArrayList<ArrayList<Integer[]>> graph;
    public Graph() {
        int nbDeNoeud = 25;
        graph = new ArrayList<>(nbDeNoeud);
        for(int i = 0 ; i<nbDeNoeud;i++){
            graph.add(new ArrayList<>());
        }
        AjoutArrete(0,1,2);
        AjoutArrete(1,2,6);
        AjoutArrete(2,3,3);
        AjoutArrete(2,7,6);
        AjoutArrete(3,4,9);
        AjoutArrete(4,9,2);
        AjoutArrete(7,12,10);
        AjoutArrete(9,14,3);
        AjoutArrete(10,15,6);
        AjoutArrete(10,11,8);
        AjoutArrete(11,12,2);
        AjoutArrete(12,13,5);
        AjoutArrete(13,14,8);
        AjoutArrete(14,19,2);
        AjoutArrete(15,20,7);
        AjoutArrete(19,24,1);
        AjoutArrete(20,21,5);
        AjoutArrete(21,22,2);
        AjoutArrete(22,23,8);
        AjoutArrete(23,24,10);

    }
    public void AjoutArrete(int a, int b,int value){
        Integer[] tab = new Integer[2];
        tab[0]=b;
        tab[1]=value;
        graph.get(a).add(tab);
        Integer[] tab2 = new Integer[2];
        tab2[0]=a;
        tab2[1]=value;
        graph.get(b).add(tab2);
    }
    public ArrayList<ArrayList<Integer[]>> getGraph() {
        return graph;
    }



}
