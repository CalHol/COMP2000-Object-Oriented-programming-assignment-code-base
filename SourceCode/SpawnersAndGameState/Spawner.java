import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class Spawner {
    private final int minSpawnInterval;
    private final int maxSpawnInterval;
    private final BiFunction<Integer, Integer, Entity> entityFactory;
    private int elapsedTicks;
    private int spawnInterval;

    public Spawner(BiFunction<Integer, Integer, Entity> entityFactory, int minSpawnInterval, int maxSpawnInterval) {
        if (minSpawnInterval <= 0 || maxSpawnInterval < minSpawnInterval) {
            throw new IllegalArgumentException("Spawn interval range must be positive and ordered");
        }

        this.entityFactory = entityFactory;
        this.minSpawnInterval = minSpawnInterval;
        this.maxSpawnInterval = maxSpawnInterval;
        this.elapsedTicks = 0;
        this.spawnInterval = chooseSpawnInterval();
    }

    public void tick(World world) {
        elapsedTicks++;

        if (elapsedTicks >= spawnInterval) {
            elapsedTicks = 0;
            world.addEntityAtRandomLocation(entityFactory);
            spawnInterval = chooseSpawnInterval();
        }
    }

    private int chooseSpawnInterval() {
        int interval = ThreadLocalRandom.current().nextInt(minSpawnInterval, maxSpawnInterval + 1);
        return Math.max(1, interval / 2);
    }
}