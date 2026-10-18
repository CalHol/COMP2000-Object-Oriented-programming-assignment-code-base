import Engine.EntitySpawner;
import Entities.Animals.shrub;

public class ShrubToPlant {
    private final EntitySpawner spawner;

    public ShrubToPlant(EntitySpawner spawner) {
        this.spawner = spawner;
    }

    public void convertShrub(Shrub shrub) {
        if (shrub.grow >= 10) {
            // Convert shrub to plant
            Tree tree = new Tree(shrub.grow, shrub.x, shrub.y, shrub.size, shrub.lifetime);
            spawner.add(tree);
            spawner.shrubs.remove(shrub);
        }
    }
}