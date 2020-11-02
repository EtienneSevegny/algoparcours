package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    @Test
    void test(){
        Graph graph = new Graph();
        AlgoLargeur algo = new AlgoLargeur(graph);
        algo.Largeur();
    }
}