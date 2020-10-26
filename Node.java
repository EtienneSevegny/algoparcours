package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import java.util.LinkedList;

public class Node {
    private Boolean marque;
    private LinkedList<Node> noeudEnfants;
    private char lettre;

    public Node(char lettre) {
        if(lettre == ' '){
            throw new IllegalArgumentException("Tu ne peux pas mettre de champ vide.");
        }
        this.lettre = lettre;
        this.noeudEnfants = new LinkedList<>();
        this.marque = false;
    }

    public void EntrerNoeudEnfant(Node nouvelEnfant){
        if(nouvelEnfant == null) {
            throw new IllegalArgumentException("Le noeud est null.");
        }
        noeudEnfants.add(nouvelEnfant);
    }

}
