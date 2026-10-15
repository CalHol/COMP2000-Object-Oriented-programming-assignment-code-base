

public class Sheep implements Animal {
    
    int x;
    int y;
    int lifeTime;

    public Sheep(int x, int y, int lifeTime){
        this.x = x;
        this.y = y;
        this.lifeTime = lifeTime;
    }

    public void move (int x, int y){
        this.x = x;
        this.y = y;
    }


}