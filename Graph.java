package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

public class Graph {
    private Node premierNoeud;

    public Graph(Node premierNoeud) {
        if(premierNoeud == null){
            throw new IllegalArgumentException();
        }
        this.premierNoeud = premierNoeud;
    }
    public Node getPremierNoeud() {
        return premierNoeud;
    }



}
