import java.util.function.Supplier;

public class Spawner {
    private final int spawnInterval;
    private final Supplier<Entity> entitySupplier;
    private int elapsedTicks;

    public Spawner(Supplier<Entity> entitySupplier, int spawnInterval) {
        if (spawnInterval <= 0) {
            throw new IllegalArgumentException("Spawn interval must be greater than 0");
        }

        this.entitySupplier = entitySupplier;
        this.spawnInterval = spawnInterval;
        this.elapsedTicks = 0;
    }

    public void tick(World world) {
        elapsedTicks++;

        if (elapsedTicks >= spawnInterval) {
            elapsedTicks = 0;
            world.addEntity(entitySupplier.get());
        }
    }
}