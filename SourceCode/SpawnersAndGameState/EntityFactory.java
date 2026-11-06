public interface EntityFactory {
    Sheep createSheep(int x, int y);

    Wolf createWolf(int x, int y);

    Tree createTree(int x, int y, int growth);

    Shrub createShrub(int x, int y, int growth);
}