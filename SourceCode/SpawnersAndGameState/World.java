import java.util.ArrayList;
import java.util.List;


public class World {
    private final int rows;
    private final int cols;
    private final List<Entity> entities;
    private final Random random = new Random();

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.entities = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            int x = random.nextInt(cols);
            int y = random.nextInt(rows);
            
            if ( getEntityAt(x, y) == null ) {
                entities.add(new Sheep(x, y, 10));
            }
        } 
    }

    Entity getEntityAt(int x, int y) {
        return entities.stream()
                .filter(entity -> entity.getX() == x && entity.getY() == y)
                .findFirst()
                .orElse(null);
                .collect(Collectors.toList());
    }

    boolean isInside(int x, int y) {
        return x >= 0 && x < cols 
            && y >= 0 && y < rows;
    }

    void update() {
        for int
    }



    // private final List<Entity> entities = new ArrayList<>();
    // private final List<EntitySpawner> spawners = new ArrayList<>();

    // public void addSpawner(EntitySpawner spawner){
    //     spawners.add(spawner);
    // }

    // public void spawnEntity(Entity entity){
    //     entities.add(entity);
    // }

    // public void tick() {
    //     for (EntitySpawner spawner : spawners) {
    //         spawner.tick(this);
    //     }
    //     for (Entity entity : entities) {
    //         entity.update();
    //     }
    // }

    // public List<Entity> getEntities() {
    //     return List.copyOf(entities);
    // }
}