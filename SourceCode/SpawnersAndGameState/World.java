import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private final int rows;
    private final int cols;
    private final List<Entity> entities = new ArrayList<>();
    private final List<Spawner> spawners = new ArrayList<>();
    private final Random random = new Random();

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        for (int i = 0; i < 20; i++) {
            int x = random.nextInt(cols);
            int y = random.nextInt(rows);
            if (getEntityAt(x, y) == null) {
                entities.add(new Sheep(x, y, 10));
            }
        }
    }

    public void addSpawner(Spawner spawner) {
        spawners.add(spawner);
    }

    public void addEntity(Entity entity) {
        if (entity == null|| !isInside(entity.getX(), entity.getY())) {
            throw new IllegalArgumentException("Entity is null or out of bounds");
        }
        entities.add(entity);
    }

    public Entity getEntityAt(int x, int y) {
        for (Entity entity : entities) {
            if (entity.getX() == x && entity.getY() == y) {
                return entity;
            }
        }
        return null;
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

    public void tick() {
        for (Spawner spawner : spawners) {
            spawner.tick(this);
        }

        for (Entity entity : new ArrayList<>(entities)) {
            if (entity instanceof Animal) {
                ((Animal) entity).update();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}