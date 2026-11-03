
public abstract class Animal extends Entity {
    protected int lifeTime = 0;
    private int eatCount;

    public Animal(int x, int y) {
        super(x, y);
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public void resetLifeTime() {
        lifeTime = 0;
    }

    public int getMaximumLifetime() {
        return 50;
    }

    public int getEatCount() {
        return eatCount;
    }

    public void incrementEatCount() {
        eatCount++;
    }

    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    public abstract void update();
}