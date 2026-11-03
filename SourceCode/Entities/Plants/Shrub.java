
import java.awt.Color;

public class Shrub extends Plant {
    public Shrub(int x, int y, int growth) {
        super(x, y, growth);
    }

    @Override
    public Color getColor() {
        return new Color(0, 255, 0);
    }
}