public class SheepEat {
    public void eatSheep(Sheep sheep) {
        if (sheep != null) {
            sheep.move(sheep.getX(), sheep.getY());
        }
    }
}