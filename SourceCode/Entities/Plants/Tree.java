

public class Tree implements Plant {
    public int grow;
    public int x; 
    public int y;

    public int size;
    private int lifeTime;
    public List<>

    //tree cosntructor, lifetime is not ment to be accessed and will not change
    Tree (int grow, int x, int, y, int size, int lifetime){
        this.grow = grow;
        this.x = x;
        this.y = y;
        this.size = 10;
        this.lifetime = 50;
    }

    
    public expand (int grow) {
        this.size += grow;
    }
}