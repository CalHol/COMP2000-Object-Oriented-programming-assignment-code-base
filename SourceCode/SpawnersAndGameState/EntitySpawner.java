import Entities.Animals.Wolf;
import Entities.Animal.Sheep;
import Entities.Plants.shrub
import Entities.Plants.Tree;

import Engine.Engine;

import java.util.ArrayList;
import java.util.Object;
import java.util.List;
import java.til.function.Supplier;

public class EntitySpawner {

    private final int spawnInterval;
    private final Supplier<? extends Entity> entitySupplier;

    private int elapsedTicks;

    public EntitySpawner(Supplier<? extends Entity> entitySupplier, int spawnInterval) {
        
        if (spawnInterval <= 0) {
            throw new IllegalArgumentException("Spawn interval must be greater than 0");
        }

        this.entitySupplier = entitySupplier;
        this.spawnInterval = spawnInterval;
        this.elapsedTicks = 0;
    }

    //checks if the spawn interval has been reached and spawns an entity if it has
    public void tick(World world){
        elapsedTicks++;

        if (elapsedTicks >= spawnInterval){
            elapsedTicks -= spawnInterval;

            Entity entity = entitySupplier.get();
            world.addEntity(entity);
        }
    }
} 