package game;

import exception.GameException;
import exception.GameOverException;

public abstract class TwoPlayersGame extends Game{
    private Player players[];
    private int activePlayer;
    private int playerId[];

    public TwoPlayersGame(int n) {
        super(n);
    }
    @Override
    public void initialization() {
        super.initialization();
        players = new Player[2];
        playerId = new int[2];
        playerId[0] = -1;
        playerId[1] = 1;
    }
    public void start() throws GameException {
        resetPlayers();
    }
    public int getCurrentActivePlayer(){
        return activePlayer;
    }

    @Override
    public boolean makeStep(Step step) throws GameException {
        step.setField(getCurrentActivePlayer());
            return super.makeStep(step);
    }

    public void resetPlayers()  throws GameOverException {
        players[0] = new Player("Ainur");
        players[1] = new Player("Oleg");
        setCurrentActivePlayer(playerId[0]);
    }

    @Override
    public void switchPlayers()  throws GameOverException {
        setCurrentActivePlayer((activePlayer == playerId[0]) ? playerId[1] : playerId[0]);
    }

    public void gameOver(int playerId) {
        System.out.println("Игру выйграл "+getWinnerName(playerId));
    }

    public String getWinnerName(int playerId){
        Player player = playerId == -1 ? players[0] : players[1];
        return player.getName();
    }

    public void gameOver() {
        System.out.println("Ничья");
    }

    private void setCurrentActivePlayer(int player) throws GameOverException {
        if(getPrevPlayer() == player) throw new GameOverException("2 хода за 1го игрока");
        activePlayer = player;
    }

}
