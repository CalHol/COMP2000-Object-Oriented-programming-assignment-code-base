
import java.awt.Color;

public class Sheep extends Animal {
    public Sheep(int x, int y, int lifeTime) {
        super(x, y, lifeTime);
    }

    @Override
    public void update() {
        lifeTime--;
    }

    @Override
    public Color getColor() {
        return new Color(230, 230, 230);
    }
}