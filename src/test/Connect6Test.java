package test;

import exception.GameException;
import game.Step;
import games.Connect6;
import org.junit.Test;

/**
 * Created by admin on 16.10.2016.
 */
public class Connect6Test {
    Connect6 connect6;
    public Connect6Test(){
        connect6 = new Connect6();
    }

    @Test
    public void createTwoGame() throws GameException {
        System.out.println("two game");
        int[][] g = new int[6][6];

        for(int i = 0; i < g.length; i++){
            for(int j = 0; j< g.length; j++){
                g[i][j] = i+j;
            }
        }
        for(int i = 0; i < g.length; i++){
            for(int j = 0; j< g.length; j++){
                System.out.print(g[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("----");


        int height = g.length;
        for(int k = height-1; k > 0; k--){
            for (int i = 0; i < height-k; i++){
                System.out.print(g[i][i+k]+" ");
            } System.out.println();
        }
/*
        int x =0;
        int y =10;
        int n = g.length;
        for(int k = 0; k < n; k++){
            y = k;
            x=1;
            while (y < 0){
                System.out.print(g[x][y] +" ");
                x++;
                y--;

            }
            System.out.println("");
        }
        System.out.println("-------------");

/*
        for(int k = 1; k < n; k++) {
            int x=n-1;
            int y = k;
                while (y < n){
                    System.out.print(g[x][y] + "; ");
                    x--;
                    y++;

                } System.out.println("");
        }/*
        System.out.println("-----------");
        for(int k = 1; k < n; k++) { int x = n-1, y = k;
            while (y < n){
                System.out.print(g[x][y] + "; ");
                x--;
                y++;

            } System.out.println("");
        }
        /*connect6.start();
        //connect6.print();
        connect6.makeStep(new Step(0,0));
        connect6.makeStep(new Step(5,5));
        connect6.makeStep(new Step(5,6));
        connect6.makeStep(new Step(0,5));
        connect6.makeStep(new Step(0,3));
        connect6.makeStep(new Step(5,3));
        connect6.makeStep(new Step(5,4));
        connect6.makeStep(new Step(0,1));
        connect6.makeStep(new Step(0,2));
        connect6.makeStep(new Step(5,7));
        connect6.makeStep(new Step(5,8));
        connect6.makeStep(new Step(0,4));
        connect6.makeStep(new Step(0,6));
        connect6.makeStep(new Step(5,9));

        connect6.print();*/
    }
}

