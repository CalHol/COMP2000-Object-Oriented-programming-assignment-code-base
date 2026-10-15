import Entities.Animals.Wolf;
import Entities.Animal.Sheep;
import Entities.Plants.shrub
import Entities.Plants.Tree;

import java.util.Random;
import java.util.ArrayList;
import java.util.Object;

public class EntitySpawner {

    private final Random rand;
    private final int spawn;
    
    public List<Entity> entities = new ArrayList<>();

    public EntitySpawner(int spawn) { 
        if (spawn < 0) {
            throw new IllegalArgumentException("Spawn must be greater than 0");
        }
        this.spawn = spawn;
    }
} 