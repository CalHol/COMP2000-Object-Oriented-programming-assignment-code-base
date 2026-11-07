public class Simulation {
    private static final int MIN_SPAWN_INTERVAL = 17;
    private static final int MAX_SPAWN_INTERVAL = 24;

    private final World world;

    public Simulation(int rows, int cols, EntityFactory entityFactory) {
        world = new World(rows, cols);
        world.addSpawner(new Spawner(entityFactory::createSheep, MIN_SPAWN_INTERVAL, MAX_SPAWN_INTERVAL));
        world.addSpawner(new Spawner(entityFactory::createWolf, MIN_SPAWN_INTERVAL, MAX_SPAWN_INTERVAL));
        world.addSpawner(new Spawner((x, y) -> entityFactory.createShrub(x, y, 1), MIN_SPAWN_INTERVAL, MAX_SPAWN_INTERVAL));
    }

    public void tick() {
        world.tick();
    }

    public World getWorld() {
        return world;
    }
}