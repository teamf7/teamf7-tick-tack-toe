package board;

import exception.GameNotSetValueException;
import game.Step;

/**
 * Created by admin on 16.10.2016.
 *
 */
public class GameField  implements IGameField{
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
    public void setValue(Step step) throws GameNotSetValueException{
        int x = step.getX(),
            y = step.getY();
        if(fields[x][y] != 0) throw  new  GameNotSetValueException();
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
        filled--;
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

}
