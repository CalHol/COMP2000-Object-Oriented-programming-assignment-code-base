import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;

public class World {
    private final int rows;
    private final int cols;
    private final List<Entity> entities = new ArrayList<>();
    private final List<Spawner> spawners = new ArrayList<>();
    private final Random random = new Random();

    public World(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
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

    public boolean addEntityAtRandomLocation(BiFunction<Integer, Integer, Entity> entityFactory) {
        List<int[]> emptyLocations = new ArrayList<>();
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (getEntityAt(x, y) == null) {
                    emptyLocations.add(new int[] {x, y});
                }
            }
        }

        if (emptyLocations.isEmpty()) {
            return false;
        }

        int[] location = emptyLocations.get(random.nextInt(emptyLocations.size()));
        addEntity(entityFactory.apply(location[0], location[1]));
        return true;
    }

    public Entity getEntityAt(int x, int y) {
        for (Entity entity : entities) {
            if (entity.getX() == x && entity.getY() == y) {
                return entity;
            }
        }
        return null;
    }

    public List<Entity> getEntities() {
        return new ArrayList<>(entities);
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x < cols && y >= 0 && y < rows;
    }

    public void tick() {
        for (Spawner spawner : spawners) {
            spawner.tick(this);
        }

        for (Entity entity : new ArrayList<>(entities)) {
            entity.incrementAge();
            if (entity instanceof Shrub && entity.getAge() >= 25) {
                Shrub shrub = (Shrub) entity;
                entities.remove(shrub);
                entities.add(new Tree(shrub.getX(), shrub.getY(), shrub.getGrowth()));
            } else if (entity instanceof Animal) {
                Animal animal = (Animal) entity;
                if (animal instanceof Sheep) {
                    moveSheepTowardClosestShrub((Sheep) animal);
                } else if (animal instanceof Wolf) {
                    moveWolfTowardClosestSheep((Wolf) animal);
                }
                animal.update();
                if (animal.getLifeTime() >= 50) {
                    entities.remove(animal);
                }
            }
        }
    }

    private void moveSheepTowardClosestShrub(Sheep sheep) {
        Shrub closestShrub = null;
        int closestDistance = Integer.MAX_VALUE;

        for (Entity entity : entities) {
            if (entity instanceof Shrub) {
                Shrub shrub = (Shrub) entity;
                int distance = Math.abs(shrub.getX() - sheep.getX())
                        + Math.abs(shrub.getY() - sheep.getY());
                if (distance < closestDistance) {
                    closestShrub = shrub;
                    closestDistance = distance;
                }
            }
        }

        if (closestShrub == null || closestDistance == 0) {
            return;
        }

        if (closestDistance == 1) {
            if (entities.remove(closestShrub)) {
                sheep.incrementEatCount();
            }
            return;
        }

        if (sheep.getLifeTime() % 2 != 0) {
            return;
        }

        int stepX = Integer.compare(closestShrub.getX(), sheep.getX());
        int stepY = Integer.compare(closestShrub.getY(), sheep.getY());

        if (stepX != 0 && getEntityAt(sheep.getX() + stepX, sheep.getY()) == null) {
            sheep.move(sheep.getX() + stepX, sheep.getY());
        } else if (stepY != 0 && getEntityAt(sheep.getX(), sheep.getY() + stepY) == null) {
            sheep.move(sheep.getX(), sheep.getY() + stepY);
        }
    }

    private void moveWolfTowardClosestSheep(Wolf wolf) {
        Sheep closestSheep = null;
        int closestDistance = Integer.MAX_VALUE;

        for (Entity entity : entities) {
            if (entity instanceof Sheep) {
                Sheep sheep = (Sheep) entity;
                int distance = Math.abs(sheep.getX() - wolf.getX())
                        + Math.abs(sheep.getY() - wolf.getY());
                if (distance < closestDistance) {
                    closestSheep = sheep;
                    closestDistance = distance;
                }
            }
        }

        if (closestSheep == null) {
            return;
        }

        if (closestDistance <= 1) {
            if (entities.remove(closestSheep)) {
                wolf.incrementEatCount();
            }
            return;
        }

        int stepX = Integer.compare(closestSheep.getX(), wolf.getX());
        int stepY = Integer.compare(closestSheep.getY(), wolf.getY());

        if (stepX != 0 && getEntityAt(wolf.getX() + stepX, wolf.getY()) == null) {
            wolf.move(wolf.getX() + stepX, wolf.getY());
        } else if (stepY != 0 && getEntityAt(wolf.getX(), wolf.getY() + stepY) == null) {
            wolf.move(wolf.getX(), wolf.getY() + stepY);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}