public class WolfBehavior implements AnimalBehavior {
    @Override
    public void act(Animal animal, World world) {
        Wolf wolf = (Wolf) animal;
        Sheep closestSheep = null;
        int closestDistance = Integer.MAX_VALUE;

        for (Entity entity : world.getEntities()) {
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
            if (world.removeEntity(closestSheep)) {
                wolf.incrementEatCount();
            }
            return;
        }

        int stepX = Integer.compare(closestSheep.getX(), wolf.getX());
        int stepY = Integer.compare(closestSheep.getY(), wolf.getY());

        if (stepX != 0 && world.getEntityAt(wolf.getX() + stepX, wolf.getY()) == null) {
            wolf.move(wolf.getX() + stepX, wolf.getY());
        } else if (stepY != 0 && world.getEntityAt(wolf.getX(), wolf.getY() + stepY) == null) {
            wolf.move(wolf.getX(), wolf.getY() + stepY);
        }
    }
}