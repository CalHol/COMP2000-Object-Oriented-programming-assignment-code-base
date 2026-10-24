public class AnimalMove {
    public void moveAnimal(Entity entity) {
        if (entity != null) {
            entity.move(entity.getX(), entity.getY());
        }
    }
}