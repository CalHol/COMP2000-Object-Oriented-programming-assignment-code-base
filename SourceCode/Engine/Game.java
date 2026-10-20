public class Game{ 
    World world = new World();

    world.addSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Sheep(0, 0, "white")));
    world.addSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Wolf(0, 0, 0)));



}