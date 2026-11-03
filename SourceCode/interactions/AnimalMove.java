public class AnimalMove {
    public void moveAnimal(Animal animal) {
        if (animal != null) {
            animal.move(animal.getX(), animal.getY());
        }
    }
}