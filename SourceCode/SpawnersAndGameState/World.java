import java.util.ArrayList;
import java.util.List;


public class World {
    private final List<Entity> entities = new ArrayList<>();
    private final List<EntitySpawner> spawners = new ArrayList<>();

    public void addSpawner(EntitySpawner spawner){
        spawners.add(spawner);
    }

    public void spawnEntity(Entity entity){
        entities.add(entity);
    }

    public void tick() {
        for (EntitySpawner spawner : spawners) {
            spawner.tick(this);
        }
        for (Entity entity : entities) {
            entity.update();
        }
    }

    public List<Entity> getEntities() {
        return List.copyOf(entities);
    }
}