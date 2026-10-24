
public abstract class Animal extends Entity {
    protected int lifeTime;

    public Animal(int x, int y, int lifeTime) {
        super(x, y);
        this.lifeTime = lifeTime;
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