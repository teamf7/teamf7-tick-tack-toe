package game;

import board.GameField;
import exception.GameException;
import exception.GameOverException;
import winnerChecker.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public abstract class Game implements IGame, DisplayElement, ITwoPlayersGame {
    private GameField gameField;
    private List<Step> history;
    private List<WinnerCheckerInterface> winnerCheckers;
    private boolean started;

    public Game(int n){
        gameField = new GameField(n);
        history = new LinkedList<>();
        initialization();
    }

    public void initialization() {
        started = false;
        winnerCheckers = new ArrayList<WinnerCheckerInterface>();
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


    @Override
    public void getWinner() throws GameException {
        int player = checkWinner();
        if(player != 0){
            gameOver(player);
            started = false;
        }
        if(isFileldFilled()){
            gameOver();
            started = false;
        }
    }

    public void start() throws GameException {
        resetPlayers();
        started = true;
    }
    @Override
    public final int checkWinner(){
        for(WinnerCheckerInterface winCheck: winnerCheckers){
            int winner = winCheck.checkWinner();
            if(winner != 0){
                return winner;
            }
        }
        return 0;
    }

    public List<WinnerCheckerInterface> getWinnerCheckers(){
        return winnerCheckers;
    }
    public GameField getGameField(){
        return gameField;
    }

    public boolean undoStep(int k) throws GameOverException{
        if(k > gameField.getFileld()) return false;
        for (int i=history.size()-1, len = history.size()- k-1; i > len; i--){
            Step step = (Step) history.get(i);
            gameField.cleanField(step.getX(), step.getY());
            switchPlayers();
            history.remove(i);
        }
        return true;
    }
    public int getPrevPlayer(){
        int size = gameField.getFileld();
        if(size == 0) return 0;
        return history.get(size-1).getField();
    }

    public boolean isFileldFilled() {
        return gameField.isFileldFilled();
    }
    public void print(){
        gameField.print();
    }
}

