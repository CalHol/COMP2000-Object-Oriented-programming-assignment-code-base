
public abstract class Animal extends Entity {
    protected int lifeTime = 0;

    public Animal(int x, int y) {
        super(x, y);
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public abstract void update();
}