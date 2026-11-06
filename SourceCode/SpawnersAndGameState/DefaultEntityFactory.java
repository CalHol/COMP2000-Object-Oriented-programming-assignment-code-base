public class DefaultEntityFactory implements EntityFactory {
    @Override
    public Sheep createSheep(int x, int y) {
        return new Sheep(x, y);
    }

    @Override
    public Wolf createWolf(int x, int y) {
        return new Wolf(x, y);
    }

    @Override
    public Tree createTree(int x, int y, int growth) {
        return new Tree(x, y, growth);
    }

    @Override
    public Shrub createShrub(int x, int y, int growth) {
        return new Shrub(x, y, growth);
    }
}