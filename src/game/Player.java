package game;

/**
 * Created by admin on 16.10.2016.
 */
public class Player {
    private String name = null;
    public Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public String toString(){
        return name;
    }
}
