package game;

import exception.GameException;
import exception.GameOverException;

public abstract class TwoPlayersGame extends Game {
    private Player players[];
    private Player activePlayer;

    public TwoPlayersGame(int n) {
        super(n);
        players = new Player[2];
    }
    public TwoPlayersGame(int n, int successFilled) {
        super(n,successFilled);
        players = new Player[2];
    }

    public Player getCurrentActivePlayer(){
        return activePlayer;
    }

    @Override
    public boolean makeStep(Step step) throws GameException {
        step.setPlayer(getCurrentActivePlayer());
            return super.makeStep(step);
    }

    public void resetPlayers()  throws GameOverException {
        players[0] = new Player("Ainur");
        players[1] = new Player("Oleg");
        setCurrentActivePlayer(players[0]);
    }

    @Override
    public void switchPlayers()  throws GameOverException {
        setCurrentActivePlayer((activePlayer ==players[0]) ? players[1] : players[0]);
    }

    @Override
    public String gameOver(Player player) {
        return "Игру выйграл "+player.getName();
    }

    @Override
    public String gameOver() {
        return "Ничья";
    }

    private void setCurrentActivePlayer(Player player) throws GameOverException {
        if(getPrevPlayer() == player) throw new GameOverException("2 хода за 1го игрока");
        activePlayer = player;
    }

    @Override
    public boolean definePlayer(Player player) {
      return players[0] == player;
    }
}
