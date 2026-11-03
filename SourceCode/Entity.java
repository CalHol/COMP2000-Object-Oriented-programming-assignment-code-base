import java.awt.Color;

public class Entity {
    protected int x;
    protected int y;
    private int age;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return getClass().getSimpleName();
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age++;
    }

    public Color getColor() {
        return Color.GRAY;
    }
}
