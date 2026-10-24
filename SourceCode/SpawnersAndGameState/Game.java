public class Game {
    public static void main(String[] args) {
        World world = new World(32, 32);

        world.addSpawner(new Spawner(() -> new Sheep(0, 0, 10), 10));
        world.addSpawner(new Spawner(() -> new Wolf(0, 0, 10), 20));
        world.addSpawner(new Spawner(() -> new Tree(0, 0, 1), 25));
        world.addSpawner(new Spawner(() -> new Shrub(0, 0, 1), 15));

        for (int tick = 1; tick <= 100; tick++) {
            world.tick();
        }
    }
}