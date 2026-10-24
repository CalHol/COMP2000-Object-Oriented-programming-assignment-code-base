
public abstract class Plant extends Entity {
    protected int growth;

    public Plant(int x, int y, int growth) {
        super(x, y);
        this.growth = growth;
    }

    public int getGrowth() {
        return growth;
    }

    public void grow() {
        growth++;
    }
}