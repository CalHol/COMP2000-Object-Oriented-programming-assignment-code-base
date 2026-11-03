
import java.awt.Color;

public class Sheep extends Animal {
    public Sheep(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        lifeTime++;
    }

    @Override
    public Color getColor() {
        return new Color(32, 32, 32);
    }
}