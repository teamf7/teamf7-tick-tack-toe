package board;

import exception.GameNotSetValueException;
import game.Player;
import game.Step;

/**
 * Created by admin on 16.10.2016.
 */
public class GameField  implements IGameField{
    private int n;
    private Square[][] fields;
    private int filled = 0,
            squareCount=0;

    public GameField(int n){
        this.n = n;
        initialization();
    }

    private void initialization() {
        fields = new Square[n][n];
        for (int i =0; i < n; i++){
            for (int j = 0;j < n; j++){
                fields[i][j] = new Square();
                squareCount++;
            }
        }
    }

    @Override
    public int getN() {
        return n;
    }

    @Override
    public void setValue(Step step) throws GameNotSetValueException{
        int x = step.getX(),
            y = step.getY();
        if(fields[x][y].isFilled()) throw  new  GameNotSetValueException();
        fields[x][y].fill(step.getPlayer());
        filled++;

    }

    public Square[][] getFields(){
       return fields;
    }

    @Override
    public Player getValue(int x, int y) {
        return fields[x][y].getPlayer();
    }

    @Override
    public boolean isFileldFilled() {
        return filled == squareCount;
    }

    @Override
    public int getFileld() {
        return filled;
    }

    public void cleanPlayer(int x, int y){
        filled--;
        fields[x][y].fill(null);
    }

    public void resetBoard() {
        for(int i = 0, len = fields.length; i < len; i++){
            for(int j = 0, len2 = fields[0].length; j < len2; j++){
                cleanPlayer(i,j);
            }
        }
    }
}
