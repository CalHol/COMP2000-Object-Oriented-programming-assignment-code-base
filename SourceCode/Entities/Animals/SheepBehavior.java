public class SheepBehavior implements AnimalBehavior {
    @Override
    public void act(Animal animal, World world) {
        Sheep sheep = (Sheep) animal;
        Shrub closestShrub = null;
        int closestDistance = Integer.MAX_VALUE;

        for (Entity entity : world.getEntities()) {
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
            if (world.removeEntity(closestShrub)) {
                sheep.incrementEatCount();
            }
            return;
        }

        if (sheep.getLifeTime() % 2 != 0) {
            return;
        }

        int stepX = Integer.compare(closestShrub.getX(), sheep.getX());
        int stepY = Integer.compare(closestShrub.getY(), sheep.getY());

        if (stepX != 0 && world.getEntityAt(sheep.getX() + stepX, sheep.getY()) == null) {
            sheep.move(sheep.getX() + stepX, sheep.getY());
        } else if (stepY != 0 && world.getEntityAt(sheep.getX(), sheep.getY() + stepY) == null) {
            sheep.move(sheep.getX(), sheep.getY() + stepY);
        }
    }
}