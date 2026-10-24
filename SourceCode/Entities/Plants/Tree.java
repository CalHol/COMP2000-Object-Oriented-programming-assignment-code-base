
import java.awt.Color;

public class Tree extends Plant {
    public Tree(int x, int y, int growth) {
        super(x, y, growth);
    }

    public void expand(int amount) {
        growth += amount;
    }

    @Override
    public Color getColor() {
        return new Color(34, 139, 34);
    }
}