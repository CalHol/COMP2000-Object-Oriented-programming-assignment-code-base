public class Game {
    public static void main(String[] args) {
        World world = new World(32, 32);

        world.addSpawner(new Spawner((x, y) -> new Sheep(x, y, 10), 17, 24));
        world.addSpawner(new Spawner((x, y) -> new Wolf(x, y, 10), 17, 24));
        world.addSpawner(new Spawner((x, y) -> new Tree(x, y, 1), 17, 24));
        world.addSpawner(new Spawner((x, y) -> new Shrub(x, y, 1), 17, 24));

        for (int tick = 1; tick <= 100; tick++) {
            world.tick();
        }
    }
}