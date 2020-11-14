package ca.cegepvicto.techinfo.a2019.p3.da1737508.algoparcours;

import ca.cegepvicto.techinfo.a2019.p3.da1737508.examens.examenfinal.ArgumentOutOfRangeException;

import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFrame;

public class Labyrinthe extends Canvas {
    public static void main(String[] args) {
        Scanner numero = new Scanner( System.in );
        System.out.println( "Veuillez entrer un numéro correspondant à un type de parcours." );
        System.out.println( "0: Largeur" );
        System.out.println( "1: Profondeur" );
        System.out.println( "2: Dijkstra" );
        int choix = numero.nextInt();
        System.out.println( "Le programme graphique est maintenant ouvert." );
        JFrame frame = new JFrame("My Drawing");
        Canvas canvas = new Labyrinthe(choix);
        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }
    private int choix;
    public Labyrinthe(int choix) {
        if(choix>2){
            throw new IllegalArgumentException("Choisisser un chiffre entre 0 et 2.");
        }
        this.choix = choix;
    }
    public void paint(Graphics g) {
        Graph graph = new Graph();
        AlgoLargeur algoLargeur = new AlgoLargeur(graph);
        int traverse = 0;
        Graphics2D[] tab = new Graphics2D[25];
        LinkedList<Integer> algo;
        if(choix ==0){
            algo = algoLargeur.Largeur();
        }else if(choix == 1){
            algo = algoLargeur.Profondeur();
        }
        else {
            algo =algoLargeur.Dijkstra();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                tab[traverse] = (Graphics2D) (g);
                if (traverse == 0) {
                    tab[traverse].setColor(Color.green);
                }
                else if(traverse==21){
                    tab[traverse].setColor(Color.red);
                }
                else if (graph.getGraph().get(traverse).size() != 0) {
                    tab[traverse].setColor(Color.white);
                } else {
                    tab[traverse].setColor(Color.darkGray);
                }
                tab[traverse].fillRect(70 * i, 70 * j, 70, 70);
                traverse++;
            }
        }
        int size = algo.size();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i<size;i++){
                int check = 0;
                for(int j = 0; j<5;j++){
                    for(int k = 0; k<5;k++){
                        if(check == algo.getFirst()){
                            g.setColor(Color.cyan);
                            g.fillRect(70*j, 70*k, 70, 70);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        check++;
                    }
                }
                algo.remove();
        }
    }
}
