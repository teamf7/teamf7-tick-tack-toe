package game;

import board.GameField;
import board.Square;
import exception.GameException;
import exception.GameOverException;
import winnerChecker.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public abstract class Game implements IGame {
    private GameField gameField;
    private List history;
    private List<WinnerCheckerInterface> winnerCheckers;
    private boolean started;

    public Game(int n){
        gameField = new GameField(n);
        history = new LinkedList<>();
        initialization(0);
    }
    public Game(int n, int successFilled){
        gameField = new GameField(n);
        history = new LinkedList<>();
        initialization(successFilled);
    }



    public void initialization(int successFilled) {
        started = false;
        winnerCheckers = new ArrayList<WinnerCheckerInterface>();
            winnerCheckers.add(new WinnerCheckerHorizontal(gameField,successFilled));
            winnerCheckers.add(new WinnerCheckerVertical(gameField, successFilled));
            winnerCheckers.add(new WinnerCheckerDiagonalLeft(gameField, successFilled));
            winnerCheckers.add(new WinnerCheckerDiagonalRight(gameField, successFilled));
    }

    public boolean makeStep(Step step) throws GameException {
        if(started != true) return false;
        history.add(step);
        gameField.setValue(step);
        switchPlayers();
        getWinner();
        return true;
    }

    public List getHistory(){
        return history;
    }

    public void print(){
        Square[][] gameFields = gameField.getFields();
        char view;
        for(int i = 0,len = gameField.getN();i< len; i++){
            for (int l =0; l< len; l++){
                System.out.print("___");
            } System.out.println();
            for(int j = 0; j< len; j++){
                if(gameFields[i][j].getPlayer() == null) view = ' ';
                else view =  definePlayer(gameFields[i][j].getPlayer())? 'X' : 'O';
                System.out.print(view + "| ");
            } System.out.println();
        }
    }

    @Override
    public void getWinner() throws GameException {
        Player player = checkWinner();
        if(player != null){
            gameOver(player);
        }
        if(isFileldFilled()){
            gameOver();
        }
    }

    public void start() throws GameException {
        resetPlayers();
        started = true;
    }

    public Player checkWinner(){
        for(WinnerCheckerInterface winCheck: winnerCheckers){
            Player winner = winCheck.checkWinner();
            if(winner != null){
                return winner;
            }
        }
        return null;
    }

    public List getWinnerCheckers(){
        return winnerCheckers;
    }
    public GameField getGameField(){
        return gameField;
    }

    public boolean undoStep(int k) throws GameOverException{
        if(k > gameField.getFileld()) return false;
        for (int i=history.size()-1, len = history.size()- k-1; i > len; i--){
            Step step = (Step) history.get(i);
            gameField.cleanPlayer(step.getX(), step.getY());
            switchPlayers();
            history.remove(i);
        }
        return true;
    }
    public Player getPrevPlayer(){
        int size = gameField.getFileld();
        if(size == 0) return null;
        return ((Step)history.get(size-1)).getPlayer();
    }

    public boolean isFileldFilled() {
        return gameField.isFileldFilled();
    }
}

