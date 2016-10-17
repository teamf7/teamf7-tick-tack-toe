package game;

/**
 * Created by admin on 16.10.2016.
 */
public class Step {
    private int x,y;
    private Player player = null;

    public Step(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String toString(){
        return "X: "+x + " Y: " +y+ " Player: "+ player;
    }

    public boolean equals(Object other)
    {
        if (x == ((Step) other).getX() && y ==((Step) other).getY()) return true;
        return this.player == ((Step) other).getPlayer();
    }
    public int hashCode()
    {
        return 76+133*x+y*133;
    }
}
