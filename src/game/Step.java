package game;

/**
 * Created by admin on 16.10.2016.
 */
public class Step {
    private int x,y;
    private int field = 0;

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

    public int getField() {//ge t the value of a field
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public String toString(){
        return "X: "+x + " Y: " +y+ " Field: "+ field;
    }

    public boolean equals(Object other)
    {
        if (x == ((Step) other).getX() && y ==((Step) other).getY()) return true;
        return this.field == ((Step) other).getField();
    }
    public int hashCode()
    {
        return 76+133*x+y*133;
    }
}
