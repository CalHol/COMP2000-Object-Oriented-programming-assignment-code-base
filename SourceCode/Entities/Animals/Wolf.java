
import java.awt.Color;

public class Wolf extends Animal {
    public Wolf(int x, int y) {
        super(x, y);
    }

    @Override
    public void update() {
        lifeTime++;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}