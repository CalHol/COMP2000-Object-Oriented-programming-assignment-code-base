

public class Sheep implements Animal {
    
    int x;
    int y;

    public Sheep(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move (int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override 
    public void update() {

    }
}