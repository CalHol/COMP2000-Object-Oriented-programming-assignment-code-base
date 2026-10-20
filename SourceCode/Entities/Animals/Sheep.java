

public class Sheep implements Animal {
    
    int x;
    int y;
    String colour;

    public Sheep(int x, int y, String colour){
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    public void move (int x, int y){
        this.x = x;
        this.y = y;
    }

    public String getColour(){
        return this.colour;
    }

    @Override 
    public void update() {

    }
}