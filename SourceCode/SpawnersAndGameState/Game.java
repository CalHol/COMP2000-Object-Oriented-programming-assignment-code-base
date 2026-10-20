public class Game{ 
    World world = new World();

    //add spawners to the world
    //need to randomise spawns and set proper tick rates     
    world.addSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Sheep(0, 0, "white")));
    world.addSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Wolf(0, 0, 10)));

    world.AddSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Tree(0, 0)));
    world.AddSpawner(new EntitySpawner(0, 0, 10, 10, () -> new Shrub(0, 0)));

    for(int tick = 1; tick <= maxTicks; tick++){
        world.tick();
    }


}