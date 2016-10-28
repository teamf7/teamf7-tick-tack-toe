package board;

import exception.GameNotSetStepException;
import game.Step;

/**
 * Created by admin on 16.10.2016.
 *
 */
public class GameField  implements IGameField, Cloneable{
    private int n;
    private int fields[][];
    private int filled = 0,
            squareCount=0;

    public GameField(int n){
        this.n = n;
        initialization();
    }

    private void initialization() {
        fields = new int[n][n];
        squareCount= n*n;
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public void setStep(Step step) throws GameNotSetStepException {
        int x = step.getX(),
            y = step.getY();
        if(fields[x][y] != 0) throw  new GameNotSetStepException();
        fields[x][y] = step.getField();
        filled++;
    }

    public int[][] getFields(){
       return fields;
    }

    @Override
    public int getValue(int x, int y) {
        return fields[x][y];
    }

    @Override
    public boolean isFileldFilled() {
        return filled == squareCount;
    }

    @Override
    public int getFileld() {
        return filled;
    }

    public void cleanField(int x, int y){
        filled=0;
        fields[x][y] = 0;
    }

    public void resetBoard() {
        for(int i = 0, len = fields.length; i < len; i++){
            for(int j = 0, len2 = fields[0].length; j < len2; j++){
                cleanField(i,j);
            }
        }
    }

    public void print(){
        char view;
        for(int i = 0, len = n; i < len; i++){
            for (int l =0; l < len; l++){
                System.out.print("___");
            } System.out.println();
            for(int j = 0; j< len; j++){
                if(fields[i][j] == 0) view = ' ';
                else view = getaChar(i, j);
                System.out.print(view + "| ");
            } System.out.println();
        }
    }

    private char getaChar(int i, int j) {
        return fields[i][j] == 1 ? 'X' : 'O';
    }

    @Override
    public int hashCode() {
        final int prime = n;
        int result = 1;
        for(int i = 0; i < n;i++){
            for (int j = 0; j< n; j++){
                result = prime * result + getValue(i,j);
            }
        }
        return result;
    }
}
