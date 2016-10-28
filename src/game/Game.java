package game;

import board.GameField;
import exception.GameException;
import exception.GameNotSetStepException;
import exception.GameOverException;
import exception.GameUndoStepException;
import winnerChecker.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public abstract class Game implements IGame, DisplayElement, ITwoPlayersGame, IGameEnd {
    private GameField gameField;
    private LinkedList<Step> history;
    private List<WinnerCheckerInterface> winnerCheckers;
    private boolean finished;

    public Game(int n){
        gameField = new GameField(n);
        history = new LinkedList<>();
        finished = false;
        initialization();
    }

    public void initialization() {
        winnerCheckers = new ArrayList<WinnerCheckerInterface>();
    }

    public boolean makeStep(Step step) throws GameException {
        hasStarted();
            addStep(step);
            switchPlayers();
            getWinner();
        return true;
    }

    private boolean hasStarted() throws GameOverException{
        if(finished) throw new GameOverException("Игра Закончена");
        return true;
    }
    private void addStep(Step s) throws GameNotSetStepException {
        history.add(s);
        gameField.setStep(s);
    }

    public List getHistory(){
        return history;
    }


    @Override
    public void getWinner() throws GameException {
        int player = checkWinner();
        if(player != 0){
            gameOver(player);
            finished = true;
        }
        if(isFieldFilled()){
            gameOver();
            finished = true;
        }
    }

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

    @Override
    public boolean undoStep(int k) throws GameOverException, GameNotSetStepException, GameUndoStepException {
        hasRemoveNextStep(k);
            resetFields();
            removeLastHistory(k);
            for(int i = 0, len = history.size(); i < len; i++){
                Step step = history.get(i);
                gameField.setStep(step);
                switchPlayers();
            }
        return true;
    }

    private boolean hasRemoveNextStep(int k) throws GameUndoStepException {
        if(k > gameField.getFileld()) throw new GameUndoStepException();
        return true;
    }

    private void resetFields(){
        gameField.resetBoard();
    }

    private void removeLastHistory(int k){
        for(int i = 0; i < k;i++){
             history.removeLast();
        }
    }

    public int getPrevPlayer(){
        int size = gameField.getFileld();
        if(size == 0) return 0;
        return history.get(size-1).getField();
    }

    public boolean isFieldFilled() {
        return gameField.isFileldFilled();
    }
    public void print(){
        gameField.print();
    }
}

