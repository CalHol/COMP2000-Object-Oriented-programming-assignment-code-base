import Entities.Animals.Wolf;
import Entities.Animal.Sheep;
import Entities.Plants.shrub
import Entities.Plants.Tree;

import Engine.Engine;

import java.util.Random;
import java.util.ArrayList;
import java.util.Object;
import java.util.List;

public class EntitySpawner {

    private final Random rand;

    private final List<Sheep> sheep = new ArrayList<>();
    private final List<Wolf> wolves = new ArrayList<>();
    private final List<Tree> trees = new ArrayList<>();
    private final List<Shrub> shrubs = new ArrayList<>();
    

    public EntitySpawner(Random rand){
        this.rand = rand;
    }

    public void spawnSheep(int count){
        for (int i = 0; i < count; i++){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            Sheep s = new Sheep(x, y, 10, 50);
            sheep.add(s);
        }
    }

    public void spawnWolves(int count){
        for (int i = 0; i < count; i++){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            Wolf w = new Wolf(x, y, 10);
            wolves.add(w);
        }
    }

    public void spawnTrees(int count){
        for (int i = 0; i < count; i++){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            Tree t = new Tree(10, x, y, 10, 50);
            trees.add(t);
        }
    }
} 