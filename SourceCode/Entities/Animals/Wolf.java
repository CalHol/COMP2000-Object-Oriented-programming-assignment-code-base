
import java.awt.Color;

public class Wolf extends Animal {
    public Wolf(int x, int y, int lifeTime) {
        super(x, y, lifeTime);
    }

    @Override
    public void update() {
        lifeTime--;
    }

    @Override
    public Color getColor() {
        return Color.DARK_GRAY;
    }
}