package board;

import game.Player;

/**
 * Created by admin on 16.10.2016.
 */
public class Square{
    private Player player = null;


    public void fill(Player player){
        this.player = player;
    }
    public boolean isFilled(){
         return player != null ? true : false;
    }
    public Player getPlayer(){
        return player;
    }
}

