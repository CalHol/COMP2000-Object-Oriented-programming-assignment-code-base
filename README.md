# COMP2000-Object-Oriented-programming-assignment-code-base

This will be a basic life simualtion using OO programing practices

### What it Represents
there are four classes; sheep, wolf, shurb, tree. each are classified and built by the Animal abstract class or Plant abstract class. 

### Animal

Variables:
- X: the instances X position on the grid
- Y: the instances Y position on the grid
- Lifetime: A counter to represent how many tick the target has been since instantiated or last eaten
- EatCount: a counter to show how many times the unique instance has eaten
- Behaviour: holds the behaviour function

functions: 
- Move: moves the instance across the grid
- Act: moves the instance toward the nearest target (wolf --> sheep, sheep --> shrub) and destroys the target when in an adjacent cell

#### Sheep
The sheep will move toward the closest shrub, when reaches an adjacent square the shrub will be destroyed, the counter for 'eat' will increment by one, and the instances lifetime variable will reset.  

The sheep moves slower than the wolf, however sheep spawn more often, this is by design to make the demonstration last longer
#### wolf
The wolf will move toward the closest sheep, when reaches an adjacent square the sheep will be destroyed, the counter for 'eat' will increment by one, and the isntances lifetime variable will reset.

### Plant

#### Shrub



#### Tree

To run the code first run:
1. cd SourceCode
2. mkdir -p out
3. javac -d out $(find . -name '*.java')
4. java -cp out main